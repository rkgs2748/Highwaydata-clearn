package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测收费路段编号（SECTIONUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_17check {
	public String check(String id)
	{
		if(id.length()!=11) {
			return "长度有误"; }
		
		String id_1=id.substring(0, 7);
		String id_2=id.substring(7, 10);
		String id_3=id.substring(10, 11);
		Id_16check tempCheck16 = new Id_16check();
		Id_1check tempCheck1 = new Id_1check();
		
		if(tempCheck16.check(id_1).equals("right")){
			if(tempCheck1.isNumber(id_2) && tempCheck1.isNumber(id_3)){
				return "right";
			}
			else return "收费路段顺序码或保留位格式有误";
		}
		return tempCheck16.check(id_1);
	}
}
