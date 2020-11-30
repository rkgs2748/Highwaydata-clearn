package moduleSet;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import idcheck.Id_10check;
import idcheck.Id_14check;
import idcheck.Id_17check;
import idcheck.Id_20check;
import idcheck.Id_22check;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import stringcheck.NumOrChar;
import stringcheck.TimeMomentcheck;
import stringcheck.regularExpressionChcek;

public class CheckExTransactionUpload_22 {
	static regularExpressionChcek rec = new regularExpressionChcek();
	private final static long maxFee = 9223372036854775807L;  //最大的Long型值范围
	public static int transType =0;
	public static boolean [] array = {false,false,false,false,false,
		false,false,false,false,false,
		false,false,false,false,false,
		false,false,false,false,false,
		false,false,false,false,false};
	
	static final String userUploaddw[] = {"type","id","chargeTime","fee","weight",  //25项必填（包含条件必填4项）
			"enTollLaneId","enTime","passCardId","cardId","terminalTransNo"
			,"enVehicleId","exVehicleId","enVehicleType","exVehicleType","sectionCount",
			"splitTime","greenTraffic","TAC","transType","terminalNo",
			"preBalance","postBalance","details","identification","payType"};

	public static String checkRequiredKey(){  //25项必填
		String results = "";
		if(transType == 2){  //现金
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if(i<2 || (i>2&&i<8) || (i>9&&i<17) || i>21){
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
					}
				}
			}
		}
		else if(transType == 1){  //非现金
			for(int i=0; i<array.length; i++){
				if(array[i] == false){
					if( i<7 || (i>7&&i<24) ){  //非现金交易不统计
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
					if((i<7 && i!=2) || (i>9 && i<17) || (i>21 && i<24)){  //交易类型不明确时，只统计必填
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
	
	 public static String checkExTransaction(String key, Object obj) throws ParseException{
		 if(key.equals("type")) return checkType(obj);
		 else if(key.equals("id")) return checkId(obj);
		 else if(key.equals("chargeTime")) return checkChargeTime(obj);
		 else if(key.equals("fee")) return checkFee(obj);  //规则不明，金额限制？
		 else if(key.equals("weight")) return checkWeight(obj);
		 else if(key.equals("enTollLaneId")) return checkEnTollLaneId(obj);
		 else if(key.equals("enTime")) return checkEnTime(obj);
		 else if(key.equals("passCardId")) return checkPassCardId(obj);  //条件必填，规则不明确
		 else if(key.equals("cardId")) return checkCardId(obj);  //条件必填
		 else if(key.equals("terminalTransNo")) return checkTerminalTransNo(obj);
		 else if(key.equals("OBUId")) return checkOBUId(obj);   //非必填
		 else if(key.equals("enVehicleId")) return checkEnVehicleId(obj);
		 else if(key.equals("exVehicleId")) return checkExVehicleId(obj);
		 else if(key.equals("identifyVehicleId")) return checkIdentifyVehicleId(obj);  //非必填
		 else if(key.equals("enVehicleType")) return checkEnVehicleType(obj);
		 else if(key.equals("exVehicleType")) return checkExVehicleType(obj);
		 else if(key.equals("sectionCount")) return checkSectionCount(obj);
		 else if(key.equals("splitTime")) return checkSplitTime(obj);
		 else if(key.equals("greenTraffic")) return checkGreenTraffic(obj);
		 else if(key.equals("TAC")) return checkTAC(obj);  //规则不明确
		 else if(key.equals("transType")) return checkTransType(obj); //规则不明确
		 else if(key.equals("terminalNo")) return checkTerminalNo(obj);  //规则不明确
		 else if(key.equals("preBalance")) return checkPreBalance(obj);
		 else if(key.equals("postBalance")) return checkPostBalance(obj);
		 else if(key.equals("details")) return checkDetails(obj);    //json嵌套，拆分处理
		 else if(key.equals("identification")) return checkIdentification(obj);
		 else if(key.equals("payType")) return checkPayType(obj);
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
			 return "right";
			 }
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
		 Id_22check checktemp=new Id_22check();
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
	 
	public static String checkChargeTime(Object time) throws ParseException { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		TimeMomentcheck tmc = new TimeMomentcheck();
		if (transType == 1) {
			if (time == null || (time.toString()).length() <= 0
					|| time.toString().equals("null") || time.toString().equals("NULL")) {
				return "条件必填项缺失";
			}
			boolean type1 = time instanceof String;
			if (type1) {
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
		else if(transType == 2){
			if (time == null || (time.toString()).length() <= 0
					|| time.toString().equals("null") || time.toString().equals("NULL")) {
				return "right";
			} else {
				boolean type1 = time instanceof String;
				if (type1) {
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
				} else
					return "数据类型不符";
			}
		}
		else return "交易类型不明确";
	}
	 
	 public static String checkFee(Object fee){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[3] = true;
		 if(fee == null || (fee.toString()).length() <= 0
				 || fee.toString().equals("null") || fee.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = fee instanceof Integer;
		 boolean type2 = fee instanceof Long;
		 if(type1 || type2)
		 {
			 long i=Long.parseLong(fee.toString());
			 if(i>=0 && i <= maxFee) {return "right";} 
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkWeight(Object weight){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[4] = true;
		 if(weight == null || (weight.toString()).length() <= 0
				 || weight.toString().equals("null") || weight.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type = weight instanceof Integer;
		 if(type)
		 {
			 int i=Integer.parseInt(weight.toString());
			 if(i>=-1) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEnTollLaneId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[5] = true;
		 Id_20check checktemp=new Id_20check();
		 if(id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 
		 if(id.toString().equals("000000000000000000000"))
		 {
			 return "right";
		 }
		 
		 boolean type = id instanceof String;
		 if(type)
		 {
			 return checktemp.check(id.toString());
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEnTime(Object time) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[6] = true;
		 TimeMomentcheck tmc=new TimeMomentcheck();
		 if(time == null || (time.toString()).length() <= 0
				 || time.toString().equals("null") || time.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 
		 if(time.toString().equals("1900-01-01T00:00:00"))
		 {
			 return "right";
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
	
	public static String checkPassCardId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[7] = true;
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
		array[8] = true;
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
		array[9] = true;
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
	
	public static String checkEnVehicleId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[10] = true;
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
	
	public static String checkExVehicleId(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[11] = true;
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
//				 if(id.toString().contains("超") || id.toString().contains("临")){  //交易中放行临，超牌
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
	
	public static String checkEnVehicleType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[12] = true; 
		if(type == null || (type.toString()).length() <= 0
				|| type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if((i>=1&&i<=4) || (i>=11&&i<=15)) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkExVehicleType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[13] = true;
		if(type == null || (type.toString()).length() <= 0
				|| type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if((i>=0&&i<=4) || (i>=11&&i<=15)) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkSectionCount(Object count){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[14] = true; 
		if(count == null || (count.toString()).length() <= 0
				|| count.toString().equals("null") || count.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = count instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(count.toString());
			 if(i>=1 && i<9999) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	
	public static String checkSplitTime(Object time) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[15] = true; 
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
	 
	 public static String checkGreenTraffic(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[16] = true;
		 if(type == null || (type.toString()).length() <= 0
				 || type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if(i==1 || i==2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkTAC(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[17] = true;
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
		 array[18] = true;	
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
		 array[19] = true;  
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
	 
	 public static String checkPreBalance(Object fee) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[20] = true;
		 if (transType == 1) {
				if(fee == null || (fee.toString()).length() <= 0
						|| fee.toString().equals("null") || fee.toString().equals("NULL"))
				 {
					 return "必填项缺失";
				 }
				 boolean type1 = fee instanceof Integer;
				 boolean type2 = fee instanceof Long;
				 if(type1 || type2)
				 {
					 long i=Long.parseLong(fee.toString());
					 if(i<= maxFee) {return "right";} 
					 else return "数值范围有误";
				 }
				 return "数据类型不符";
			}
			else if(transType == 2){
				if (fee == null || (fee.toString()).length() <= 0
						|| fee.toString().equals("null") || fee.toString().equals("NULL")) {
					return "right";
				} else {
					 boolean type1 = fee instanceof Integer;
					 boolean type2 = fee instanceof Long;
					 if(type1 || type2)
					 {
						 long i=Long.parseLong(fee.toString());
						 if(i<= maxFee) {return "right";} 
						 else return "数值范围有误";
					 }
					 return "数据类型不符";
				}
			}
			else return "交易类型不明确";
		}
	 
	 public static String checkPostBalance(Object fee) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[21] = true;		
		 if (transType == 1) {
				if(fee == null || (fee.toString()).length() <= 0
						|| fee.toString().equals("null") || fee.toString().equals("NULL"))
				 {
					 return "必填项缺失";
				 }
				 boolean type1 = fee instanceof Integer;
				 boolean type2 = fee instanceof Long;
				 if(type1 || type2)
				 {
					 long i=Long.parseLong(fee.toString());
					 if(i<= maxFee) {return "right";} 
					 else return "数值范围有误";
				 }
				 return "数据类型不符";
			} 
			else if(transType == 2){
				if (fee == null || (fee.toString()).length() <= 0
						|| fee.toString().equals("null") || fee.toString().equals("NULL")) {
					return "right";
				} else {
					 boolean type1 = fee instanceof Integer;
					 boolean type2 = fee instanceof Long;
					 if(type1 || type2)
					 {
						 long i=Long.parseLong(fee.toString());
						 if(i<= maxFee) {return "right";}
						 else return "数值范围有误";
					 }
					 return "数据类型不符";
				}
			}
			else return "交易类型不明确";
		}
	 
	 public static String checkDetails(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[22] = true;		
		 if (id == null || (id.toString()).length() <= 0
				 || id.toString().equals("null") || id.toString().equals("NULL")) {
				return "必填项缺失";
			} else {
				boolean type = id instanceof Object;
				if (type) {
					JSONArray dataJson=null;
					if(id.toString().contains("{") && id.toString().contains("}") && id.toString().contains("[") && id.toString().contains("]")){
					dataJson = JSONArray.fromObject(id);   //json拆分处理
					}
					else return "json嵌套格式有误";
					int sum=0;
    	            for (int index = 0; index < dataJson.size(); index++) {
    	            	JSONObject temp=dataJson.getJSONObject(index);
    	            	Set<?> keySet = temp.keySet();   //json对象的键集合
    		            Iterator<?> it = keySet.iterator();
    		            while(it.hasNext()){
    		            	 Object key = it.next();  // key
    	                     Object value = temp.get(key);  //value
    	                     
    	                     if(key.equals("id")){
    	                    	 if(value == null || (value.toString()).length() <= 0)
    	        				 {
    	        					 return "json嵌套id值缺失";
    	        				 }
    	                    	 
    	                    	 boolean type1 = value instanceof String;
    	         				 if (!type1) {
    	         					return "json嵌套id值数据类型不符";
    	         				 }
    	                    	 
    	                    	 if(value.toString().length() != 39)  return "json嵌套id值长度有误";
    	                    	 else{
    	                    		 NumOrChar tempChar = new NumOrChar();
    	                    		 Id_22check checktemp = new Id_22check();
    	                    		 String id_1 = value.toString().substring(0, 37);
    	                    		 String id_2 = value.toString().substring(37, 39);
    	                    		 if(checktemp.check(id_1).equals("right")){
    	                    			 if(tempChar.isNumber(id_2)){
    	                    			 ++sum;}
    	                    			 else return "json嵌套id值拆分顺序码格式有误";
    	                    		 }
    	                    		 else return "json嵌套id交易编号不合规";
    	                    	 }
    	                     }
    	                     
    	                     else if(key.equals("sectionId")){
    	                    	 if(value == null || (value.toString()).length() <= 0)
    	        				 {
    	        					 return "json嵌套sectionId值缺失";
    	        				 }
    	                    	 boolean type1 = value instanceof String;
    	         				 if (!type1) {
    	         					return "json嵌套sectionId值数据类型不符";
    	         				 }
    	                    	 if(value.toString().length() != 11) return "json嵌套sectionId值长度有误";
    	                    	 else{
    	                    		 Id_17check checktemp = new Id_17check();
    	                    		 if(checktemp.check(value.toString()).equals("right")){
    	                    			 ++sum;
    	                    		 }
    	                    		 else return "json嵌套sectionId值不合规";
    	                    	 }
    	                     }
    	                     
    	                     else if(key.equals("fee")){
    	                    	 if(value == null || (value.toString()).length() <= 0)
    	        				 {
    	        					 return "json嵌套fee值缺失";
    	        				 }
    	                    	 boolean type1 = value instanceof Integer;
    	    					 boolean type2 = value instanceof Long;
    	        				 if(type1 || type2)
    	        				 {
    	        					 long i=Long.parseLong(value.toString());
    	        					 if(i<= maxFee) { ++sum;}
    	        					 else return "json嵌套fee值范围有误";
    	        				 }
    	        				 else return "json嵌套fee值数据类型不符";
    	                     }
    	                     else return "json嵌套中存在非法字段(不存在)";
    	                     }
    		            }
    	            if(sum == dataJson.size()*3)  return "right";  //根据json嵌套的字段总数判断总的json嵌套是否通过
    	            else return "json嵌套中存在不合规字段";
				}
				return "json嵌套数据类型不符";
			}
		}
	 
	 public static String checkIdentification(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[23] = true;	
		 if(type == null || (type.toString()).length() <= 0
				 || type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if(i==1 || i==2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkPayType(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[24] = true;		
		 if (transType == 2) {
				if (id == null || (id.toString()).length() <= 0
						|| id.toString().equals("null") || id.toString().equals("NULL")) {
					return "必填项缺失";
				}
				boolean type1 = id instanceof Integer;
				if (type1) {
					if (id.toString().length()>=1 && id.toString().length()<=3) {
						return "right";
					} else
						return "编码范围有误";
				}
				return "数据类型不符";
			} 
			else if(transType == 1){
				if (id == null || (id.toString()).length() <= 0) {
					return "right";
				} else {
					boolean type1 = id instanceof Integer;
					if (type1) {
						if (id.toString().length()>=1 && id.toString().length()<=3) {
							return "right";
						} else
							return "编码范围有误";
					} else
						return "数据类型不符";
				}
			}
			else return "交易类型不明确";
		}
}