package moduleSet;

import stringcheck.PositionLatcheck;
import stringcheck.PositionLngcheck;
import stringcheck.TimeDatecheck;
import stringcheck.regularExpressionChcek;
import idcheck.Id_15check;
import idcheck.Id_16check;
import idcheck.Id_17check;

public class CheckSectionUpload_17 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static boolean [] array = {false, false,false,false,false,
		false,false,false,false,false,
		false,false,false,false,false};
	
	static final String userUploaddw[] = {"id","name","type","length","startStakeNum",
		"endStakeNum","tax","taxRate","sectionOwnerId","chargeType",
		"tollRoads","builtTime","startTime","endTime","operation"};

	public static String checkRequiredKey() { // 15项
		String results = "";

		for (int i = 0; i < array.length; i++) {
			if (array[i] == false) {
				if (results.equals("")) {
					results = userUploaddw[i];
				} else
					results = results + "," + userUploaddw[i];
			}
		}
		initArray();
		return results;

	}

	public static void initArray() { // 初始化array数组,参数
		for (int i = 0; i < array.length; i++) {
			array[i] = false;
		}
	}
	
	public static String checkSectionUpload(String key, Object obj){  //OBU黑名单信息校验
		if(key.equals("id")) return checkId(obj);
		 else if(key.equals("name")) return checkName(obj);
		 else if(key.equals("type")) return checktype(obj);
		 else if(key.equals("length")) return checkLength(obj);
		 else if(key.equals("startStakeNum")) return checkStartStakeNum(obj);
		 else if(key.equals("startLat")) return checkStartLat(obj);  //非必填
		 else if(key.equals("startLng")) return checkStartLng(obj);  //非必填
		 else if(key.equals("endStakeNum")) return checkEndStakeNum(obj);
		 else if(key.equals("endLat")) return checkEndLat(obj);  //非必填
		 else if(key.equals("endLng")) return checkEndLng(obj);  //非必填
		 else if(key.equals("tax")) return checkTax(obj); 
		 else if(key.equals("taxRate")) return checkTaxRate(obj);
		 else if(key.equals("sectionOwnerId")) return checkSectionOwnerId(obj);
		 else if(key.equals("chargeType")) return checkChargeType(obj);
		 else if(key.equals("tollRoads")) return checkTollRoads(obj);
		 else if(key.equals("builtTime")) return checkBuiltTime(obj);
		 else if(key.equals("startTime")) return checkStartTime(obj);
		 else if(key.equals("endTime")) return checkEndTime(obj);
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true;
		Id_17check Id17=new Id_17check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return Id17.check(id.toString());
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
			 if(i>=1&&i<=2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkLength(Object length) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		if (length == null || (length.toString()).length() <= 0
				|| length.toString().equals("null") || length.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type1 = length instanceof Integer;
		if (type1) {
			if (length.toString().length() >= 0) {
				return "right";
			}
			else return "编码范围有误";
		}
		return "数据类型不符";
	}
	
	public static String checkStartLat(Object startLat){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		PositionLatcheck latTemp = new PositionLatcheck();
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
	
	public static String checkEndStakeNum(Object endStakeNum){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[5] = true;
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
	
	public static String checkTax(Object tax){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[6] = true;
		if(tax == null || (tax.toString()).length() <= 0
				|| tax.toString().equals("null") || tax.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = tax instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(tax.toString());
			 if(i>=1&&i<=2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkTaxRate(Object taxRate){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[7] = true; 
		if(taxRate == null || (taxRate.toString()).length() <= 0
				|| taxRate.toString().equals("null") || taxRate.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
//		 boolean type3 = taxRate instanceof Integer;  //当为整型0时允许通过
//		 if(type3){
//			 if(Integer.parseInt(taxRate.toString()) == 0){
//				 return "right";
//			 }
//			 else return "数据类型不符";
//		 }
		 boolean type1 = taxRate instanceof Float;
		 boolean type2 = taxRate instanceof Double;
		 if(type1 || type2)
		 {
			 if(Double.parseDouble(taxRate.toString()) >= 0 && Double.parseDouble(taxRate.toString()) <= 1){  //非负
				 return "right";
			 } else
			 return "税率值范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkSectionOwnerId(Object sectionOwnerId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[8] = true; 
		Id_15check Id15=new Id_15check();
		 if(sectionOwnerId == null || (sectionOwnerId.toString()).length() <= 0
				 || sectionOwnerId.toString().equals("null") || sectionOwnerId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = sectionOwnerId instanceof String; 
		 if(type)
		 {
			 return Id15.check(sectionOwnerId.toString());
		 }
		 return "数据类型不符";
	 }
	
	 public static String checkChargeType(Object chargeType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[9] = true;
		 if(chargeType == null || (chargeType.toString()).length() <= 0
				 || chargeType.toString().equals("null") || chargeType.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = chargeType instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(chargeType.toString());
			 if(i>=1&&i<=3) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkTollRoads(Object tollRoads){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[10] = true;
		 Id_16check Id16=new Id_16check();
		 if(tollRoads == null || (tollRoads.toString()).length() <= 0
				 || tollRoads.toString().equals("null") || tollRoads.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = tollRoads instanceof String; 
		 if(type)
		 {
			 if(tollRoads.toString().contains("|")) {
				 String[] strTemp = tollRoads.toString().split("\\|");  //转义字符
				 for(String str:strTemp){
					 //System.out.println("split:"+str);
					 if( !Id16.check(str).equals("right")){
						 return Id16.check(str);
					 }
				 }
				 return "right";
			 }
			 else{
				 return Id16.check(tollRoads.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkBuiltTime(Object builtTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[11] = true;
		 TimeDatecheck TimeDatecheckTemp=new TimeDatecheck();
		 if(builtTime == null || (builtTime.toString()).length() <= 0
				 || builtTime.toString().equals("null") || builtTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = builtTime instanceof String; 
		 if(type)
		 {
			 if(TimeDatecheckTemp.check_len10(builtTime.toString()).equals("0") 
					 || TimeDatecheckTemp.check_len10(builtTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeDatecheckTemp.check_len10(builtTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeDatecheckTemp.check_len10(builtTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkStartTime(Object startTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[12] = true;
		 TimeDatecheck TimeDatecheckTemp=new TimeDatecheck();
		 if(startTime == null || (startTime.toString()).length() <= 0
				 || startTime.toString().equals("null") || startTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = startTime instanceof String; 
		 if(type)
		 {
			 if(TimeDatecheckTemp.check_len10(startTime.toString()).equals("0")
					 || TimeDatecheckTemp.check_len10(startTime.toString()).equals("1")
					   || TimeDatecheckTemp.check_len10(startTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeDatecheckTemp.check_len10(startTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEndTime(Object endTime){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[13] = true;
		 TimeDatecheck TimeDatecheckTemp=new TimeDatecheck();
		 if(endTime == null || (endTime.toString()).length() <= 0
				 || endTime.toString().equals("null") || endTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = endTime instanceof String; 
		 if(type)
		 {
			 return TimeDatecheckTemp.check_Expire(endTime.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[14] = true;
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
