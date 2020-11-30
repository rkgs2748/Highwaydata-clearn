package stringcheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20171117 20:30
 * @function	： 校验证件号码（IdNum）
 * @modify		：
 *
 ********************************************/
public class IdNumcheck {
	//第一类证件号的正则表达式
	private String idNum_1 = "^[\\w-—()（）/]+$";  //除身份证、武警证、军官证、事业单位法人证书、社会团体法人登记证书、199、299之外的id校验
	
	//第二类证件号的正则表达式
	private String idNum_2 = "^[\u2E80-\uFE4F\\w-—]+$";  //武警证、军官证、事业单位法人证书、社会团体法人登记证书的正则表达式
	
	//居民身份证的正则表达式
	private String idNum_3 = "^(11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|" +
			"41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)\\d{15}(\\d{1}|X)$";  //居民身份证
	
	public boolean checkIdNum1(String name){  //校验第一类证件号
		Pattern pattern = Pattern.compile(idNum_1);
		Matcher matcher = pattern.matcher(name);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkIdNum2(String name){  //校验第二类证件号
		Pattern pattern = Pattern.compile(idNum_2);
		Matcher matcher = pattern.matcher(name);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public boolean checkIdNum3(String name){  //校验居民身份证
		Pattern pattern = Pattern.compile(idNum_3);
		Matcher matcher = pattern.matcher(name);
		boolean rs = matcher.matches();
		return rs;
	}
	
	public String checkIdNum(int idType, String idNum) {
		if(idType == 199 || idType == 299){  //当证件类型为缺省值199、299时
			regularExpressionChcek regTemp = new regularExpressionChcek();
			if(regTemp.checkSpecialChar(idNum) || idNum.equals("1234567890")){ //允许证件号199，默认值为“1234567890”
				return "right";
			} else
				return "证件类型为缺省类型，缺省值存在非法字符";
		}
		
		if(idType == 101){  //当证件类型为身份证101时
			if( checkIdNum3(idNum) ){
				return "right";
			} else
				return "证件类型为身份证，身份证号格式错误";
		}
		
		if(idType == 105 || idType == 106 || idType == 204 || idType == 205){  //当证件类型为武警证、军官证、事业单位法人证书、社会团体法人登记证书
			if( checkIdNum2(idNum) ){
				return "right";
			} else
				return "证件类型为武警证、军官证等，证件号码存在非法字符";
		}
		
		if((idType >= 102 && idType <= 104) || (idType >= 201 && idType <= 203) || idType == 206){  //当证件类型为组织机构代码证等
			if( checkIdNum1(idNum) ){
				return "right";
			} else
				return "证件类型为102-104、201-203或206等，证件号码存在非法字符";
		}
		
		return "证件类型编码错误，无法校验对应证件号";
	}
}
