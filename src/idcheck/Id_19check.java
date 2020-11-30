package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:40
 * @function	： 检测收费广场编号（TOLLPLAZAUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_19check {
	public String check(String id) {
		if (id.length() != 18) {
			return "长度有误";
		}
		
		String id_1 = id.substring(0, 14);
		String id_2 = id.substring(14, 15);
		String id_3 = id.substring(15, 17);
		String id_4 = id.substring(17, 18);
		Id_18check tempCheck18 = new Id_18check();
		Id_1check tempCheck1 = new Id_1check();
		
		if (tempCheck18.check(id_1).equals("right")) {
			if (id_2.charAt(0) >= '1' && id_2.charAt(0) <= '7') {
				if (tempCheck1.isNumber(id_3) && tempCheck1.isNumber(id_4)) {
					return "right";
				} else
					return "收费广场顺序码或保留位格式有误";
			} else
				return "收费广场类型范围有误";
		}
		return tempCheck18.check(id_1);
	}
}
