package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:26
 * @function	： 检测客服合作机构编号（AGENCYUPLOAD）
 * @modify		：
 *
 ********************************************/

public class Id_2check {
	String[] normalBank={"001","002","003","004","005","006","007","008","009","010",
			"011","012","013","014","015","016","017","018","019","020",
			"021","022","023","024","025","026","027","028","029","030",
			"031","032","033","034","035","036","037","038","039","040",
			"041","042","043","044","045","046"};  //常见银行编码，扩展046

	public String check(String id) {
		if (id.length() != 11) {
			return "长度有误";
		}
		String id_1 = id.substring(0, 6);
		String id_2 = id.substring(6, 8);
		String id_3 = id.substring(8, 11);
		Id_1check tempCheck1 = new Id_1check();

		if (tempCheck1.check(id_1).equals("right")) {
			if (tempCheck1.isNumber(id_2)) {
				int id2 = Integer.parseInt(id_2);
				if (((id2 >= 1 && id2 <= 7) || id2 == 88 || id2==99)) {
					if(id_2.equals("02")) {
						if(iscontain(id_3)){
							return "right";
						}
						else return "银行顺序码不存在"; 
					}
					else return "right";
				}
				else
					return "合作机构类别范围有误";
			}
			else return "合作机构类别格式有误";
		} else
			return tempCheck1.check(id_1);
	}
	
	public boolean iscontain(String id){ 
		for(String temp:normalBank){
			if(id.equals(temp)){
				return true;
			}
		}
		return false;
	}
}
