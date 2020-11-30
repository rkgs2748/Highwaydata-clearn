package moduleSet;

import stringcheck.PositionLatcheck;
import stringcheck.PositionLngcheck;
import stringcheck.regularExpressionChcek;
import idcheck.Id_16check;
import idcheck.Id_18check;

public class CheckTollroadUpload_16 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static boolean [] array = {false, false,false,false,false,false,false,false,false,false};
	
	static final String userUploaddw[] = {"id","name","level","startSite","startStakeNum",  //收费公路，10项必填
		"startStationId","endSite","endStakeNum","endStationId","operation"};
	
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
	
	public static void initArray(){  //初始化array数组
		for(int i=0; i<array.length; i++){
			array[i] = false;
		}
	}
	
	public static String checkTollroadUpload(String key, Object obj){
		if(key.equals("id")) return checkId(obj);
		 else if(key.equals("name")) return checkName(obj);
		 else if(key.equals("level")) return checkLevel(obj);
		 else if(key.equals("startSite")) return checkStartSite(obj);
		 else if(key.equals("startStakeNum")) return checkStartStakeNum(obj);
		 else if(key.equals("startStationId")) return checkStartStationId(obj);
		 else if(key.equals("startLat")) return checkStartLat(obj);  //非必填
		 else if(key.equals("startLng")) return checkStartLng(obj);  //非必填
		 else if(key.equals("endSite")) return checkEndSite(obj);
		 else if(key.equals("endStakeNum")) return checkEndStakeNum(obj);
		 else if(key.equals("endStationId")) return checkEndStationId(obj);
		 else if(key.equals("endLat")) return checkEndLat(obj);  //非必填
		 else if(key.equals("endLng")) return checkEndLng(obj);  //非必填
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_16check Id16=new Id_16check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return Id16.check(id.toString());
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
	
	public static String checkLevel(Object level){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		if(level == null || (level.toString()).length() <= 0
				|| level.toString().equals("null") || level.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = level instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(level.toString());
			 if((i>=0&&i<=4) || (i>=8&&i<=9)) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkStartSite(Object startSite){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		if(startSite == null || (startSite.toString()).length() <= 0
				|| startSite.toString().equals("null") || startSite.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = startSite instanceof String;
		 if(type1)
		 {
			 if ((startSite.toString()).length() <= 100) {
					if (rec.checkAddress(startSite.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkStartStakeNum(Object startStakeNum){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[4] = true;
		if(startStakeNum == null || (startStakeNum.toString()).length() <= 0
				|| startStakeNum.toString().equals("null") || startStakeNum.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = startStakeNum instanceof String;
		 if(type1)
		 {
			 if (startStakeNum.toString().length() <= 20) {
					return "right";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkStartStationId(Object startStationId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[5] = true;
		Id_18check Id18=new Id_18check();
		 if(startStationId == null || (startStationId.toString()).length() <= 0
				 || startStationId.toString().equals("null") || startStationId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = startStationId instanceof String; 
		 if(type)
		 {
			 return Id18.check(startStationId.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkStartLat(Object startLat){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 PositionLatcheck latTemp=new PositionLatcheck();
		 if(startLat == null || (startLat.toString()).length() <= 0
				 || startLat.toString().equals("null") || startLat.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = startLat instanceof String;
		 if(type)
		 {
			 return latTemp.check(startLat.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkStartLng(Object startLng){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		PositionLngcheck lngTemp=new PositionLngcheck();
		 if(startLng == null || (startLng.toString()).length() <= 0
				 || startLng.toString().equals("null") || startLng.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = startLng instanceof String; 
		 if(type)
		 {
			 return lngTemp.check(startLng.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkEndSite(Object endSite){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[6] = true;
		if(endSite == null || (endSite.toString()).length() <= 0
				|| endSite.toString().equals("null") || endSite.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = endSite instanceof String;
		 if(type1)
		 {
			 if ((endSite.toString()).length() <= 100) {
					if (rec.checkAddress(endSite.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkEndStakeNum(Object endStakeNum){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[7] = true;
		if(endStakeNum == null || (endStakeNum.toString()).length() <= 0
				|| endStakeNum.toString().equals("null") || endStakeNum.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = endStakeNum instanceof String;
		 if(type1)
		 {
			 if (endStakeNum.toString().length() <= 20) {
					return "right";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkEndStationId(Object endStationId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[8] = true;
		Id_18check Id18=new Id_18check();
		 if(endStationId == null || (endStationId.toString()).length() <= 0
				 || endStationId.toString().equals("null") || endStationId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = endStationId instanceof String; 
		 if(type)
		 {
			 return Id18.check(endStationId.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkEndLat(Object endLat){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		PositionLatcheck latTemp=new PositionLatcheck();
		 if(endLat == null || (endLat.toString()).length() <= 0
				 || endLat.toString().equals("null") || endLat.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = endLat instanceof String; 
		 if(type)
		 {
			 return latTemp.check(endLat.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkEndLng(Object endLng){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		PositionLngcheck lngTemp=new PositionLngcheck();
		 if(endLng == null || (endLng.toString()).length() <= 0
				 || endLng.toString().equals("null") || endLng.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = endLng instanceof String;
		 if(type)
		 {
			 return lngTemp.check(endLng.toString());
		 }
		 return "数据类型不符";
	 }
	
	 public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[9] = true;
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
