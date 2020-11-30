package moduleSet;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import idcheck.Id_17check;
import idcheck.Id_26check;
import stringcheck.NumOrChar;
import stringcheck.TimeMomentcheck;

public class CheckETCRestitutionUpload_26 {
	 private final static long maxFee = 9223372036854775807L;  //最大的Long型值范围
	 public static boolean [] array = {false, false,false,false,false,
			false,false,false};
		
		static final String userUploaddw[] = {"id","fee","effectiveTime",
			"sectionCount","splitTime","orderNum","identification","details"};
		
		public static String checkRequiredKey(){  //8必填项
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
		
		public static void initArray(){  //初始化array数组,参数
			for(int i=0; i<array.length; i++){
				array[i] = false;
			}
		}
	 
	 public static String checkETCRestitution(String key, Object obj) throws ParseException{
		 if(key.equals("id")) return checkId(obj);
		 else if(key.equals("fee")) return checkFee(obj);
		 else if(key.equals("effectiveTime")) return checkEffectiveTime (obj);
		 else if(key.equals("sectionCount")) return checkSectionCount(obj);
		 else if(key.equals("splitTime")) return checkSplitTime(obj);
		 else if(key.equals("orderNum")) return checkOrderNum(obj);
		 else if(key.equals("identification")) return checkIdentification(obj);
		 else if(key.equals("details")) return checkDetails(obj);    //json嵌套，拆分处理
		 else if (key.equals("timeMillStr")) return "right";
		 else return "NO";
	 }
	 
	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[0] = true;
		 Id_26check checktemp=new Id_26check();
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
	 
	 public static String checkFee(Object fee){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[1] = true;
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
			 if(i>=0 && i<= maxFee) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkEffectiveTime(Object time) throws ParseException{  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[2] = true;
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
	 
	 public static String checkSectionCount(Object count){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[3] = true;
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
		 array[4] = true;
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
	 
	 public static String checkOrderNum(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[5] = true;	
		 NumOrChar temp = new NumOrChar();
			if (id == null || (id.toString()).length() <= 0
					|| id.toString().equals("null") || id.toString().equals("NULL")) {
				return "必填项缺失";
			}
			boolean type = id instanceof String;
			if (type) {
				if (id.toString().length() <= 50 ) {
					if (temp.isNumorChar(id.toString())) {
						return "right";
					} else
						return "格式有误";
				} else
					return "长度有误";
			}
			return "数据类型不符";
	 }
	 
	 public static String checkIdentification(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
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
			 if(i==1 || i==2) {return "right";}
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
	 
	 public static String checkDetails(Object id) { // 返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		 array[7] = true;	
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
	                    	 
	                    	 if(value.toString().length() != 41)  return "json嵌套id值长度有误";
	                    	 else{
	                    		 NumOrChar tempChar = new NumOrChar();
	                    		 Id_26check checktemp = new Id_26check();
	                    		 String id_1 = value.toString().substring(0, 39);
	                    		 String id_2 = value.toString().substring(39, 41);  //是否为2位？
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
}