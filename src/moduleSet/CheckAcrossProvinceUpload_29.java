//package moduleSet;
//
//import idcheck.Id_10check;
//import idcheck.Id_14check;
//import idcheck.Id_1check;
//import idcheck.Id_29check;
//import stringcheck.TimeMomentcheck;
//import stringcheck.VehicleNumcheck;
//import stringcheck.VehiclePlatecheck;
//
//public class CheckAcrossProvinceUpload_29 {
//	 private final static long maxFee = 9223372036854775807L;  //最大的Long型值范围
//	
//	 public static String checkAcrossProvince(String key, Object obj){
//		 if(key.equals("id")) return checkId(obj);
//		 else if(key.equals("issuerId")) return checkIssuerId(obj);
//		 else if(key.equals("serviceProviderId")) return checkServiceProviderId(obj); //无规则
//		 else if(key.equals("time")) return checkTime(obj);
//		 else if(key.equals("fee")) return checkFee(obj);
//		 else if(key.equals("serviceType")) return checkServiceType(obj);
//		 else if(key.equals("description")) return checkDescription(obj);   //限定长度即可
//		 else if(key.equals("detail")) return checkDetail(obj);
//		 else if(key.equals("cardId")) return checkCardId(obj);
//		 else if(key.equals("vehicleId")) return checkVehicleId(obj);
//		 else if(key.equals("transNo")) return checkTransNo(obj);
//		 else if(key.equals("preBalance")) return checkPreBalance(obj);
//		 else if(key.equals("postBalance")) return checkPostBalance(obj);
//		 else if(key.equals("TAC")) return checkTAC(obj);
//		 else if(key.equals("transType")) return checkTransType(obj);
//		 else if(key.equals("terminalNo")) return checkTerminalNo(obj);
//		 else if(key.equals("terminalTransNo")) return checkTerminalTransNo(obj);
//		 else if(key.equals("OBUId")) return checkOBUId(obj);   //非必填
//       else if (key.equals("timeMillStr")) return "right";
//		 else return "NO";
//	 }
//	 
//	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 Id_29check checktemp=new Id_29check();
//		 if(id == null || (id.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = id instanceof String; 
//		 if(type)
//		 {
//			 return checktemp.check(id.toString());
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkIssuerId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 Id_1check checktemp=new Id_1check();
//		 if(id == null || (id.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = id instanceof String;
//		 if(type)
//		 {
//			 return checktemp.check(id.toString());
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkServiceProviderId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(id == null || (id.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = id instanceof String;
//		 if(type)
//		 {
//			 if(id.toString().length()<=30) {return "right";}
//			 else return "长度有误";
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkTime(Object time){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 TimeMomentcheck tmc=new TimeMomentcheck();
//		 if(time == null || (time.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = time instanceof String;
//		 if(type)
//		 {
//			 return tmc.checkStandard(time.toString());
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkFee(Object fee){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(fee == null || (fee.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type1 = fee instanceof Integer;
//		 boolean type2 = fee instanceof Long;
//		 if(type1 || type2)
//		 {
//			 long i=Long.parseLong(fee.toString());
//			 if(i>=0 && i<= maxFee) {return "right";} 
//			 else return "编码范围有误";
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkServiceType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(type == null || (type.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type1 = type instanceof Integer;
//		 if(type1)
//		 {
//			 int i=Integer.parseInt(type.toString());
//			 if(i>=1 && i<=4) {return "right";}
//			 else return "编码范围有误";
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkDescription(Object info){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(info == null || (info.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = info instanceof String; 
//		 if(type)
//		 {
//			 if(info.toString().length() <= 300) {return "right";} //规则不明确
//			 else return "长度有误";
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkDetail(Object info){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(info == null || (info.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = info instanceof String;
//		 if(type)
//		 {
//			 if(info.toString().length() <= 300) {return "right";} //规则不明确
//			 else return "长度有误";
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkCardId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 Id_10check checktemp=new Id_10check();
//		 if(id == null || (id.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = id instanceof String; 
//		 if(type)
//		 {
//			 return checktemp.check(id.toString());
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	 public static String checkVehicleId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//			VehicleNumcheck vnc = new VehicleNumcheck();
//			if(id == null || (id.toString()).length() <= 0)
//			 {
//				 return "必填项缺失";
//			 }
//			 boolean type = id instanceof String;
//			 if(type)
//			 {
//				 return vnc.check(id.toString());
//			 }
//			 return "数据类型不符";
//		}
//	 
//	 public static String checkTransNo(Object info){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(info == null || (info.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type = info instanceof String; 
//		 if(type)
//		 {
//			 if(info.toString().length() <= 40) {return "right";} //规则不明确
//			 else return "长度有误";
//		 }
//		 return "数据类型不符";
//	 }
//	 
//	public static String checkPreBalance(Object fee) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		if (fee == null || (fee.toString()).length() <= 0) {
//			return "必填项缺失";
//		}
//		 boolean type1 = fee instanceof Integer;
//		 boolean type2 = fee instanceof Long;
//		if (type1 || type2) {
//			long i = Long.parseLong(fee.toString());
//			if (i >= 0 && i <= maxFee) {
//				return "right";
//			} else
//				return "编码范围有误";
//		}
//		return "数据类型不符";
//	}
//	
//	public static String checkPostBalance(Object fee) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		if (fee == null || (fee.toString()).length() <= 0) {
//			return "必填项缺失";
//		}
//		 boolean type1 = fee instanceof Integer;
//		 boolean type2 = fee instanceof Long;
//		if (type1 || type2) {
//			long i = Long.parseLong(fee.toString());
//			if (i >= 0 && i <= maxFee) {
//				return "right";
//			} else
//				return "编码范围有误";
//		}
//		return "数据类型不符";
//	}
//	
//	public static String checkTAC(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		VehiclePlatecheck vpc = new VehiclePlatecheck();
//		if (id == null || (id.toString()).length() <= 0) {
//			return "必填项缺失";
//		}
//		boolean type1 = id instanceof String;
//		if (type1) {
//			if (id.toString().length() == 8) {
//				if (vpc.isNumorChar(id.toString())) {
//					return "right";
//				} else
//					return "格式有误";
//			} else
//				return "长度有误";
//		}
//		return "数据类型不符";
//	}
//	
//	public static String checkTransType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		Id_1check id1= new Id_1check();
//		if (type == null || (type.toString()).length() <= 0) {
//			return "必填项缺失";
//		}
//		boolean type1 = type instanceof String;
//		if (type1) {
//			if (type.toString().length()<=4 && id1.isNumber(type.toString())) {
//				return "right";
//			} else
//				return "格式有误";
//		}
//		return "数据类型不符";
//	 }
//	
//	public static String checkTerminalNo(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		VehiclePlatecheck vpc= new VehiclePlatecheck();
//		if (id == null || (id.toString()).length() <= 0) {
//			return "必填项缺失";
//		}
//		boolean type1 = id instanceof String;
//		if (type1) {
//			if (id.toString().length()<=50 && vpc.isNumorChar(id.toString())) {
//				return "right";
//			} else
//				return "格式有误";
//		}
//		return "数据类型不符";
//	 }
//	
//	public static String checkTerminalTransNo(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		if (id == null || (id.toString()).length() <= 0) {
//			return "必填项缺失";
//		}
//		boolean type1 = id instanceof String;
//		if (type1) {
//			if (id.toString().length()<=20) {
//				return "right";
//			} else
//				return "长度有误";
//		}
//		return "数据类型不符";
//	 }
//	
//	public static String checkOBUId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		Id_14check checktemp = new Id_14check();
//		if (id == null || (id.toString()).length() <= 0) {
//			return "right";
//		} else {
//			boolean type = id instanceof String;
//			if (type) {
//				return checktemp.check(id.toString());
//			}
//			return "数据类型不符";
//		}
//	}
//}