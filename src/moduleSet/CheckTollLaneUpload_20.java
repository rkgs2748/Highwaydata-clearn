package moduleSet;

import idcheck.Id_1check;
import idcheck.Id_20check;
import stringcheck.TimeDatecheck;

public class CheckTollLaneUpload_20 {
	public static boolean [] array = {false, false,false,false,false,
		false,false,false};
	
	static final String userUploaddw[] = {"id","type","greenTraffic","tidalTime","startTime",  //单位用户，17项必填（包含条件必填4项）
		"endTime","status","operation"};
	
	public static String checkRequiredKey(){  //8必填项
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
	
	 public static String checkTollLane(String key, Object obj){
		 if(key.equals("id")) return checkId(obj);
		 else if(key.equals("type")) return checkType(obj);
		 else if(key.equals("greenTraffic")) return checkGreenTraffic(obj);
		 else if(key.equals("tidalTime")) return checkTidalTime(obj);
		 else if(key.equals("startTime")) return checkStartTime(obj);
		 else if(key.equals("endTime")) return checkEndTime(obj);
		 else if(key.equals("status")) return checkStatus(obj);
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if(key.equals("timeMillStr")) return "right";
		 else if(key.equals("weightCharge")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_20check checktemp=new Id_20check();
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
	 
	public static String checkType(Object type) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[1] = true;
		if (type == null || (type.toString()).length() <= 0
				|| type.toString().equals("null") || type.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type1 = type instanceof Integer;
		if (type1) {
			int i = 0;
			i = Integer.parseInt(type.toString());
			if (i >= 1 && i <= 3) {
				return "right";
			} else
				return "编码范围有误";
		}
		return "数据类型不符";
	}
	 
	 public static String checkGreenTraffic(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
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
			 if(i>=1&&i<=2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	public static String checkTidalTime(Object time) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		Id_1check checktemp = new Id_1check();
		if (time == null || (time.toString()).length() <= 0
				|| time.toString().equals("null") || time.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type = time instanceof String;
		if (type) {
			if (time.toString().length() == 8) {
				if (checktemp.isNumber(time.toString())) {
					return "right";
				} else
					return "格式有误";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
	 
	 public static String checkStartTime(Object time){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[4] = true;
		 TimeDatecheck checkdate = new TimeDatecheck();
		 if(time == null || (time.toString()).length() <= 0
				 || time.toString().equals("null") || time.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = time instanceof String;
		 if(type)
		 {
			 if(checkdate.check_len10(time.toString()).equals("0") 
					 || checkdate.check_len10(time.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(checkdate.check_len10(time.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return checkdate.check_len10(time.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEndTime(Object time){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[5] = true;
		 TimeDatecheck checkdate = new TimeDatecheck();
		 if(time == null || (time.toString()).length() <= 0
				 || time.toString().equals("null") || time.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = time instanceof String;
		 if(type)
		 {
			 return checkdate.check_Expire(time.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkStatus(Object status){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[6] = true;
		 if(status == null || (status.toString()).length() <= 0
				 || status.toString().equals("null") || status.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = status instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(status.toString());
			 if(i>=1&&i<=2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkOperation(Object status){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[7] = true;
		 if(status == null || (status.toString()).length() <= 0
				 || status.toString().equals("null") || status.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = status instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(status.toString());
			 if(i>=1&&i<=3) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
}