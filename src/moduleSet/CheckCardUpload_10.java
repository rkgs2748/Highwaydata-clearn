package moduleSet;

import java.text.ParseException;

import idcheck.Id_10check;
import idcheck.Id_2check;
import idcheck.Id_3check;
import idcheck.Id_4check;
import idcheck.Id_6check;
import idcheck.Id_8check;
import stringcheck.TimeMomentcheck;
import stringcheck.regularExpressionChcek;

public class CheckCardUpload_10 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static int issuedTypeTemp = 0;
	public static String enableTimeTemp = null;
	
	public static boolean [] array = {false, false,false,false,false,
		false,false,false,false,false,
		false,false,false};
	
	static final String userUploaddw[] = {"id","cardType","brand","agencyId","userId",  //用户卡，13项必填（包含条件必填4项）
		"vehicleId","enableTime","expireTime","issuedType","channelId",
		"issuedTime","status","operation"};
	
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
	
	public static void initArray(){  //初始化array数组,关联参数
		for(int i=0; i<array.length; i++){
			array[i] = false;
		}
		issuedTypeTemp = 0;
		enableTimeTemp = null;
	}
	
	public static String checkCardUpload(String key, Object obj) throws ParseException{  //OBU黑名单信息校验
		if(key.equals("id")) return checkId(obj);//必填
		 else if(key.equals("cardType")) return checkCardType(obj);//必填
		 else if(key.equals("brand")) return checkBrand(obj);//必填
		 else if(key.equals("model")) return checkModel(obj);
		 else if(key.equals("agencyId")) return checkAgencyId(obj);//必填
		 else if(key.equals("userId")) return checkUserId(obj);//必填
		 else if(key.equals("vehicleId")) return checkVehicleId(obj);//必填
		 else if(key.equals("enableTime")) return checkEnableTime(obj);//必填
		 else if(key.equals("expireTime")) return checkExpireTime(obj);//必填
		 else if(key.equals("issuedType")) return checkIssuedType(obj);//必填
		 else if(key.equals("channelId")) return checkChannelId(obj);//必填
		 else if(key.equals("issuedTime")) return checkIssuedTime(obj);//必填
		 else if(key.equals("status")) return checkStatus(obj);//必填
		 else if(key.equals("statusChangeTime")) return checkStatusChangeTime(obj);
		 else if(key.equals("operation")) return checkOperation(obj);//必填
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true;
		Id_10check id10 = new Id_10check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String; 
		 if(type)
		 {
			 return id10.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkCardType(Object cardType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[1] = true;
		 if(cardType == null || (cardType.toString()).length() <= 0
				 || cardType.toString().equals("null") || cardType.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = cardType instanceof Integer;
		 if(Type)
		 {
			 String temp = cardType.toString();
			 if(temp.length() != 3){  //过滤掉长度不为3的字符串
				 return "长度有误";
			 }
			 if(temp.charAt(0)=='1' || temp.charAt(0)=='2'){
				 if(temp.charAt(1)<='5' && temp.charAt(1)>='1'){
					 if(temp.charAt(2)<='3' && temp.charAt(2)>='1'){return "right";}
					 else return "卡类型第3位范围有误";
				 }
				 else return "卡类型第2位范围有误";
			 }
			 else return "卡类型第1位范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkBrand(Object brand){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		 if(brand == null || (brand.toString()).length() <= 0
				 || brand.toString().equals("null") || brand.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = brand instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(brand.toString());
			 if(i>=1&&i<=18) {return "right";}  //扩展至18
			 else return "卡品牌范围有误，请报备案";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkModel(Object model){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(model == null || (model.toString()).length() <= 0
				 || model.toString().equals("null") || model.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = model instanceof String;
		 if(type1)
		 {
			 if ((model.toString()).length() <= 100) {
					if (rec.checkSpecialChar(model.toString()) || model.toString().equals("0")) { //特殊字符过滤
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkAgencyId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		 Id_2check id2 = new Id_2check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String; 
		 if(type)
		 {
			 return id2.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkUserId(Object userId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[4] = true;
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
	
	public static String checkVehicleId(Object vehicleId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[5] = true;
		 //VehicleNumcheck VehicleNumTemp=new VehicleNumcheck();
		 if(vehicleId == null || (vehicleId.toString()).length() <= 0
				 || vehicleId.toString().equals("null") || vehicleId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = vehicleId instanceof String; 
		 if(type)
		 {
			 if(vehicleId.toString().length() <= 20){  //只校验是否超长
				 return "right";
			 } else
				 return "长度有误";
			 
			 //return VehicleNumTemp.check(vehicleId.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkEnableTime(Object enableTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[6] = true;
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(enableTime == null || (enableTime.toString()).length() <= 0
    			|| enableTime.toString().equals("null") || enableTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = enableTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.checkStandard(enableTime.toString()).equals("-1")||
					 TimeMomentTemp.checkStandard(enableTime.toString()).equals("0")||
					 TimeMomentTemp.checkStandard(enableTime.toString()).equals("1")){
				 return "right";
			 }
			 else{
				 return TimeMomentTemp.checkStandard(enableTime.toString());
			 }			 
		 }
		 return "数据类型不符";
	 }
	
	public static String checkExpireTime(Object expireTime) throws NumberFormatException, ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[7] = true;
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(expireTime == null || (expireTime.toString()).length() <= 0
    			|| expireTime.toString().equals("null") || expireTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
    	
//    	if(enableTimeTemp == null){
//    		return "卡启用时间不明确";
//    	}
    	
		 boolean type1 = expireTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.check_Expire(expireTime.toString()).equals("right")){
				 return "right";
//				 dateAndTime timeTemp = new dateAndTime();
//				 if(timeTemp.comparBetween(expireTime.toString(), enableTimeTemp)==1){
//					 int expire = Integer.parseInt(expireTime.toString().subSequence(0, 4).toString());
//					 int enable = Integer.parseInt(enableTimeTemp.toString().subSequence(0, 4).toString());
//					 if(expire-enable>500){
//						 return "到期时间与启用时间不超过500年";
//					 }
//					 else{
//						 return "right";
//					 }
//				 }
//				 else{
//					return "到期时间要大于启用时间";
//				 }
			 }
			 else{
				 return TimeMomentTemp.check_Expire(expireTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	
	public static String checkIssuedType(Object issuedType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[8] = true;
		 if(issuedType == null || (issuedType.toString()).length() <= 0
				 || issuedType.toString().equals("null") || issuedType.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = issuedType instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(issuedType.toString());
			 if(i==1 || i==2) {
				 return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	 public static String checkChannelId(Object channelId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[9] = true;
    	if(channelId == null || (channelId.toString()).length() <= 0
    			|| channelId.toString().equals("null") || channelId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = channelId instanceof String;
		 if(type1)
		 {
			 if (issuedTypeTemp==2){  //线下
				 if(channelId.toString().length()!=15 && channelId.toString().length()!=19) { return "开卡方式为线下，服务网点编号长度有误";}
				 if(channelId.toString().length()==15){
					 Id_4check id4 = new Id_4check();  //流动服务网点，15
					 return id4.check(channelId.toString());
				 }
				 if(channelId.toString().length()==19){  //服务网点信息，19
					 Id_3check id3 = new Id_3check();
					 return id3.check(channelId.toString());
				 }
			 }
			 else if (issuedTypeTemp==1){  //线上
				 if(channelId.toString().length() != 15) {return "开卡方式为线上，线上服务渠道编号长度有误";}
				 Id_6check check6 = new Id_6check();  //线上服务渠道，15
					 return check6.check(channelId.toString());
			 }
			 else
			 {
				 return "开卡方式不明确，无法确定该字段值";
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkIssuedTime(Object issuedTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[10] = true;
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(issuedTime == null || (issuedTime.toString()).length() <= 0
    			|| issuedTime.toString().equals("null") || issuedTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = issuedTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.checkStandard(issuedTime.toString()).equals("0")
					 || TimeMomentTemp.checkStandard(issuedTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeMomentTemp.checkStandard(issuedTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeMomentTemp.checkStandard(issuedTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkStatus(Object status){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[11] = true;
		 if(status == null || (status.toString()).length() <= 0
				 || status.toString().equals("null") || status.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = status instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(status.toString());
			 if(i>=1&&i<=6) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkStatusChangeTime(Object statusChangeTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(statusChangeTime == null || (statusChangeTime.toString()).length() <= 0
    			|| statusChangeTime.toString().equals("null") || statusChangeTime.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = statusChangeTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.checkStandard(statusChangeTime.toString()).equals("0") 
					 || TimeMomentTemp.checkStandard(statusChangeTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeMomentTemp.checkStandard(statusChangeTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeMomentTemp.checkStandard(statusChangeTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[12] = true;
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
