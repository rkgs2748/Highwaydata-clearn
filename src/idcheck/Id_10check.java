package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 16:35
 * @function	： 校验用户卡编号（CARDUPLOAD），需配置省级区划编号
 * @modify		：
 *
 ********************************************/

public class Id_10check {
	Id_1check tempCheck1;
	
	/**
     * @function ： 校验用户卡编号，字符串长度为20，用户卡编号=（卡网络编号（4）=省级区划（2）+运营商序号（2））+CPU卡内部编号（16）
     *
     */
	public String check(String id) {
		if (id.length() != 20) {
			return "长度有误";
		}

		tempCheck1 = new Id_1check();
		String id_1 = null;

		if (tempCheck1.isNumber(id)) {
			id_1 = id.substring(0, 2);
		} else
			return "格式有误";

		if (tempCheck1.iscontain(id_1)) {
			return "right";
		}
		return "卡网络编号范围有误";
	}
}
//11011234567890123456  用户卡编号
//1440222000498580   OBU卡编号