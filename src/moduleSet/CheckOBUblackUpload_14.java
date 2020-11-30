package moduleSet;

import java.text.ParseException;

import idcheck.*;
import stringcheck.*;

public class CheckOBUblackUpload_14 {
	
	public static boolean [] array = {false, false,false,false,false};
	
	static final String userUploaddw[] = {"issuerId","creationTime","OBUId","type","status"};
	
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
	 
	 public static String checkOBUblack(String key, Object obj) throws ParseException{  //OBU黑名单信息校验
		 if(key.equals("issuerId")) return checkIssuerId(obj);
		 else if(key.equals("creationTime")) return checkCreationTime(obj);
		 else if(key.equals("OBUId")) return checkOBUId(obj);
		 else if(key.equals("type")) return checktype(obj);
		 else if(key.equals("status")) return checkstatus(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkIssuerId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_1check check = new Id_1check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String; 
		 if(type)
		 {
			 return check.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	 /*编码规则：发行方编号(id)=省域编号（2）+参与方类型（2）+发行方顺序码（2）*/
	 
	 public static String checkCreationTime(Object time) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 TimeMomentcheck check = new TimeMomentcheck();
		 if(time == null || (time.toString()).length() <= 0
				 || time.toString().equals("null") || time.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = time instanceof String;
		 if(type)
		 {
			 if(check.checkStandard(time.toString()).equals("0") 
					 || check.checkStandard(time.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(check.checkStandard(time.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return check.checkStandard(time.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkOBUId(Object obu){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[2] = true;
		 Id_14check id14= new Id_14check();
		 if(obu == null || (obu.toString()).length() <= 0
				 || obu.toString().equals("null") || obu.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = obu instanceof String;
		 if(type)
		 {
			 return id14.check(obu.toString());
		 }
		 return "数据类型不符";
	 }
	 
     public static String checktype(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	 array[3] = true;
		 if(type == null || (type.toString()).length() <= 0
				 || type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if(i>=1&&i<=4) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
     
     public static String checkstatus(Object status){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	 array[4] = true;
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
}