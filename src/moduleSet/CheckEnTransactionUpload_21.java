package moduleSet;

import idcheck.Id_10check;
import idcheck.Id_14check;
import idcheck.Id_21check;
import stringcheck.NumOrChar;
import stringcheck.regularExpressionChcek;

public class CheckEnTransactionUpload_21 {
	static regularExpressionChcek rec = new regularExpressionChcek();  //出入口车辆
	public static int transType =0;
	public static boolean [] array = {false,false,false,false,false,
		false,false,false,false,false,
		false};
	
	static final String userUploaddw[] = {"type","id","passCardId","cardId","terminalTransNo",
			"vehicleId","vehicleType","greenTraffic","TAC","transType"
			,"terminalNo"};

	public static String checkRequiredKey(){  //1为非现金交易，2为现金交易，11项
		String results = "";
		if(transType == 2){
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if(i<3 || i==5 || i==6 || i==7){  //现金交易不统计3、4、8、9、10
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
					}
				}
			}
		}
		else if(transType == 1){
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if(i != 2){ //非现金交易不统计2
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
					}
				}
			}
		}
		else{
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if(i<2 || (i>4 && i<8)){  //交易类型不明确，统计5项
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
		transType = 0;
	}
	
	 public static String checkEnTransaction(String key, Object obj){
		 if(key.equals("type")) return checkType(obj);
		 else if(key.equals("id")) return checkId(obj);
		 else if(key.equals("passCardId")) return checkPassCardId(obj);  //条件必填，规则不明确
		 else if(key.equals("cardId")) return checkCardId(obj);  //条件必填
		 else if(key.equals("terminalTransNo")) return checkTerminalTransNo(obj);
		 else if(key.equals("OBUId")) return checkOBUId(obj);   //非必填
		 else if(key.equals("vehicleId")) return checkVehicleId(obj);
		 else if(key.equals("identifyVehicleId")) return checkIdentifyVehicleId(obj);
		 else if(key.equals("vehicleType")) return checkVehicleType(obj);
		 else if(key.equals("greenTraffic")) return checkGreenTraffic(obj);
		 else if(key.equals("TAC")) return checkTAC(obj);  //规则不明确
		 else if(key.equals("transType")) return checkTransType(obj); //规则不明确
		 else if(key.equals("terminalNo")) return checkTerminalNo(obj);  //规则不明确
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 if(type == null || (type.toString()).length() <= 0
				 || type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if(i>=1&&i<=2) {
				 return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 Id_21check checktemp=new Id_21check();
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
	 
	public static String checkPassCardId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		NumOrChar temp = new NumOrChar();
		if (transType == 2) {
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "必填项缺失";
			}
			boolean type1 = id instanceof String;
			if (type1) {
				if (id.toString().length() <= 20) {
					if(temp.isNumorChar(id.toString())){
						return "right";
					} else
						return "格式有误";
				} else
					return "长度有误";
			}
			return "数据类型不符";
		}
		else if(transType == 1) {
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "right";
			} else {
				boolean type1 = id instanceof String;
				if (type1) {
					if (id.toString().length() <= 20) {
						if(temp.isNumorChar(id.toString())){
							return "right";
						} else
							return "格式有误";
					} else
						return "长度有误";
				} else
					return "数据类型不符";
			}
		}
		else return "交易类型不明确";
	}
	
	public static String checkCardId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[3] = true;
		Id_10check id10= new Id_10check();
		if (transType == 1) {
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "必填项缺失";
			}
			boolean type1 = id instanceof String;
			if (type1) {
					return id10.check(id.toString());
			}
			return "数据类型不符";
		}
		else if(transType == 2){
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "right";
			} else {
				boolean type1 = id instanceof String;
				if (type1) {
						return id10.check(id.toString());
				} else
					return "数据类型不符";
			}
		}
		else return "交易类型不明确";
	}
	
	public static String checkTerminalTransNo(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[4] = true;
		NumOrChar temp = new NumOrChar();
		if (transType == 1) {
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "必填项缺失";
			}
			boolean type1 = id instanceof String;
			if (type1) {
				if (id.toString().length() <= 8) {  //8位，数字+十六进制字母
					if(temp.isNumorHex(id.toString())){
						return "right";
					} else
						return "格式有误";
				} else
					return "长度有误";
			}
			return "数据类型不符";
		} 
		else if(transType == 2) {
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "right";
			} else {
				boolean type1 = id instanceof String;
				if (type1) {
					if (id.toString().length() <= 8) {
						if(temp.isNumorHex(id.toString())){
							return "right";
						} else
							return "格式有误";
					} else
						return "长度有误";
				} else
					return "数据类型不符";
			}
		}
		else return "交易类型不明确";
	}
	
	public static String checkOBUId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		Id_14check checktemp = new Id_14check();
		if (id == null || (id.toString()).length() <= 0
				|| id.toString().equals("null") || id.toString().equals("NULL")) {
			return "right";
		} else {
			boolean type = id instanceof String;
			if (type) {
				return checktemp.check(id.toString());
			}
			return "数据类型不符";
		}
	}
	
	public static String checkVehicleId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[5] = true;
		//VehicleNumcheck vnc = new VehicleNumcheck();
		if(id == null || (id.toString()).length() <= 0
				|| id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = id instanceof String;
		 if(type)
		 {
			 if(id.toString().length() <= 20){
					return "right";
				} else 
					return "长度有误";
			 //return vnc.check(id.toString());
		 }
		 return "数据类型不符";
	}
	
	public static String checkIdentifyVehicleId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		//VehicleNumcheck vnc = new VehicleNumcheck();
		if (id == null || (id.toString()).length() <= 0
				|| id.toString().equals("null") || id.toString().equals("NULL")) {
			return "right";
		} else {
			boolean type = id instanceof String;
			if (type) {
				if(id.toString().length() <= 20){
					return "right";
				} else 
					return "长度有误";
//				int len = id.toString().length();
//				 if(len !=8 && len !=9 &&len !=10){
//					 return "长度有误";
//				 }
//
//				 if(id.toString().contains("超") || id.toString().contains("临")){  //交易中放行临，超牌，不能包含非法字符
//					 if(rec.checkEnExVechicle(id.toString())){
//						 return "right";
//					 } else 
//						 return "临或超类车辆包含非法字符";
//				 }
//				 
//				 return vnc.check(id.toString());
			}
			return "数据类型不符";
		}
	}
	
	public static String checkVehicleType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[6] = true; 
		if(type == null || (type.toString()).length() <= 0
				|| type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if((i>=1&&i<=4) || (i>=11&&i<=15) || i==0) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkGreenTraffic(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[7] = true;
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
	 
	 public static String checkTAC(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[8] = true;
		 NumOrChar temp = new NumOrChar();
		 if (transType == 1) {
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "必填项缺失";
				}
				boolean type1 = id instanceof String;
				if (type1) {
					if (id.toString().length() == 8) {  //8位，数字+十六进制字母
						if(temp.isNumorHex(id.toString())){
							return "right";
						} else
							return "格式有误";
					} else
						return "长度有误";
				}
				return "数据类型不符";
			} 
		 else if(transType == 2) {
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "right";
				} else {
					boolean type1 = id instanceof String;
					if (type1) {
						if (id.toString().length() == 8) {  //8位，数字+十六进制字母
							if(temp.isNumorHex(id.toString())){
								return "right";
							} else
								return "格式有误";
						} else
							return "长度有误";
					} else
						return "数据类型不符";
				}
			}
		 else return "交易类型不明确";
		}
	 
	 public static String checkTransType(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[9] = true;
		 if (transType == 1) {
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "必填项缺失";
				}
				boolean type1 = id instanceof String;
				if (type1) {
					if ( id.toString().equals("06") || id.toString().equals("09") ) {
						return "right";
					} else
						return "编码范围有误";
				}
				return "数据类型不符";
			} 
			else if(transType == 2){
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "right";
				} else {
					boolean type1 = id instanceof String;
					if (type1) {
						if ( id.toString().equals("06") || id.toString().equals("09") ) {
							return "right";
						} else
							return "编码范围有误";
					} else
						return "数据类型不符";
				}
			}
			else return "交易类型不明确";
		}
	 
	 public static String checkTerminalNo(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[10] = true;
		 NumOrChar temp = new NumOrChar();
			if (transType == 1) {
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "必填项缺失";
				}
				boolean type1 = id instanceof String;
				if (type1) {
					if (id.toString().length() <= 12) {  //8位，数字+十六进制字母
						if(temp.isNumorHex(id.toString())){
							return "right";
						} else
							return "格式有误";
					} else
						return "长度有误";
				}
				return "数据类型不符";
			} 
			else if(transType == 2){
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "right";
				} else {
					boolean type1 = id instanceof String;
					if (type1) {
						if (id.toString().length() <= 12) {  //8位，数字+十六进制字母
							if(temp.isNumorHex(id.toString())){
								return "right";
							} else
								return "格式有误";
						} else
							return "长度有误";
					} else
						return "数据类型不符";
				}
			}
			else return "交易类型不明确";
		}
}