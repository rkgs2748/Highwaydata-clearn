package moduleSet;

import java.text.ParseException;

import idcheck.Id_10check;
import idcheck.Id_24check;
import stringcheck.TimeMomentcheck;

public class CheckReversalUpload_24 {
    public static boolean [] array = {false, false,false};
	
	static final String userUploaddw[] = {"id","effectiveTime","cardId"};
	
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
	
	 public static String checkReversal(String key, Object obj) throws ParseException{ 
		 if(key.equals("id")) return checkId(obj);
		 else if(key.equals("effectiveTime")) return checkEffectiveTime (obj);
		 else if(key.equals("cardId")) return checkCardId(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_24check checktemp=new Id_24check();
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
	 
	 public static String checkEffectiveTime(Object time) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 TimeMomentcheck tmc=new TimeMomentcheck();
		 if(time == null || (time.toString()).length() <= 0
				 || time.toString().equals("null") || time.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = time instanceof String;
		 if(type)
		 {
			 if(tmc.checkStandard(time.toString()).equals("0") 
					 || tmc.checkStandard(time.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(tmc.checkStandard(time.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return tmc.checkStandard(time.toString());
			 }
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
}