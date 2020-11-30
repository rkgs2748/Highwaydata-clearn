package moduleSet;

import java.text.ParseException;

import stringcheck.TimeDatecheck;
import stringcheck.TimeMomentcheck;
import stringcheck.regularExpressionChcek;
import idcheck.Id_14check;
import idcheck.Id_3check;
import idcheck.Id_4check;
import idcheck.Id_6check;
import idcheck.Id_8check;

public class CheckOBUUpload_12 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static int registeredTypeTemp = 0;
	public static int installTypeTemp = 0;
	public static String enableTimeTemp = null;
	
	public static boolean [] array = {false, false,false,false,false,
		false,false,false,false,false,
		false,false,false,false,false};
	
	static final String userUploaddw[] = {"id","brand","model","userId","vehicleId",
		"enableTime","expireTime","registeredType","registeredChannelId","registeredTime",
		"installType","installTime","status","statusChangeTime","operation"};
	
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
		registeredTypeTemp = 0;
		installTypeTemp = 0;
		enableTimeTemp = null;
	}
	
	public static String checkOBUUpload(String key, Object obj) throws ParseException{  //OBU信息校验
		if(key.equals("id")) return checkId(obj);
		 else if(key.equals("brand")) return checkBrand(obj);
		 else if(key.equals("model")) return checkModel(obj);
		 else if(key.equals("userId")) return checkUserId(obj);
		 else if(key.equals("vehicleId")) return checkVehicleId(obj);
		 else if(key.equals("enableTime")) return checkEnableTime(obj);
		 else if(key.equals("expireTime")) return checkExpireTime(obj);
		 else if(key.equals("registeredType")) return checkRegisteredType(obj);
		 else if(key.equals("registeredChannelId")) return checkRegisteredChannelId(obj);
		 else if(key.equals("registeredTime")) return checkRegisteredTime(obj);
		 else if(key.equals("installType")) return checkInstallType(obj);
		 else if(key.equals("installChannelId")) return checkInstallChannelId(obj);//非必填
		 else if(key.equals("installTime")) return checkInstallTime(obj);
		 else if(key.equals("status")) return checkStatus(obj);
		 else if(key.equals("statusChangeTime")) return checkStatusChangeTime(obj);
		 else if(key.equals("operation")) return checkOperation(obj);
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[0] = true;
		Id_14check id14 = new Id_14check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String; 
		 if(type)
		 {
			 return id14.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	
	public static String checkBrand(Object brand){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[1] = true;
		 if(brand == null || (brand.toString()).length() <= 0
				 || brand.toString().equals("null") || brand.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = brand instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(brand.toString());
			 if(i>=1&&i<=18) {return "right";}
			 else return "品牌范围有误，请报备案";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkModel(Object model){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		 if(model == null || (model.toString()).length() <= 0
				 || model.toString().equals("null") || model.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = model instanceof String;
		 if(type1)
		 {
			 if ((model.toString()).length() <= 100) {
					if (rec.checkSpecialChar(model.toString()) || model.toString().equals("0")) {  //特殊字符过滤
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkUserId(Object userId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
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
		array[4] = true;
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
		array[5] = true;
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
		array[6] = true;
    	TimeDatecheck timeDateTemp = new TimeDatecheck();
    	if(expireTime == null || (expireTime.toString()).length() <= 0
    			|| expireTime.toString().equals("null") || expireTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
    	
//    	if(enableTimeTemp == null){
//    		return "OBU启用时间不明确";
//    	}
    	
		 boolean type1 = expireTime instanceof String;
		 if(type1)
		 {
			 if(timeDateTemp.check_Expire(expireTime.toString()).equals("right")){
				 return "right";
//					 int expire = Integer.parseInt(expireTime.toString().subSequence(0, 4).toString());
//					 int enable = Integer.parseInt(enableTimeTemp.toString().subSequence(0, 4).toString());
//					 int expireMonth = Integer.parseInt(expireTime.toString().subSequence(5, 7).toString());
//					 int enableMonth = Integer.parseInt(enableTimeTemp.toString().subSequence(5, 7).toString());
//					 
//					 if(expire == enable){  //当启用与超时为同一年时，根据月份
//						 if(expireMonth < enableMonth){
//						   return "到期时间要大于启用时间";}
//					 }
//					 if(expire < enable){
//						 return "到期时间要大于启用时间";
//					 }
//					 if(expire-enable>10){
//						 return "到期时间与启用时间不超过10年";
//					 }
//					 else{
//						 if(expire-enable == 10){
//							 if(expireMonth > enableMonth){  //超时只考虑到月份
//							 return "到期时间与启用时间不超过10年";
//							 } else 
//								 return "right";
//						 }
//						 else return "right";
//					 }
			 }
			 else{
				 return timeDateTemp.check_Expire(expireTime.toString());
			 }
		 }
		 else return "数据类型不符";
	 }
	
	 public static String checkRegisteredType(Object registeredType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[7] = true;
		 if(registeredType == null || (registeredType.toString()).length() <= 0
				 || registeredType.toString().equals("null") || registeredType.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = registeredType instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(registeredType.toString());
			 if(i==1 || i==2) {
				 return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
    public static String checkRegisteredChannelId(Object registeredChannelId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[8] = true;
    	if(registeredChannelId == null || (registeredChannelId.toString()).length() <= 0
    			|| registeredChannelId.toString().equals("null") || registeredChannelId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = registeredChannelId instanceof String;
		 if(type1)
		 {
			 if (registeredTypeTemp==2){  //线下
				 if(registeredChannelId.toString().length()!=15 && registeredChannelId.toString().length()!=19) { return "注册方式为线下，服务网点编号长度有误";}
				 if(registeredChannelId.toString().length()==15){
					 Id_4check id4 = new Id_4check();  //流动服务网点，15
					 return id4.check(registeredChannelId.toString());
				 }
				 if(registeredChannelId.toString().length()==19){  //服务网点信息，19
					 Id_3check id3 = new Id_3check();
					 return id3.check(registeredChannelId.toString());
				 }
			 }
			 else if (registeredTypeTemp==1){  //线上
				 if(registeredChannelId.toString().length() != 15) {return "注册方式为线上，线上服务渠道编号长度有误";}
				 Id_6check check6 = new Id_6check();  //线上服务渠道，15
					 return check6.check(registeredChannelId.toString());
			 }
			 else
			 {
				 return "OBU注册方式不明确，无法确定该字段值";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkRegisteredTime(Object registeredTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[9] = true;
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(registeredTime == null || (registeredTime.toString()).length() <= 0
    			|| registeredTime.toString().equals("null") || registeredTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = registeredTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.checkStandard(registeredTime.toString()).equals("0") 
					 || TimeMomentTemp.checkStandard(registeredTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeMomentTemp.checkStandard(registeredTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeMomentTemp.checkStandard(registeredTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
    
	public static String checkInstallType(Object installType) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[10] = true;
		if (installType == null || (installType.toString()).length() <= 0
				|| installType.toString().equals("null") || installType.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean Type = installType instanceof Integer;
		if (Type) {
			int i = Integer.parseInt(installType.toString());
			if (i == 1 || i == 2) {
				return "right";
			} else
				return "编码范围有误";
		}
		return "数据类型不符";
	}

	public static String checkInstallChannelId(Object installChannelId) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		if (installChannelId == null || (installChannelId.toString()).length() <= 0
				|| installChannelId.toString().equals("null") || installChannelId.toString().equals("NULL")) {
			return "right";
		}
		boolean type1 = installChannelId instanceof String;
		if (type1) {
			if (installTypeTemp == 1) {
				if (installChannelId.toString().equals("0")) {
					return "right";
				}
				else return "OBU安装方式为自行安装，默认值有误";
			}
			else if (installTypeTemp == 2) {
				 if(installChannelId.toString().length()!=15 && installChannelId.toString().length()!=19) { return "OBU安装方式为网点安装，网点编号长度有误";}
				 if(installChannelId.toString().length()==15){
					 Id_4check id4 = new Id_4check();  //流动服务网点，15
					 return id4.check(installChannelId.toString());
				 }
				 if(installChannelId.toString().length()==19){  //服务网点信息，19
					 Id_3check id3 = new Id_3check();
					 return id3.check(installChannelId.toString());
				 }
			}
			else   // 若安装方式错误，则根据数据判断
			{
			return "OBU安装方式不明确，无法确定该字段值";
			}
		}
		return "数据类型不符";
	}
    
    public static String checkInstallTime(Object enableTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[11] = true;
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(enableTime == null || (enableTime.toString()).length() <= 0
    			|| enableTime.toString().equals("null") || enableTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = enableTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.checkStandard(enableTime.toString()).equals("0") 
					 || TimeMomentTemp.checkStandard(enableTime.toString()).equals("1")
					    || TimeMomentTemp.checkStandard(enableTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeMomentTemp.checkStandard(enableTime.toString());
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkStatus(Object status){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[12] = true;
		 if(status == null || (status.toString()).length() <= 0
				 || status.toString().equals("null") || status.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = status instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(status.toString());
			 if(i>=1 && i<=8) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkStatusChangeTime(Object enableTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[13] = true;
    	TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
    	if(enableTime == null || (enableTime.toString()).length() <= 0
    			|| enableTime.toString().equals("null") || enableTime.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = enableTime instanceof String;
		 if(type1)
		 {
			 if(TimeMomentTemp.checkStandard(enableTime.toString()).equals("0") 
					 || TimeMomentTemp.checkStandard(enableTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeMomentTemp.checkStandard(enableTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeMomentTemp.checkStandard(enableTime.toString());
			 }
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
