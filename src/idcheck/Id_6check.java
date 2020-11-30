package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测线上服务渠道编号（ONLINEUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_6check {
	public String check(String id) {
		if (id.length() != 15) {
			return "长度有误";
		}
		String id_1 = id.substring(0, 11);
		String id_2 = id.substring(11, 13);
		String id_3 = id.substring(13, 15);
		Id_1check tempCheck1 = new Id_1check();
		Id_2check tempCheck2 = new Id_2check();
		if (tempCheck2.check(id_1).equals("right")) {
			if (!(id_2.equals("01")) && !(id_2.equals("02")) && !(id_2.equals("03")))
				return "线上渠道方式编码范围有误";
			if (tempCheck1.isNumber(id_3)) {
				return "right";
			} else
				return "线上渠道顺序码格式有误";
		}
		return tempCheck2.check(id_1);
	}
}
