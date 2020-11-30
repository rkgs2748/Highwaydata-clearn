//package moduleSet;
//
//import idcheck.Id_30check;
//import stringcheck.TimeMomentcheck;
//
//public class CheckAccountUpload_30 {
//	 public static String checkAccount(String key, Object obj){ 
//		 if(key.equals("id")) return checkId(obj);
//		 else if(key.equals("processTime")) return checkProcessTime(obj);
//		 else if(key.equals("result")) return checkResult(obj);
//       else if (key.equals("timeMillStr")) return "right";
//		 else return "NO";
//	 }
//	 
//	 public static String checkId(Object id){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 Id_30check checktemp=new Id_30check();
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
//	 public static String checkProcessTime(Object time){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
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
//	 public static String checkResult(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
//		 if(type == null || (type.toString()).length() <= 0)
//		 {
//			 return "必填项缺失";
//		 }
//		 boolean type1 = type instanceof Integer;
//		 if(type1)
//		 {
//			 int i=Integer.parseInt(type.toString());
//			 if(i>=0 && i<=15) {return "right";}
//			 else return "编码范围有误";
//		 }
//		 return "数据类型不符";
//	 }
//}