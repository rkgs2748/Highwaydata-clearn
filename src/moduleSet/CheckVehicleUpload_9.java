package moduleSet;

import java.text.ParseException;

import idcheck.Id_3check;
import idcheck.Id_4check;
import idcheck.Id_6check;
import idcheck.Id_8check;
import stringcheck.IdNumcheck;
import stringcheck.NumOrChar;
import stringcheck.TimeDatecheck;
import stringcheck.TimeMomentcheck;
import stringcheck.VehicleNumcheck;
import stringcheck.regularExpressionChcek;
import stringcheck.telIdentification;

public class CheckVehicleUpload_9 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static int registeredTypeTemp = 0;
	public static int ownerIdType = 100;  //初始化值100
	
	public static boolean [] array = {false, false,false,false,false,
		false,false,false,false};
	
	static final String userUploaddw[] = {"id","type","userId","contact","registeredType",  //客户车辆信息，9项必填
		"channelId","registeredTime","VIN","operation"};
	
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
		ownerIdType = 100;
	}
	
	public static String checkVehicleUpload(String key, Object obj) throws ParseException{
		if(key.equals("id")) return checkId(obj);//必填
		 else if(key.equals("type")) return checkType(obj); //必填
		 else if(key.equals("userId")) return checkUserId(obj);//必填
		 else if(key.equals("ownerName")) return checkOwnerName(obj);
		 else if(key.equals("ownerIdType")) return checkOwnerIdType(obj);
		 else if(key.equals("ownerIdNum")) return checkOwnerIdNum(obj);
		 else if(key.equals("ownerTel")) return checkOwnerTel(obj);
		 else if(key.equals("address")) return checkAddress(obj);
		 else if(key.equals("contact")) return checkContact(obj);//必填
		 else if(key.equals("registeredType")) return checkRegisteredType(obj);//必填
		 else if(key.equals("channelId")) return checkChannelId(obj);//必填
		 else if(key.equals("registeredTime")) return checkRegisteredTime(obj);//必填
		 else if(key.equals("vehicleType")) return checkVehicleType(obj);
		 else if(key.equals("vehicleModel")) return checkVehicleModel(obj);
		 else if(key.equals("useCharacter")) return checkUseCharacter(obj);
		 else if(key.equals("VIN")) return checkVIN(obj);//必填
		 else if(key.equals("engineNum")) return checkEngineNum(obj);
		 else if(key.equals("registerDate")) return checkRegisterDate(obj);
		 else if(key.equals("issueDate")) return checkIssueDate(obj);
		 else if(key.equals("fileNum")) return checkFileNum(obj);
		 else if(key.equals("approvedCount")) return checkApprovedCount(obj);
		 else if(key.equals("totalMass")) return checkTotalMass(obj);
		 else if(key.equals("maintenanceMass")) return checkMaintenanceMass(obj);
		 else if(key.equals("permittedWeight")) return checkPermittedWeight(obj);
		 else if(key.equals("outsideDimensions")) return checkOutsideDimensions(obj);
		 else if(key.equals("permittedTowWeight")) return checkPermittedTowWeight(obj);
		 else if(key.equals("testRecord")) return checkTestRecord(obj);
		 else if(key.equals("wheelCount")) return checkWheelCount(obj);
		 else if(key.equals("axleCount")) return checkAxleCount(obj);
		 else if(key.equals("axleDistance")) return checkAxleDistance(obj);
		 else if(key.equals("axisType")) return checkAxisType(obj);
		 else if(key.equals("operation")) return checkOperation(obj);//必填
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;//Id_8check check = new Id_8check();
		 VehicleNumcheck VehicleNumTemp=new VehicleNumcheck();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return VehicleNumTemp.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 if(type == null || (type.toString()).length() <= 0
				 || type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean Type = type instanceof Integer;
		 if(Type)
		 {
			 int i=Integer.parseInt(type.toString());
			 if((i>=1&&i<=4) || (i>=11&&i<=15)) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkUserId(Object userId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[2] = true;
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
	 
    public static String checkOwnerName(Object ownerName){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(ownerName == null || (ownerName.toString()).length() <= 0
				 || ownerName.toString().equals("null") || ownerName.toString().equals("NULL"))
		 {
			 return "right";
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
    
    public static String checkOwnerIdType(Object ownerIdType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(ownerIdType == null || (ownerIdType.toString()).length() <= 0
				 || ownerIdType.toString().equals("null") || ownerIdType.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = ownerIdType instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(ownerIdType.toString());
			 if((i>=101&&i<=106) || (i>=201&&i<=206) 
					 || i==199 || i==299) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkOwnerIdNum(Object ownerIdNum){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(ownerIdNum == null || (ownerIdNum.toString()).length() <= 0
				 || ownerIdNum.toString().equals("null") || ownerIdNum.toString().equals("NULL"))
		 {
			 return "right";
		 }

		 IdNumcheck idNumTemp = new IdNumcheck();
		 boolean type1 = ownerIdNum instanceof String;
		 if(type1)
		 {
			 if ((ownerIdNum.toString()).length() <= 30){
				 if(idNumTemp.checkIdNum(ownerIdType, ownerIdNum.toString()).equals("right")){
					 return "right";
				 }
				 else
					 return idNumTemp.checkIdNum(ownerIdType, ownerIdNum.toString());  //若校验失败，则返回提示信息
			 }
			 else
				 return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkOwnerTel(Object ownerTel){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(ownerTel == null || (ownerTel.toString()).length() <= 0
				 || ownerTel.toString().equals("null") || ownerTel.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = ownerTel instanceof String;
		 if(type1)
		 {
			 if(ownerTel.toString().equals("99999999999")){  //允许默认值
				 return "right";
			 }
			 if(ownerTel.toString().charAt(0) != '1' || ownerTel.toString().contains("-") || ownerTel.toString().length() != 11){  //判断不是手机号
					return "必须填写手机号码"; 
				 }
			 telIdentification telTemp = new telIdentification();
			 if(ownerTel.toString().length() >= 10 && ownerTel.toString().length() <= 20){
				 if (telTemp.identifyTel(ownerTel.toString()).equals("right")){
					 return "right";
				 }
				 else return telTemp.identifyTel(ownerTel.toString());
			 }
			 else return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkAddress(Object address){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(address == null || (address.toString()).length() <= 0
				 || address.toString().equals("null") || address.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = address instanceof String;
		 if(type1)
		 {
			 if ((address.toString()).length() <= 100) {
					if (rec.checkAddress(address.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkContact(Object contact){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[3] = true;
		 if(contact == null || (contact.toString()).length() <= 0
				 || contact.toString().equals("null") || contact.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = contact instanceof String;
		 if(type1)
		 {
			 if ((contact.toString()).length() <= 50) {
					if (rec.checkName1(contact.toString()) || contact.toString().equals("0")) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkRegisteredType(Object registeredType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[4] = true;
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
    
    public static String checkChannelId(Object channelId){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[5] = true;
    	if(channelId == null || (channelId.toString()).length() <= 0
    			|| channelId.toString().equals("null") || channelId.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = channelId instanceof String;
		 if(type1)
		 {
			 if (registeredTypeTemp==2){  //线下
				 if(channelId.toString().length()!=15 && channelId.toString().length()!=19) { return "录入方式为线下，服务网点编号长度有误";}
				 if(channelId.toString().length()==15){
					 Id_4check id4 = new Id_4check();  //流动服务网点，15
					 return id4.check(channelId.toString());
				 }
				 if(channelId.toString().length()==19){  //服务网点信息，19
					 Id_3check id3 = new Id_3check();
					 return id3.check(channelId.toString());
				 }
			 }
			 else if (registeredTypeTemp==1){  //线上
				 if(channelId.toString().length() != 15) {return "录入方式为线上，线上服务渠道编号长度有误";}
				 Id_6check check6 = new Id_6check();  //线上服务渠道，15
					 return check6.check(channelId.toString());
			 }
			 else
			 {
				 return "录入方式不明确，无法确定该字段值";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkRegisteredTime(Object registeredTime) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[6] = true;
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
    
    public static String checkVehicleType(Object vehicleType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	if(vehicleType == null || (vehicleType.toString()).length() <= 0
    			|| vehicleType.toString().equals("null") || vehicleType.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = vehicleType instanceof String;
		 if(type1)
		 {
			 if ((vehicleType.toString()).length() <= 50) {
					if (rec.checkSpecialChar(vehicleType.toString()) || vehicleType.toString().equals("0")) {  //特殊字符过滤
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkVehicleModel(Object vehicleModel){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(vehicleModel == null || (vehicleModel.toString()).length() <= 0
				 || vehicleModel.toString().equals("null") || vehicleModel.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type = vehicleModel instanceof String;
		 if(type)
		 {
			 if ((vehicleModel.toString()).length() <= 50) {
					if (rec.checkSpecialChar(vehicleModel.toString()) || vehicleModel.toString().equals("0")) {  //特殊字符过滤
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkUseCharacter(Object useCharacter){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(useCharacter == null || (useCharacter.toString()).length() <= 0
				 || useCharacter.toString().equals("null") || useCharacter.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = useCharacter instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(useCharacter.toString());
			 if(i>=1 && i<=7) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
    
	public static String checkVIN(Object VIN) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[7] = true;
		if (VIN == null || (VIN.toString()).length() <= 0
				|| VIN.toString().equals("null") || VIN.toString().equals("NULL")) {
			return "必填项缺失";
		}
		
		boolean type1 = VIN instanceof String;
		if (type1) {
			if (VIN.toString().length() <= 50) {
				if (rec.checkVIN(VIN.toString())) {
					return "right";
				} else
					return "格式有误";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
    
	public static String checkEngineNum(Object engineNum) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		if (engineNum == null || (engineNum.toString()).length() <= 0
				|| engineNum.toString().equals("null") || engineNum.toString().equals("NULL")) {
			return "right";
		}
		
		boolean type1 = engineNum instanceof String;
		if (type1) {
			if (engineNum.toString().length() <= 50) {
				if (rec.checkEngineNum(engineNum.toString())) {
					return "right";
				} else
					return "格式有误";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
    
    public static String checkRegisterDate(Object registerDate){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	TimeDatecheck TimeDatecheckTemp = new TimeDatecheck();
    	if(registerDate == null || (registerDate.toString()).length() <= 0
    			|| registerDate.toString().equals("null") || registerDate.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = registerDate instanceof String;
		 if(type1)
		 {
			 if(TimeDatecheckTemp.check_len10(registerDate.toString()).equals("0") 
					 || TimeDatecheckTemp.check_len10(registerDate.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeDatecheckTemp.check_len10(registerDate.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeDatecheckTemp.check_len10(registerDate.toString());
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkIssueDate(Object issueDate){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	TimeDatecheck TimeDatecheckTemp = new TimeDatecheck();
    	if(issueDate == null || (issueDate.toString()).length() <= 0
    			|| issueDate.toString().equals("null") || issueDate.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = issueDate instanceof String;
		 if(type1)
		 {
			 if(TimeDatecheckTemp.check_len10(issueDate.toString()).equals("0") 
					 || TimeDatecheckTemp.check_len10(issueDate.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(TimeDatecheckTemp.check_len10(issueDate.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return TimeDatecheckTemp.check_len10(issueDate.toString());
			 }
		 }
		 return "数据类型不符";
	 }
    
	public static String checkFileNum(Object fileNum) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		if (fileNum == null || (fileNum.toString()).length() <= 0
				|| fileNum.toString().equals("null") || fileNum.toString().equals("NULL")) {
			return "right";
		}
		NumOrChar temp = new NumOrChar();
		boolean type1 = fileNum instanceof String;
		if (type1) {
			if (fileNum.toString().length() <= 50) {
				if (temp.isNumorChar(fileNum.toString())) {
					return "right";
				} else
					return "格式有误";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
    
    public static String checkApprovedCount(Object approvedCount){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(approvedCount == null || (approvedCount.toString()).length() <= 0
				 || approvedCount.toString().equals("null") || approvedCount.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = approvedCount instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(approvedCount.toString()) >= 0){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkTotalMass(Object totalMass){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(totalMass == null || (totalMass.toString()).length() <= 0
				 || totalMass.toString().equals("null") || totalMass.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = totalMass instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(totalMass.toString()) >= 0){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkMaintenanceMass(Object maintenanceMass){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(maintenanceMass == null || (maintenanceMass.toString()).length() <= 0
				 || maintenanceMass.toString().equals("null") || maintenanceMass.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = maintenanceMass instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(maintenanceMass.toString()) >= 0){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkPermittedWeight(Object permittedWeight){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(permittedWeight == null || (permittedWeight.toString()).length() <= 0
				 || permittedWeight.toString().equals("null") || permittedWeight.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = permittedWeight instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(permittedWeight.toString()) >= 0 || Integer.parseInt(permittedWeight.toString()) == -1){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    /****
     * 有问题
     */
	public static String checkOutsideDimensions(Object outsideDimensions) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		if (outsideDimensions == null
				|| (outsideDimensions.toString()).length() <= 0
				|| outsideDimensions.toString().equals("null") || outsideDimensions.toString().equals("NULL")) {
			return "right";
		}
		boolean type1 = outsideDimensions instanceof String;
		if (type1) {
			if(outsideDimensions.toString().length() >= 100){
				return "长度有误";
			}
			
			if(outsideDimensions.toString().equals("0")){  //允许默认值0
				return "right";
			}
			
			if (outsideDimensions.toString().contains("x")
					|| outsideDimensions.toString().contains("X")) {
				String[] num;
				NumOrChar temp = new NumOrChar();
				int m = 0; // 指示是否全部为数字
				if (outsideDimensions.toString().contains("x")) {
					num = outsideDimensions.toString().split("x");
					for (int i = 0; i < num.length; i++) {
						if (temp.isNumber(num[i])) {
							++m;
						}
					}
					if (num.length == m)
						return "right";
					else
						return "车辆尺寸必须为数字";
				} else {
					num = outsideDimensions.toString().split("X");
					for (int i = 0; i < num.length; i++) {
						if (temp.isNumber(num[i])) {
							++m;
						}
					}
					if (num.length == m)
						return "right";
					else
						return "车辆尺寸必须为数字";
				}
			} else
				return "请检查间隔符是否为x或X";
		}
		return "数据类型不符";
	}
    
    public static String checkPermittedTowWeight(Object permittedTowWeight){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(permittedTowWeight == null || (permittedTowWeight.toString()).length() <= 0
				 || permittedTowWeight.toString().equals("null") || permittedTowWeight.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = permittedTowWeight instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(permittedTowWeight.toString()) >= 0 || Integer.parseInt(permittedTowWeight.toString()) == -1){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkTestRecord(Object testRecord){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(testRecord == null || (testRecord.toString()).length() <= 0
				 || testRecord.toString().equals("null") || testRecord.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = testRecord instanceof String;
		 if(type1)
		 {
			 if ((testRecord.toString()).length() <= 50) {
					if (rec.checkAddress(testRecord.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkAxleCount(Object axleCount){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(axleCount == null || (axleCount.toString()).length() <= 0
				 || axleCount.toString().equals("null") || axleCount.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = axleCount instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(axleCount.toString()) >= 0){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkWheelCount(Object wheelCount){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(wheelCount == null || (wheelCount.toString()).length() <= 0
				 || wheelCount.toString().equals("null") || wheelCount.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = wheelCount instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(wheelCount.toString()) >= 0){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkAxleDistance(Object axleDistance){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(axleDistance == null || (axleDistance.toString()).length() <= 0
				 || axleDistance.toString().equals("null") || axleDistance.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = axleDistance instanceof Integer;
		 if(type1)
		 {
			 if( Integer.parseInt(axleDistance.toString()) >= 0){
			     return "right";
			 }
		 }
		 return "数据类型不符";
	 }
    
    public static String checkAxisType(Object axisType){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 if(axisType == null || (axisType.toString()).length() <= 0
				 || axisType.toString().equals("null") || axisType.toString().equals("NULL"))
		 {
			 return "right";
		 }
		 boolean type1 = axisType instanceof String;
		 if(type1)
		 {
			 if ((axisType.toString()).length() <= 50) {
					if (rec.checkAddress(axisType.toString())) {
						return "right";
					} else
						return "存在非法字符";
				} else
					return "长度有误";
		 }
		 return "数据类型不符";
	 }
    
    public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
    	array[8] = true;
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
