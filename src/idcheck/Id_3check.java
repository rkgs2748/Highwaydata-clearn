package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:26
 * @function	： 检测服务网点编号（HALLUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_3check {
	public String check(String id)
	{
		if(id.length()!=19) {
			return "长度有误";
		}
		String id_1=id.substring(0, 11);
		String id_2=id.substring(11, 13);
		String id_3=id.substring(13, 15);
		String id_4=id.substring(15, 19);
		Id_1check tempCheck1 = new Id_1check();
		Id_2check tempCheck2 = new Id_2check();
		if(tempCheck2.check(id_1).equals("right")){
			if(tempCheck1.isNumber(id_2) && tempCheck1.isNumber(id_3) && tempCheck1.isNumber(id_4)){
				return "right";
			}
			else return "地市、区县、网点顺序码格式不正确";
		}
		else return tempCheck2.check(id_1);
	}
}
