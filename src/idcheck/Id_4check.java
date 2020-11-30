package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:26
 * @function	： 检测流动服务点编号（MOBILESERVICEUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_4check {
	public String check(String id)
	{
		if(id.length()!=15) {
			return "长度有误";
		}
		String id_1=id.substring(0, 11);
		String id_2=id.substring(11, 15);
		Id_1check tempCheck1 = new Id_1check();
		Id_2check tempCheck2 = new Id_2check();
		if(tempCheck2.check(id_1).equals("right")){
			if(tempCheck1.isNumber(id_2)){
				return "right";
			}
			else return "流动服务点顺序码格式有误";
		}
		return tempCheck2.check(id_1);
	}
}
