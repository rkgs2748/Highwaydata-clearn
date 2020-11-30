package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测收费公路经营管理单位编号（LINKOWNERUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_15check {
	public String check(String id)
	{
		if(id.length()!=7) {
			return "长度有误"; }
		
		String id_1=id.substring(0, 2);
		String id_2=id.substring(2, 4);
		String id_3=id.substring(4, 7);
		Id_1check tempCheck1 = new Id_1check();
		
		if((tempCheck1.iscontain(id_1)))
		{
			if((id_2.equals("01"))||(id_2.equals("02"))||(id_2.equals("03"))||(id_2.equals("04"))){
			if(tempCheck1.isNumber(id_3)){
				return "right";
			}
			else return "经营管理单位顺序码格式有误";
			}
			else return "参与方类型范围有误";
		}
		else return "省域编号范围有误";
	}
}
