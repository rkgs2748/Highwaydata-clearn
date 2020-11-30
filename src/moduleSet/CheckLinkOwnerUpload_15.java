package moduleSet;

import stringcheck.regularExpressionChcek;
import stringcheck.telIdentification;
import idcheck.Id_15check;

public class CheckLinkOwnerUpload_15 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static boolean [] array = {false, false,false,false,false,
		false};
	
	static final String userUploaddw[] = {"id","name","contact","tel","address",  //单位用户，17项必填（包含条件必填4项）
			"operation"};
	
	public static String checkRequiredKey(){  //1为个人（13项），2为单位（17项）
		String results = "";

			for(int i=0; i<array.length; i++){
				//System.out.println("array： "+array[i]);
				if(array[i] == false){
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
				}
			}
			initArray();
			return results;		

	}
	
	public static void initArray(){  //初始化array数组,参数
		for(int i=0; i<array.length; i++){
			array[i] = false;
		}
	}
	
	public static String checkLinkOwnerUpload(String key, Object obj){  //OBU黑名单信息校验
		if(key.equals("id")) return checkId(obj);
		 else if(key.equals("name")) return checkName(obj);
		 else if(key.equals("contact")) return checkContact(obj);
		 else if(key.equals("tel")) return checkTel(obj);
		 else if(key.equals("address")) return checkAddress(obj);		 
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true;
		Id_15check Id15=new Id_15check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String; 
		 if(type)
		 {
			 return Id15.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkName(Object ownerName){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[1] = true;
		 if(ownerName == null || (ownerName.toString()).length() <= 0
				 || ownerName.toString().equals("null") || ownerName.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = ownerName instanceof String;
		 if(type1)
		 {
			 if ((ownerName.toString()).length() <= 50) {
					if (rec.checkName2(ownerName.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkContact(Object contact){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		 if(contact == null || (contact.toString()).length() <= 0
				 || contact.toString().equals("null") || contact.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = contact instanceof String;
		 if(type1)
		 {
			 if ((contact.toString()).length() <= 50) {
					if (rec.checkName1(contact.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkTel(Object tel){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		 if(tel == null || (tel.toString()).length() <= 0
				 || tel.toString().equals("null") || tel.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = tel instanceof String;
		 if(type1)
		 {
			 telIdentification telTemp = new telIdentification();
			 if ((tel.toString()).length() <= 20){
				 if(telTemp.identifyTel(tel.toString()).equals("right")){
				 return "right";
				 }
				 else return telTemp.identifyTel(tel.toString());
			 }
			 else
				 return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
   public static String checkAddress(Object address){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
	   array[4] = true;
		 if(address == null || (address.toString()).length() <= 0
				 || address.toString().equals("null") || address.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = address instanceof String;
		 if(type1)
		 {
			 if ((address.toString()).length() <= 100) {
					if (rec.checkAddress(address.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 } 
   
	 public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[5] = true;
		 if(operation == null || (operation.toString()).length() <= 0
				 || operation.toString().equals("null") || operation.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = operation instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(operation.toString());
			 if(i>=1&&i<=3) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
}
