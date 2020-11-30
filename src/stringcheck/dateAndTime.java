package stringcheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateAndTime {
	
	public int compareToCurrentDate(String DateTemp) throws ParseException{
		int result=-2;
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if(DateTemp.length()==10){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(DateTemp);
			Date date2 = sdf.parse(sdf.format(date));
			if(date1.before(date2)){  //比当前日期早
				result=-1;
			}
			else if(date1.after(date2)){  //比当前日期晚
				result=1;
			}
			else{   //与当前日期相等
				result=0;
			}
		}
		else if(DateTemp.length()==8){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Date date1 = sdf.parse(DateTemp);
			Date date2 = sdf.parse(sdf.format(date));
			if(date1.before(date2)){
				result=-1;
			}
			else if(date1.after(date2)){
				result=1;
			}
			else{
				result=0;
			}
		}
		else if(DateTemp.length()==6){
			SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
			Date date1 = sdf.parse(DateTemp);
			Date date2 = sdf.parse(sdf.format(date));
			if(date1.before(date2)){
				result=-1;
			}
			else if(date1.after(date2)){
				result=1;
			}
			else{
				result=0;
			}
		}
		else{
			System.out.println("日期格式错误："+DateTemp);
		}
		return result;
	}
	
	public int compareToCurrentDateTime(String DateTimeTemp) throws ParseException{
		int result=-2;
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		if(DateTimeTemp.length()==19){
			String DateTimeTemp1 = DateTimeTemp.replace("T", " ");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = sdf.parse(DateTimeTemp1);
			Date date2 = sdf.parse(sdf.format(date));
			if(date1.before(date2)){  //比当前日期早
				result=-1;
			}
			else if(date1.after(date2)){  //比当前日期晚
				result=1;
			}
			else{
				result=0;
			}
		}
		else if(DateTimeTemp.length()==14){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			Date date1 = sdf.parse(DateTimeTemp);
			Date date2 = sdf.parse(sdf.format(date));
			if(date1.before(date2)){
				result=-1;
			}
			else if(date1.after(date2)){
				result=1;
			}
			else{
				result=0;
			}
		}
		else{
			System.out.println("日期格式错误："+DateTimeTemp);
		}
		return result;
	}
	
	public int comparBetween(String bfDateTimeTemp, String afDateTimeTemp) throws ParseException{
		int result=-2;
		if(bfDateTimeTemp.length()==19 && afDateTimeTemp.length()==19){
			String DateTimeTemp1 = bfDateTimeTemp.replace("T", " ");
			String DateTimeTemp2 = afDateTimeTemp.replace("T", " ");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = sdf.parse(DateTimeTemp1);
			Date date2 = sdf.parse(DateTimeTemp2);
			if(date1.before(date2)){
				result=-1;
			}
			else if(date1.after(date2)){
				result=1;
			}
			else{
				result=0;
			}
		}
		return result;
	}
}
