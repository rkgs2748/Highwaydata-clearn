package stringcheck;

/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 10:30
 * @function	： 校验经度数据（Longitude），限定经度范围
 * @modify		：
 *
 ********************************************/
import idcheck.Id_1check;

public class PositionLngcheck {
	public int eastLngMax = 135; // 中国国境最东经度为135度
	public int eastLngMin = 73; // 中国国境最西经度为73度

	/**
	 * @function ： 校验经度，字符串长度为9或10，如：109.345678
	 * 
	 */
	public String check(String lng) {
		if ((lng.length() != 9) && (lng.length() != 10)) { // 28.23456
			return "长度有误";
		}

		String[] lngarray;
		if (lng.contains(".")) {
			lngarray = lng.split("\\."); // "."为转义字符
		} else
			return "格式有误";

		Id_1check id1 = new Id_1check();
		int lat_1 = 0;

		if (lngarray[1].length() == 6) {
			if (id1.isNumber(lngarray[1]) && id1.isNumber(lngarray[0])) {
				lat_1 = Integer.parseInt(lngarray[0]);
			} else
				return "格式有误";
		} else
			return "格式有误";

		if ((eastLngMin <= lat_1) && (lat_1 <= eastLngMax)) {
			return "right";
		}
		return "经度值范围有误";
	}
}

/* 编码规则：WGS84 坐标系统单位：度保留 6 位小数 */