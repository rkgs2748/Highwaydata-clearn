package moduleSet;

import java.text.ParseException;

import idcheck.Id_3check;
import idcheck.Id_4check;
import idcheck.Id_6check;
import idcheck.Id_8check;
import stringcheck.IdNumcheck;
import stringcheck.TimeMomentcheck;
import stringcheck.regularExpressionChcek;
import stringcheck.telIdentification;

public class CheckUserUpload_8 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	public static int registeredtype = 0;
	public static int userType = 0;
	public static int userIdType = 100;  //初始化值100
	public static int agentIdType = 100;
	public static boolean [] array = {false, false,false, false,false,
		false,false, false,false, false,
		false, false,false, false,false,
		false,false};
	
	static final String userUploaddw[] = {"id","userType","userName","userIdType","userIdNum",  //单位用户，17项必填（包含条件必填4项）
			"tel","address","registeredType","channelId","registeredTime"
			,"department","agentName","agentIdType","agentIdNum","status"
			,"statusChangeTime","operation"};
	
	public static String checkUserUpload(String key, Object obj) throws ParseException{
		if(key.equals("id")) return checkId(obj);
		else if (key.equals("userType")) return checkUserType(obj);
		else if (key.equals("userName")) return checkUserName(obj);
		else if (key.equals("userIdType")) return checkUserIdType(obj);
		else if (key.equals("userIdNum")) return checkUserIdNum(obj);
		else if (key.equals("tel")) return checkTel(obj);
		else if (key.equals("address")) return checkAddress(obj);
		else if (key.equals("registeredType")) return checkRegisteredType(obj);
		else if (key.equals("channelId")) return checkChannelId(obj);
		else if (key.equals("registeredTime")) return checkRegisteredTime(obj);
		else if (key.equals("department")) return checkDepartment(obj);  //条件必填项
		else if (key.equals("agentName")) return checkAgentName(obj);
		else if (key.equals("agentIdType")) return checkAgentIdType(obj);
		else if (key.equals("agentIdNum")) return checkAgentIdNum(obj);
		else if (key.equals("status")) return checkStatus(obj);
		else if (key.equals("statusChangeTime")) return checkStatusChangeTime(obj);
		else if (key.equals("operation")) return checkOperation(obj);
		else if (key.equals("timeMillStr")) return "right";
		else return "NO";
	}
	
	public static String checkRequiredKey(){  //1为个人（13项），2为单位（17项），校验必填项
		String results = "";
		if(userType == 2){
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
				}
			}
		}
		else if(userType == 1){
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if(i<10 || i>13){   //个人用户不统计4项
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
					}
				}
			}
		}
		else {
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if(i<10 || i>13){   //客户类型不详，不统计4项
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
					}
				}
			}
		}
		initArray();
		return results;
	}
	
	public static void initArray(){  //初始化array数组,关联参数
		for(int i=0; i<array.length; i++){
			array[i] = false;
		}
		registeredtype = 0; //初始化关联参数
		userType = 0;
		userIdType = 100;
		agentIdType = 100;
	}
	
	public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_8check check1 = new Id_8check();
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
	
	private static String checkUserType(Object type) {
		array[1] = true;
		if (type == null || (type.toString()).length() <= 0
				|| type.toString().equals("null") || type.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if (type1){
			 if (Integer.parseInt(type.toString()) == 1 || Integer.parseInt(type.toString()) == 2){
				 //userType = Integer.parseInt(type.toString());  //获取用户类型参数
				 return "right";
			 }
			 else
				 return "编码范围有误";
		 }
		return "数据类型不符";
	}
	
	private static String checkUserName(Object userName) {
		array[2] = true;
		if (userName == null || (userName.toString()).length() <= 0
				|| userName.toString().equals("null")
				|| userName.toString().equals("NULL")) {
			return "必填项缺失";
		}
		boolean type = userName instanceof String;
		if (type) {
			if ((userName.toString()).length() <= 50) {
				if (userType == 1) { // 个人用户
					if (rec.checkName1(userName.toString())) {
						return "right";
					} else
						return "个人用户名存在非法字符";
				} else if (userType == 2) { // 单位用户
					if (rec.checkName2(userName.toString())) {
						return "right";
					} else
						return "单位用户名存在非法字符";
				} else
					return "客户类型不正确，无法校验客户名称";
			} else
				return "长度有误";
		}
		return "数据类型不符";
	}
	
	private static String checkUserIdType(Object userIdType) {
		array[3] = true;
		if (userIdType == null || (userIdType.toString()).length() <= 0
				|| userIdType.toString().equals("null") || userIdType.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = userIdType instanceof Integer;
		 if (type){
			 if ((userIdType.toString()).length() == 3 ){
				 int userType = Integer.parseInt(userIdType.toString());
				 if ((userType >= 101 && userType <= 106) || userType == 199 || (userType >= 201 && userType <= 206) || userType == 299)
					 return "right";
				 else return "编码范围有误";
			 }
			 else
				 return "长度有误";
		 }
		return "数据类型不符";
	}
	
	private static String checkUserIdNum(Object userIdNum) {
		array[4] = true;
		if (userIdNum == null || (userIdNum.toString()).length() <= 0
				|| userIdNum.toString().equals("null") || userIdNum.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		IdNumcheck idNumTemp = new IdNumcheck();
		 boolean type = userIdNum instanceof String;
		 if (type){
			 if ((userIdNum.toString()).length() <= 30){
				 if(idNumTemp.checkIdNum(userIdType, userIdNum.toString()).equals("right")){
					 return "right";
				 }
				 else
					 return idNumTemp.checkIdNum(userIdType, userIdNum.toString());  //若校验失败，则返回提示信息
			 }
			 else
				 return "长度有误";
		 }
		return "数据类型不符";
	}
	
	 public static String checkTel(Object tel){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[5] = true;
		 if (tel == null || (tel.toString()).length() <= 0
				 || tel.toString().equals("null") || tel.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = tel instanceof String;
		 if (type){
			 if(tel.toString().equals("99999999999")){  //允许默认值
				 return "right";
			 }
			 if(tel.toString().charAt(0) != '1' || tel.toString().contains("-") || tel.toString().length() != 11){  //判断不是手机号
				return "必须填写手机号码"; 
			 }
			 telIdentification telTemp = new telIdentification();
			 if ((tel.toString()).length() <= 20){
				 if(telTemp.identifyTel(tel.toString()).equals("right")){
				 return "right";
				 }
				 else return telTemp.identifyTel(tel.toString());
			 }
			 else
				 return "长度有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkAddress(Object address){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[6] = true;
		 if (address == null || (address.toString()).length() <= 0
				 || address.toString().equals("null") || address.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = address instanceof String;
		 if (type){
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
	
	private static String checkRegisteredType(Object registeredType) {
		array[7] = true;
		if (registeredType == null || (registeredType.toString()).length() <= 0
				|| registeredType.toString().equals("null") || registeredType.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = registeredType instanceof Integer;
		 if (type){
			 if (Integer.parseInt(registeredType.toString()) == 1 || Integer.parseInt(registeredType.toString()) == 2){
				 return "right";
			 }
			 else
				 return "编码范围有误";
		 }
		return "数据类型不符";
	}
	
	private static String checkChannelId(Object channelId) {
		array[8] = true;
		if (channelId == null || (channelId.toString()).length() <= 0
				|| channelId.toString().equals("null") || channelId.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = channelId instanceof String;
		 if (type){
			 if (registeredtype==2){  //线下
				 if(channelId.toString().length()!=15 && channelId.toString().length()!=19) { return "开户方式为线下，服务网点编号长度有误";}
				 if(channelId.toString().length()==15){
					 Id_4check id4 = new Id_4check();  //流动服务网点，15
					 return id4.check(channelId.toString());
				 }
				 if(channelId.toString().length()==19){  //服务网点信息，19
					 Id_3check id3 = new Id_3check();
					 return id3.check(channelId.toString());
				 }
			 }
			 else if (registeredtype==1){  //线上
				 if(channelId.toString().length() != 15) {return "开户方式为线上，线上服务渠道编号长度有误";}
				 Id_6check check6 = new Id_6check();  //线上服务渠道，15
					 return check6.check(channelId.toString());
			 }
			 else
			 {
				 return "开户方式不明确，无法确定该字段值";
			 }
		 }
		 return "数据类型不符";
}
	
	private static String checkRegisteredTime(Object registeredTime) throws ParseException {
		array[9] = true;
		TimeMomentcheck check1 = new TimeMomentcheck();
		if (registeredTime == null || (registeredTime.toString()).length() <= 0
				|| registeredTime.toString().equals("null") || registeredTime.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = registeredTime instanceof String;
		 if (type) {
			 if(check1.checkStandard(registeredTime.toString()).equals("0") 
					 || check1.checkStandard(registeredTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(check1.checkStandard(registeredTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return check1.checkStandard(registeredTime.toString());
			 }
		 }
		return "数据类型不符";
	}
	
	private static String checkDepartment(Object department) {   //规则中没有明确规定，仅对长度进行判别
		array[10] = true;
		if (userType == 2) {
			if (department == null || (department.toString()).length() <= 0
					|| department.toString().equals("null") || department.toString().equals("NULL")){
				 return "必填项缺失";
			 }
			 boolean type1 = department instanceof String;
			 if (type1){
				 if (department.toString().length() <= 50 )
					 return "right";
				 else
					 return "长度有误";
			 }
			return "数据类型不符";
		} 
		else if(userType == 1){
			if (department == null || (department.toString()).length() <= 0
					|| department.toString().equals("null") || department.toString().equals("NULL")){
				 return "right";
			 }
			 boolean type1 = department instanceof String;
			 if (type1){
				 if (department.toString().length() <= 50 )
					 return "right";
				 else
					 return "长度有误";
			 }
			return "数据类型不符";
			}
		else return "客户类型不明确";
	}
	
	private static String checkAgentName(Object agentName) {   //规则中没有明确规定，仅对长度进行判别
		array[11] = true;
		if (userType == 2) {
			if (agentName == null || (agentName.toString()).length() <= 0
					|| agentName.toString().equals("null") || agentName.toString().equals("NULL")){
				 return "必填项缺失";
			 }
			 boolean type1 = agentName instanceof String;
			 if (type1){
				 if ((agentName.toString()).length() <= 150) {
						if (rec.checkName1(agentName.toString())) {
							return "right";
						} else
							return "存在非法字符";
					} else
						return "长度有误";
			 }
			return "数据类型不符";
		} 
		else if(userType == 1){
			if (agentName == null || (agentName.toString()).length() <= 0
					|| agentName.toString().equals("null") || agentName.toString().equals("NULL")){
				 return "right";
			 }
			 boolean type1 = agentName instanceof String;
			 if (type1){
				 if ((agentName.toString()).length() <= 150) {
						if (rec.checkName1(agentName.toString())) {
							return "right";
						} else
							return "存在非法字符";
					} else
						return "长度有误";
			 }
			return "数据类型不符";
			}
		else return "客户类型不明确";
	}
	
	private static String checkAgentIdType(Object agentIdType) { // 规则中没有明确规定，仅对长度进行判别
		array[12] = true;
		if (userType == 2) {
			if (agentIdType == null || (agentIdType.toString()).length() <= 0
					|| agentIdType.toString().equals("null") || agentIdType.toString().equals("NULL")) {
				return "必填项缺失";
			}
			boolean type1 = agentIdType instanceof Integer;
			if (type1) {
				if (agentIdType.toString().length() == 3) {
					int idType = Integer.parseInt(agentIdType.toString());
					if ((idType >= 101 && idType <= 106) || idType == 199)
						return "right";
					else
						return "编码范围有误";
				} else
					return "字段长度有误";
			}
			return "数据类型不符";
		} 
		else if(userType == 1){
			if (agentIdType == null || (agentIdType.toString()).length() <= 0
					|| agentIdType.toString().equals("null") || agentIdType.toString().equals("NULL")) {
				return "right";
			}
			boolean type1 = agentIdType instanceof Integer;
			if (type1) {
				if (agentIdType.toString().length() == 3) {
					int idType = Integer.parseInt(agentIdType.toString());
					if ((idType >= 101 && idType <= 106) || idType == 199)
						return "right";
					else
						return "编码范围有误";
				} else
					return "字段长度有误";
			}
			return "数据类型不符";
		}
		else return "客户类型不明确";
	}
	
	private static String checkAgentIdNum(Object agentIdNum){ // 规则中没有明确规定，仅对长度进行判别
		array[13] = true;
		IdNumcheck idNumTemp = new IdNumcheck();
		if (userType == 2) {
			if (agentIdNum == null || (agentIdNum.toString()).length() <= 0
					|| agentIdNum.toString().equals("null") || agentIdNum.toString().equals("NULL")){
				 return "必填项缺失";
			 }
			 boolean type1 = agentIdNum instanceof String;
			 if (type1){
				 if ((agentIdNum.toString()).length() <= 30){
					 if(idNumTemp.checkIdNum(agentIdType, agentIdNum.toString()).equals("right")){
						 return "right";
					 }
					 else
						 return idNumTemp.checkIdNum(agentIdType, agentIdNum.toString());  //若校验失败，则返回提示信息
				 }
				 else
					 return "字段长度有误";
			 }
			return "数据类型不符";
		} 
		else if(userType == 1){
			if (agentIdNum == null || (agentIdNum.toString()).length() <= 0
					|| agentIdNum.toString().equals("null") || agentIdNum.toString().equals("NULL")){
				 return "right";
			 }
			 boolean type1 = agentIdNum instanceof String;
			 if (type1){
				 if ((agentIdNum.toString()).length() <= 30){
					 if(idNumTemp.checkIdNum(agentIdType, agentIdNum.toString()).equals("right")){
						 return "right";
					 }
					 else
						 return idNumTemp.checkIdNum(agentIdType, agentIdNum.toString());  //若校验失败，则返回提示信息
				 }
				 else
					 return "字段长度有误";
			 }
			return "数据类型不符";
		}
		else return "客户类型不明确";
	}
	
	private static String checkStatus(Object status) {
		array[14] = true;
		if (status == null || (status.toString()).length() <= 0
				|| status.toString().equals("null") || status.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = status instanceof Integer;
		 if (type){
			 if (Integer.parseInt(status.toString()) == 1 || Integer.parseInt(status.toString()) == 2){
				 return "right";
			 }
			 else
				 return "编码范围有误";
		 }
		return "数据类型不符";
	}
	
	private static String checkStatusChangeTime(Object statusChangeTime) throws ParseException {
		array[15] = true;
		TimeMomentcheck check1 = new TimeMomentcheck();
		if (statusChangeTime == null || (statusChangeTime.toString()).length() <= 0
				|| statusChangeTime.toString().equals("null") || statusChangeTime.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = statusChangeTime instanceof String;
		 if (type) {
			 if(check1.checkStandard(statusChangeTime.toString()).equals("0")
					 || check1.checkStandard(statusChangeTime.toString()).equals("1")){
				 return "不能晚于当前日期";
			 }
			 else if(check1.checkStandard(statusChangeTime.toString()).equals("-1")){
				 return "right";
			 }
			 else{
				 return check1.checkStandard(statusChangeTime.toString());
			 }
		 }
		return "数据类型不符";
	}
	
	public static String checkOperation(Object operation){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[16] = true;
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
