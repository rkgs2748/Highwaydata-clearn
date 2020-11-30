package moduleSet;

import idcheck.Id_10check;
import idcheck.Id_8check;

public class CheckBalanceUpload_11 {
	private final static long maxFee = 9223372036854775807L;  //最大的Long型值范围
	
	public static boolean [] array = {false, false,false};
	
	static final String userUploaddw[] = {"userId","cardId","fee"};
	
	public static String checkRequiredKey(){ 
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
	
	public static String BalanceUpload(String key, Object obj){ 
		if(key.equals("userId")) return checkUserId(obj);
		 else if(key.equals("cardId")) return checkCardId(obj);
		 else if(key.equals("fee")) return checkFee(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	
	public static String checkUserId(Object userId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true;
		 Id_8check id8= new Id_8check();
		 if(userId == null || (userId.toString()).length() <= 0
				 || userId.toString().equals("null") || userId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = userId instanceof String;
		 if(type)
		 {
			 return id8.check(userId.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkCardId(Object cardId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[1] = true;
		Id_10check id10 = new Id_10check();
		 if(cardId == null || (cardId.toString()).length() <= 0
				 || cardId.toString().equals("null") || cardId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = cardId instanceof String; 
		 if(type)
		 {
			 return id10.check(cardId.toString());
		 }
		 return "数据类型不符";
	 }
	public static String checkFee(Object fee){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		 if(fee == null || (fee.toString()).length() <= 0
				 || fee.toString().equals("null") || fee.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type1 = fee instanceof Integer;
		 boolean Type2 = fee instanceof Long;
		 if(Type1 || Type2)
		 {
			 long i=Long.parseLong(fee.toString());
			 if(i>=0 && i <= maxFee) {return "right";}   //不允许负值
			 else return "数值编码范围有误";
		 }
		 return "数据类型不符";
	 }
}
