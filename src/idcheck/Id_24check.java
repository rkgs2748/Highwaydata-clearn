package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测冲正交易流水编号（REVERSALUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_24check {
	public String check(String id) {
		if (id.length() > 38 || id.length() < 33) {
			return "长度有误";
		}
		
		String id_1 = id.substring(0, id.length() - 1);
		String id_2 = id.substring(id.length() - 1, id.length());
		Id_23check tempCheck23 = new Id_23check();
		
		if (tempCheck23.check(id_1).equals("right")) {
			if (id_2.equals("1")) {  //冲正标识默认为"1"
				return "right";
			} else
				return "冲正标识为非默认值";
		} 
		else
			return tempCheck23.check(id_1);
	}
}
