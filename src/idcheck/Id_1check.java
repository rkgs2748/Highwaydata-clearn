package idcheck;

/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:23
 * @function	： 检测发行方编号（ISSUERUPLOAD）
 * @modify		：
 *
 ********************************************/

public class Id_1check {
	String[] provinceId={"11","12","13","14","15","21","22","23","31","32",
			"33","34","35","36","37","41","42","43","44","45",
			"50","51","52","53","61","62","63","64","65"};  //配置参数，不包括海南(46),西藏(54),台湾(71),香港(81),澳门(82)
	
//	public int check(String id)
//	{
//		//System.out.println("校验issuerId长度："+id.length());
//		if(id.length()!=6) {
//			return 3; }
//		String id_1=id.substring(0, 2);
//		String id_2=id.substring(2, 4);
//		String id_3=id.substring(4, 6);
//		if((iscontain(id_1)))
//		{
//			if(!(id_2.equals("01")) && !(id_2.equals("02")) && !(id_2.equals("03")) && !(id_2.equals("04"))) return 5;
//			if(isNumber(id_3)) { return 9; }
//			else return 4;
//		}
//		return 5;
//	}
	
	String[] ISSUERID={"050101",
			"110101","120101","130101","140101","150101",
			"210101","220101","230101",
			"310101","320101","330101","340101","350101",
			"360101","370101","370102",
			"410101","420102","430101","440101","450101",
			"500101","510101","510102","510103","510104",
			"510105","520101","530101",
			"610101","610102","610103","610104","610105",
			"610106","610107","620101","630101","640101",
			"650101",
			};  //配置参数
	
	public String check(String id)
	{
		if(id.toString().length() != 6){
			return "长度有误";
		}
		for(String temp:ISSUERID){
			if(temp.equals(id)){
				return "right";
			}
		}
		return "编码范围有误";
	}
	
	public boolean iscontain(String id){
		for(String temp:provinceId){
			if(id.equals(temp)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isNumber(String str){
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)<'0' || str.charAt(index)>'9'){
				return false;
			}
		}
		return true;
	}
}

/*编码规则：发行方编号(id)=省域编号（2）+参与方类型（2）+发行方顺序码（2）*/