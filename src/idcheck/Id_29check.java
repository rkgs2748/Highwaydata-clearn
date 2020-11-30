package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 16:35
 * @function	： 检测跨省交易数据编号（ACROSSPROVINCEUPLOAD）
 * @modify		：
 *
 ********************************************/
import stringcheck.TimeMomentcheck;

public class Id_29check { // 交易数据编号=出口车道编号+出口交易发生的时间+流水号
	public String check(String id) {
		if (id.length() != 37) {
			return "长度有误";
		}
		
		String id_1 = id.substring(0, 21);
		String id_2 = id.substring(21, 35);
		String id_3 = id.substring(35, 37);
		TimeMomentcheck timeTemp = new TimeMomentcheck();
		Id_20check tempCheck20 = new Id_20check();
		Id_1check tempCheck1 = new Id_1check();
		
		if (tempCheck20.check(id_1).equals("right")) {
			if (timeTemp.checkAbbr(id_2).equals("right")) {
				if (tempCheck1.isNumber(id_3)) {
					return "right";
				} else
					return "流水号格式有误";
			} else
				return timeTemp.checkAbbr(id_2);
		}
		return tempCheck20.check(id_1);
	}
}
