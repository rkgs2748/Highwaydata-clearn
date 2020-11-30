package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 16:35
 * @function	： 检测OBU卡序号编码（OBUUPLOAD）
 * @modify		：
 *
 ********************************************/

public class Id_14check {
	Id_1check id1Temp;
	
	/**
     * @function ： 校验OBU卡编号，字符串长度为16，OBU卡编号=省级区划+……
     *
     */
	public String check(String id) // 校验OBUId
	{
		if (id.length() <8 || id.length() > 16) {
			return "长度有误";
		}

		id1Temp = new Id_1check();
		String id_1 = id.substring(0, 2);

		if(id1Temp.isNumber(id_1)){
			if (isNumorHex(id))
			    return "right";
			else
				return "格式错误";
		}
		else return "卡网络编号格式有误";
		
	}
	
	/**
	 * @fuction : 判断字符串是否为16进制英文字母和数字组合
	 *
	 */
	public boolean isNumorHex(String str){
		int i=0;
		for(int index=0;index<str.length();index++){
			if((str.charAt(index)>='0' && str.charAt(index)<='9')||(str.charAt(index)>='A' && str.charAt(index)<='F')){
				++i;
			}
		}
		if (i==str.length()) return true;
		return false;
	}
}

//860300120038C0FF  OBU序号编码
//86B800013103FED7