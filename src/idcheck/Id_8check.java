package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测客户编号（USERUPLOAD）
 * @modify		：
 *
 ********************************************/
import stringcheck.TimeDatecheck;

public class Id_8check {
	String[] issuerId={"050101","110101","120101","130101","140101","150101","210101","220101","230101","310101","320101",
			"330101","340101","350101","360101","370101","370102","410101","420102","430101","440101",
			"450101","500101","510101","510102","510103","510104","510105","520101","530101","610101",
			"610102","610103","610104","610105","610106","610107","620101","630101","640101","650101"};  //配置参数
	
	public String check(String id)
	{
		if(id.length()!=17) {
			return "长度有误"; }
		String id_1=id.substring(0, 6);
		String id_2=id.substring(6, 12);
		String id_3=id.substring(12, 17);
		TimeDatecheck timeTemp = new TimeDatecheck();
		Id_1check tempCheck1 = new Id_1check();
		if((iscontain(id_1)))
		{
			if(timeTemp.check_len6(id_2).equals("right")){
				if(tempCheck1.isNumber(id_3)) return "right";
				else return "流水顺序码格式有误";
			}
			else return timeTemp.check_len6(id_2);
		}
		return "发行方编号范围有误";
	}
	
	public boolean iscontain(String id){
		for(String temp:issuerId){
			if(id.equals(temp)){
				return true;
			}
		}
		return false;
	}
}
