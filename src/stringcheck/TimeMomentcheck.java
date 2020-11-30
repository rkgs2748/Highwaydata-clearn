package stringcheck;

import java.text.ParseException;

/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 10:30
 * @function	： 校验精确到秒的时间格式（Time），对应于2种类型时间校验
 * @modify		：
 *
 ********************************************/
public class TimeMomentcheck {
	TimeDatecheck tdc;
	
	 /**
     * @throws ParseException 
	 * @function ： 校验完整格式时间，字符串长度为19，如：2016-12-12T23:59:59
     *
     */
	public String checkStandard(String time) throws ParseException
	{
		if(time.length()!=19) {
			return "长度有误"; }
		tdc= new TimeDatecheck();

		String time_1 = time.substring(0, 10);
		String time_2=time.substring(10, 11);
		
		int time_3=0;
		if (isNumber(time.substring(11, 13))){
		time_3 = Integer.parseInt(time.substring(11, 13));}
		else return "小时格式有误";
		
		String time_4=time.substring(13, 14);
		
		int time_5=0;
		if (isNumber(time.substring(14, 16))){
		time_5 = Integer.parseInt(time.substring(14, 16));}
		else return "分钟格式有误";
		
		String time_6=time.substring(16, 17);
		
		int time_7=0;
		if (isNumber(time.substring(17, 19))){
		time_7 = Integer.parseInt(time.substring(17, 19));}
		else return "秒格式有误";
		
		if( !tdc.check_len10(time_1).equals("-1") && !tdc.check_len10(time_1).equals("0") && !tdc.check_len10(time_1).equals("1")){
			return tdc.check_len10(time_1);   //时间格式错误，返回错误提示
		}
		else {
			if((time_3<24)&&(time_5<60)&&(time_7<60))
			{
				if((time_2.equals("T"))&&(time_4.equals(":"))&&(time_6.equals(":"))){
					dateAndTime tempTime = new dateAndTime();
					if(tempTime.compareToCurrentDateTime(time)==-1){
						return "-1";
					}
					else if(tempTime.compareToCurrentDateTime(time)==0){
						return "0";
					}
					else{
						return "1";
					}
				}
				else return "日期格式有误";
			}
			else return "日期时间格式有误";
		}
	}
	
	public String check_Expire(String time)  //校验到期时间
	{
		if(time.length()!=19) {
			return "长度有误"; }
		tdc= new TimeDatecheck();

		String time_1 = time.substring(0, 10);
		String time_2=time.substring(10, 11);
		
		int time_3=0;
		if (isNumber(time.substring(11, 13))){
		time_3 = Integer.parseInt(time.substring(11, 13));}
		else return "小时格式有误";
		
		String time_4=time.substring(13, 14);
		
		int time_5=0;
		if (isNumber(time.substring(14, 16))){
		time_5 = Integer.parseInt(time.substring(14, 16));}
		else return "分钟格式有误";
		
		String time_6=time.substring(16, 17);
		
		int time_7=0;
		if (isNumber(time.substring(17, 19))){
		time_7 = Integer.parseInt(time.substring(17, 19));}
		else return "秒格式有误";
		
		if( !tdc.check_Expire(time_1).equals("right")) return tdc.check_Expire(time_1);
		else {
		if((time_3<24)&&(time_5<60)&&(time_7<60))
		{
			if((time_2.equals("T"))&&(time_4.equals(":"))&&(time_6.equals(":"))){ return "right";}
			else return "日期时间格式有误";
		}
		else return "日期时间范围有误";
		}
	}
	
	 /**
     * @function ： 校验无符号格式时间，字符串长度为14，如：20161201151234
     *
     */
	public String checkAbbr(String time)
	{
		if(time.length()!=14) {
			return "长度有误"; }
		tdc= new TimeDatecheck();

		String time_1 = time.substring(0, 8);
		
		int time_2=0;
		if (isNumber(time.substring(8, 10))){
		time_2 = Integer.parseInt(time.substring(8, 10));}
		else return "小时格式有误";
		
		int time_3=0;
		if (isNumber(time.substring(10, 12))){
		time_3 = Integer.parseInt(time.substring(10, 12));}
		else return "分钟格式有误";
		
		int time_4=0;
		if (isNumber(time.substring(12, 14))){
		time_4 = Integer.parseInt(time.substring(12, 14));}
		else return "秒格式有误";
		
		if( !tdc.check_len8(time_1).equals("right")) return tdc.check_len8(time_1);
		else {
		if((time_2<24)&&(time_3<60)&&(time_4<60))
		{
			return "right";
		}
		return "日期时间格式有误";
		}
	}
	
	public boolean isNumber(String str){
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)<'0' || str.charAt(index)>'9'){
				return false;
			}
		}
		return true;
	}
}

/*编码规则：YYYY-MM-DDTHH:mm:ss，2016-12-12T23:00:00 */
