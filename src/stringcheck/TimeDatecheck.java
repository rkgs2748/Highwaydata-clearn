package stringcheck;

import idcheck.Id_1check;

import java.text.ParseException;

/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 10:30
 * @function	： 校验日期格式（Date），对应于4种类型日期校验
 * @modify		：
 *
 ********************************************/
public class TimeDatecheck {
    public int currentYear =2017;  //配置参数，当前年份
    public int expireYear =2999;  //配置参数，过期年份
    dateAndTime compareDate = new dateAndTime();
	
    /**
     * @function ： 校验完整格式年份，字符串长度为10，如:"2016-12-23"
     *
     */
	public String check_len10(String time) //完整格式年份，不能晚于当前日期的函数
	{
		if (time.length() != 10) {
			return "长度有误";
		}

		String time_1 = time.substring(4, 5);
		String time_2 = time.substring(7, 8);
		String time_3 = time.substring(0, 4);
		String time_4 = time.substring(5, 7);
		String time_5 = time.substring(8, 10);
		Id_1check tempCheck1 = new Id_1check();
		
		if( !tempCheck1.isNumber(time_3) || !tempCheck1.isNumber(time_4) || !tempCheck1.isNumber(time_5)){
			return "日期中存在非法字符";
		}
		if(Integer.parseInt(time_4.toString()) > 12 || Integer.parseInt(time_5.toString()) >31){
			return "日期月份或日数范围有误";
		}

		if ((time_1.equals("-")) && (time_2.equals("-"))) {
			try {
				if (compareDate.compareToCurrentDate(time) == -1) {  //比当前日期早
					return "-1";
				}
				else if(compareDate.compareToCurrentDate(time) == 0){
					return "0";
				}
				else
					return "1";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "日期格式错误";
	}

	/**
     * @function ： 校验缺省格式年份，字符串长度为8，如:"20161223"
     *
     */
	public String check_len8(String time) // 缺省年份校验，如:"2016-12-23"=20161223,长度为8，不能晚于当前日期的函数
	{
		if (time.length() != 8) {
			return "长度有误";
		}

		// System.out.println("校验年份："+currentYear);
		if (isNumber(time)) {
			try {
				if (compareDate.compareToCurrentDate(time) == -1 || compareDate.compareToCurrentDate(time) == 0) {  //比当前日期早或等于当前日期
					return "right";
				}
				else
					return "时间范围不能晚于当前时间";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "日期格式有误";
	}

	/**
     * @function ： 校验缺省格式年份，字符串长度为6，如:"161223"="2016-12-23"
     *
     */
	public String check_len6(String time)
	{
		if(time.length()!=6) {
			return "长度有误"; }

		if (isNumber(time)) {
			try {
				if (compareDate.compareToCurrentDate(time) == -1 || compareDate.compareToCurrentDate(time) == 0) {  //比当前日期早或等于当前日期
					return "right";
				}
				else
					return "时间范围不能晚于当前时间";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "日期格式有误";
	}
	
	public String check_Expire(String time)  //到期时间检测，标准长度为10，格式：YYYY-MM-DD
	{
		if (time.length() != 10) {
			return "长度有误";
		}

		int time_1 = 0;
		if (isNumber(time.substring(0, 4))) {
			time_1 = Integer.parseInt(time.substring(0, 4));
		} else
			return "年份格式有误";

		String time_2 = time.substring(4, 5);

		int time_3 = 0;
		if (isNumber(time.substring(5, 7))) {
			time_3 = Integer.parseInt(time.substring(5, 7));
		} else
			return "月份格式有误";

		String time_4 = time.substring(7, 8);

		int time_5 = 0;
		if (isNumber(time.substring(8, 10))) {
			time_5 = Integer.parseInt(time.substring(8, 10));
		} else
			return "日期格式有误";

		if ((time_2.equals("-")) && (time_4.equals("-"))) {
			if (((time_1 <= expireYear) && (time_3 <= 12) && (time_5 <= 31))
					|| ((time_1 == 2999) && (time_3 == 12) && (time_5 == 31))) {
				return "right";
			} else
				return "日期范围有误";
		}
		return "日期格式有误";
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

/*编码规则：YYYY-MM-DD，2016-12-12 */
