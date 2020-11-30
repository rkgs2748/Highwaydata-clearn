package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测收费车道编号（TOLLLANEUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_20check {
	public String check(String id)
	{
		if(id.length()!=21) {
			return "长度有误"; }
		String Last = id.toString().substring(14, 21);  //截取最后7位字符，默认值为0
		if(Last.equals("0000000"))  //判断默认值
		 {
			Id_18check tempCheck18 = new Id_18check();
			String id_0=id.substring(0, 14);
			if(tempCheck18.check(id_0).equals("right")){
				return "right";
			}else
				return tempCheck18.check(id_0);
		 }
		
		String id_1=id.substring(0, 18);
		String id_2=id.substring(18, 20);
		String id_3=id.substring(20, 21);
		Id_19check tempCheck19 = new Id_19check();
		Id_1check tempCheck1 = new Id_1check();
		
		if(tempCheck19.check(id_1).equals("right")){
			if(tempCheck1.isNumber(id_2) && tempCheck1.isNumber(id_3)){
				return "right";
			}
			else return "收费车道顺序码或保留位格式有误";
		}
		return tempCheck19.check(id_1);
	}
}
