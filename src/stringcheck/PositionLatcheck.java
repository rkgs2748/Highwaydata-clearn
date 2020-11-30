package stringcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 10:30
 * @function	： 校验纬度数据（Latitude），限定纬度范围
 * @modify		：
 *
 ********************************************/
import idcheck.Id_1check;

public class PositionLatcheck {
	public int northLatMax = 54; // 中国国境最北纬度为54度
	public int northLatMin = 3; // 中国国境最南纬度为3度

	/**
	 * @function ： 校验纬度，字符串长度为8或9，如：38.345678
	 * 
	 */
	public String check(String lat) {
		if ((lat.length() != 8) && (lat.length() != 9)) { // 28.23456
			return "长度有误";
		}

		String[] latarray;
		if (lat.contains(".")) {
			latarray = lat.split("\\."); // "."为转义字符
		} else
			return "格式有误";

		Id_1check id1 = new Id_1check();
		int lat_1 = 0;
		if (latarray[1].length() == 6) {
			if (id1.isNumber(latarray[1]) && id1.isNumber(latarray[0])) {
				lat_1 = Integer.parseInt(latarray[0]);
			} else
				return "格式有误";
		} else
			return "格式有误";

		if ((northLatMin <= lat_1) && (lat_1 <= northLatMax)) {
			return "right";
		}
		return "纬度值范围有误";
	}
}

/*编码规则：WGS84 坐标系统单位：度保留 6 位小数*/