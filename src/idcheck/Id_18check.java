package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测收费站编号（TOLLSTATIONUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_18check {
	public String check(String id)
	{
		if(id.length()!=14) {
			return "长度有误"; }
		
		String id_1=id.substring(0, 11);
		String id_2=id.substring(11, 13);
		String id_3=id.substring(13, 14);
		Id_17check tempCheck17 = new Id_17check();
		Id_1check tempCheck1 = new Id_1check();
		
		if(tempCheck17.check(id_1).equals("right")){
			if(tempCheck1.isNumber(id_2) && tempCheck1.isNumber(id_3)){
				return "right";
			}
			else return "收费站顺序码或保留位格式有误";
		}
		return tempCheck17.check(id_1);
	}
}
