package moduleSet;

import stringcheck.PositionLatcheck;
import stringcheck.PositionLngcheck;
import stringcheck.regularExpressionChcek;
import idcheck.Id_19check;

public class CheckTollPlazaUpload_19 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static boolean [] array = {false, false,false,false,false,
		false,false,false};
	
	static final String userUploaddw[] = {"id","name","plazaType","stakeNum","ETCLaneCount",
		"MTCLaneCount","mixLaneCount","operation"};
	
	public static String checkRequiredKey(){  //8项必填
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
	
	public static String checkTollPlazaUpload(String key, Object obj){  //OBU黑名单信息校验
		if(key.equals("id")) return checkId(obj);
		 else if(key.equals("name")) return checkName(obj);
		 else if(key.equals("plazaType")) return checkPlazaType(obj);
		 else if(key.equals("stakeNum")) return checkStakeNum(obj);
		 else if(key.equals("lat")) return checkLat(obj);
		 else if(key.equals("lng")) return checkLng(obj);
		 else if(key.equals("ETCLaneCount")) return checkETClaneCount(obj);
		 else if(key.equals("MTCLaneCount")) return checkMTClaneCount(obj);
		 else if(key.equals("mixLaneCount")) return checkMixLaneCount(obj);
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_19check Id19=new Id_19check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String; 
		 if(type)
		 {
			 return Id19.check(id.toString());
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
	
	public static String checkPlazaType(Object plazaType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		if(plazaType == null || (plazaType.toString()).length() <= 0
				|| plazaType.toString().equals("null") || plazaType.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = plazaType instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(plazaType.toString());
			 if(i>=1&&i<=2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkLat(Object lat){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		PositionLatcheck latTemp=new PositionLatcheck();
		 if(lat == null || (lat.toString()).length() <= 0
				 || lat.toString().equals("null") || lat.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = lat instanceof String; 
		 if(type)
		 {
			 return latTemp.check(lat.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkLng(Object lng){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		PositionLngcheck lngTemp=new PositionLngcheck();
		 if(lng == null || (lng.toString()).length() <= 0
				 || lng.toString().equals("null") || lng.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = lng instanceof String; 
		 if(type)
		 {
			 return lngTemp.check(lng.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkStakeNum(Object stakeNum) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		if (stakeNum == null || (stakeNum.toString()).length() <= 0
				|| stakeNum.toString().equals("null") || stakeNum.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type1 = stakeNum instanceof String;
		if (type1) {
			if (stakeNum.toString().length() <= 20) {
				return "right";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
	
	public static String checkETClaneCount(Object ETClaneCount) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[4] = true;
		if (ETClaneCount == null || (ETClaneCount.toString()).length() <= 0
				|| ETClaneCount.toString().equals("null") || ETClaneCount.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type1 = ETClaneCount instanceof Integer;
		if (type1) {
			if (Integer.parseInt(ETClaneCount.toString()) >= 0) {
				return "right";
			} else
				return "编码范围有误";
		}
		return "数据类型不符";
	}
	
	public static String checkMTClaneCount(Object MTClaneCount){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[5] = true;
		if(MTClaneCount == null || (MTClaneCount.toString()).length() <= 0
				|| MTClaneCount.toString().equals("null") || MTClaneCount.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = MTClaneCount instanceof Integer;
		 if(type1)
		 {
			 if (Integer.parseInt(MTClaneCount.toString()) >= 0) {
					return "right";
				} else
					return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkMixLaneCount(Object mixLaneCount) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[6] = true;
		if (mixLaneCount == null || (mixLaneCount.toString()).length() <= 0
				|| mixLaneCount.toString().equals("null") || mixLaneCount.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type1 = mixLaneCount instanceof Integer;
		if (type1) {
			if (Integer.parseInt(mixLaneCount.toString()) >= 0) {
				return "right";
			} else
				return "编码范围有误";
		}
		return "数据类型不符";
	}

	public static String checkOperation(Object operation) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[7] = true;
		if (operation == null || (operation.toString()).length() <= 0
				|| operation.toString().equals("null") || operation.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean Type = operation instanceof Integer;
		if (Type) {
			int i = Integer.parseInt(operation.toString());
			if (i >= 1 && i <= 3) {
				return "right";
			} else
				return "编码范围有误";
		}
		return "数据类型不符";
	}
}
