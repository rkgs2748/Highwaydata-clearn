package moduleSet;

import idcheck.Id_4check;
import stringcheck.TimeDatecheck;

public class CheckMobileServiceUpload_4 {
public static boolean [] array = {false, false,false,false};
	
	static final String userUploaddw[] = {"id","startTime","endTime","operation"};  //4项必填

	
	public static String checkRequiredKey(){  
		String results = "";

			for(int i=0; i<array.length; i++){
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
	
	public static String checkMobileServiceUpload(String key, Object obj){
		 if(key.equals("id")) return checkId(obj);
		 else if (key.equals("startTime")) return checkStartTime(obj);
		 else if (key.equals("endTime")) return checkEndTime(obj);
		 else if (key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	}
	
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_4check check1 = new Id_4check();
		 if (id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if (type){
			 return check1.check(id.toString());
		 }
		return "数据类型不符";
	 }
	 
	 public static String checkStartTime(Object startTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 TimeDatecheck time1 = new TimeDatecheck();
		 if (startTime == null || (startTime.toString()).length() <= 0
				 || startTime.toString().equals("null") || startTime.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = startTime instanceof String;
		 if (type){
			 if(time1.check_len10(startTime.toString()).equals("0") 
					 || time1.check_len10(startTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(time1.check_len10(startTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return time1.check_len10(startTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEndTime(Object endTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[2] = true;
		 TimeDatecheck time1 = new TimeDatecheck();
		 if (endTime == null || (endTime.toString()).length() <= 0
				 || endTime.toString().equals("null") || endTime.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = endTime instanceof String;
		 if (type){
			 return time1.check_Expire(endTime.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[3] = true;
		 if (operation == null || (operation.toString()).length() <= 0
				 || operation.toString().equals("null") || operation.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = operation instanceof Integer;
		 if (type){
			 if (Integer.parseInt(operation.toString()) == 1 || Integer.parseInt(operation.toString()) == 2 || Integer.parseInt(operation.toString()) == 3){
				 return "right";
			 }
			 else
				 return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
}
