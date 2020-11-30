package moduleSet;

import stringcheck.regularExpressionChcek;
import idcheck.Id_18check;

public class CheckTollstationUpload_18 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static int stationType=0; //收费站类型
	
	public static boolean [] array = {false, false,false,false,false,
		false};
	
	static final String userUploaddw[] = {"id","name","type","tollPlazaCount","neighborId",  //单位用户，17项必填（包含条件必填4项）
		"operation"};
	
	public static String checkRequiredKey(){  //6项必填
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
		stationType=0;
	}
	
	public static String checkTollstationUpload(String key, Object obj){  //OBU黑名单信息校验
		 if(key.equals("id")) return checkId(obj);
		 else if(key.equals("name")) return checkName(obj);
		 else if(key.equals("type")) return checktype(obj);
		 else if(key.equals("tollPlazaCount")) return checkTollPlazaCount(obj);
		 else if(key.equals("neighborId")) return checkNeighborId(obj);
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true; 
		Id_18check Id18=new Id_18check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return Id18.check(id.toString());
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
	
	public static String checktype(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true; 
		if(type == null || (type.toString()).length() <= 0
				|| type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if(i>=1&&i<=3) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkTollPlazaCount(Object tollPlazaCount){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true; 
		if(tollPlazaCount == null || (tollPlazaCount.toString()).length() <= 0
				|| tollPlazaCount.toString().equals("null") || tollPlazaCount.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = tollPlazaCount instanceof Integer;
		 if(type1)
		 {
			 return "right";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkNeighborId(Object neighborId) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[4] = true;
		if (neighborId == null || (neighborId.toString()).length() <= 0
				|| neighborId.toString().equals("null") || neighborId.toString().equals("NULL")) {
			return "必填项缺失";
		}
		
		if(neighborId.toString().equals("0"))  //省界站允许默认值0
		 {
			 return "right";
		 }
		
		Id_18check Id18 = new Id_18check();
		boolean type1 = neighborId instanceof String;
		if (type1) {
			if (stationType == 1 || stationType == 2) {
				if(neighborId.toString().length()!=14) {
					return "共建或分建省界站长度有误"; }
				if (Id18.check(neighborId.toString()).equals("right"))
					return "right";
				else
					return Id18.check(neighborId.toString());
			} else if (stationType == 3) {
				if (neighborId.toString().equals("0")) {
					return "right";
				} else
					return "其他类型收费站编码有误";
			} else
				return "收费站类型不确定";
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
