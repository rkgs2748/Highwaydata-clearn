package moduleSet;

import idcheck.Id_10check;
import idcheck.Id_28check;
import idcheck.Id_8check;

public class CheckRefundUpload2_28 {
	 private final static long maxFee = 9223372036854775807L;  //最大的Long型值范围
	 public static boolean [] array = {false,false,false,false};
		
		static final String userUploaddw[] = {"id","userId","cardId","fee"};
		
		public static String checkRequiredKey(){  //4必填项
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
	 
	 public static String checkRefund(String key, Object obj){
		 if(key.equals("id")) return checkId(obj);
		 else if(key.equals("userId")) return checkUserId(obj);
		 else if(key.equals("cardId")) return checkCardId(obj);
		 else if(key.equals("fee")) return checkFee(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_28check checktemp=new Id_28check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return checktemp.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkUserId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 Id_8check checktemp=new Id_8check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return checktemp.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkCardId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[2] = true;
		 Id_10check checktemp=new Id_10check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return checktemp.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkFee(Object fee){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[3] = true;
		 if(fee == null || (fee.toString()).length() <= 0
				 || fee.toString().equals("null") || fee.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = fee instanceof Integer;
		 boolean type2 = fee instanceof Long;
		 if(type1 || type2)
		 {
			 long i=Long.parseLong(fee.toString());
			 if(i>=0 && i<= maxFee) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
}