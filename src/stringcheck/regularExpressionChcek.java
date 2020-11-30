package stringcheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularExpressionChcek {
	//private String Name = "^[\u4E00-\u9Fa5\\w\\.\\-()（）·]*";
	
	//name1的正则表达式
	private String name1 = "(^[A-Za-z\\s·•.]+$)|(^[\u2E80-\uFE4F·•.]+$)";  //新版兼容规则
	
	//name2的正则表达式
	private String name2 = "^[\u2E80-\uFE4F\\w()（）.\\-·•\\—/\\&《》]+$";  //新版兼容规则
	
	//地址的正则表达式
	//private String address = "^[\u4E00-\u9Fa5\\w\\.\\+\\-()（）·、，,——]*";
	private String address = "^[\u2E80-\uFE4F\\w.+()（）\\-\\—/&:：#&*《》、，,.。~·•“”\"\"【】\\[\\]]+$";  //新版兼容规则（太极修改）
	//private String address = "^[\u2E80-\uFE4F\\w.+()\\（\\）\\-\\—/&:：#&$@*《》、，,.。~\\·\\•“”\"【】\\[\\]]+$";  //新版兼容规则(曹修改)
	
	//营业时间的正则表达式
	//private String businessHours = "^[每周天一二三四五六日至或星期:0-9\\-\\s,AMamPMpm]*$";
	private String businessHours = "^[每月年节假周天第休息一二三四五六日至，.或星期:0-9\\-\\s,AMamPMpm]*$";  //新版兼容规则
	
	//特殊字符过滤的正则表达式
	private String specialChar = "^[\u2E80-\uFE4F()（）\\w.+-·•\\—/]*$";  //新版兼容规则
	
	//OBU型号的正则表达式
	//private String OBUmodel = "^[\\-0-9A-Za-z]*$";
	//用户卡品牌
	//private String cardModel = "^[\u4E00-\u9Fa5\\-0-9A-Za-z()]*$";  
	
	//车辆识别代号VIN的正则表达式
	private String vin = "^[\\w-/\\+]+$";  //VIN新版规则
	
	//车辆发动机号的正则表达式
	private String engineNum = "^[\\w-/\\+\\*\\s\u2E80-\uFE4F—]+$";  //engineNum新版规则
	
	
	public boolean checkName1(String name){  //校验个人姓名name1
		Pattern pattern = Pattern.compile(name1);
		Matcher matcher = pattern.matcher(name);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkName2(String name){  //校验单位名称name2
		Pattern pattern = Pattern.compile(name2);
		Matcher matcher = pattern.matcher(name);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkBusinessHours(String Hours){  //校验营业时间
		Pattern pattern = Pattern.compile(businessHours);
		Matcher matcher = pattern.matcher(Hours);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkAddress(String addressTemp){  //校验地址字段
		Pattern pattern = Pattern.compile(address);
		Matcher matcher = pattern.matcher(addressTemp);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkSpecialChar(String special){  //特殊字符过滤
		Pattern pattern = Pattern.compile(specialChar);
		Matcher matcher = pattern.matcher(special);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkVIN(String vTemp){  //车辆识别代号
		Pattern pattern = Pattern.compile(vin);
		Matcher matcher = pattern.matcher(vTemp);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkEngineNum(String vTemp){  //车辆发动机号
		Pattern pattern = Pattern.compile(engineNum);
		Matcher matcher = pattern.matcher(vTemp);
		boolean rs = matcher.matches();
		return rs;
	}
}
