package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测收费公路编号（TOLLROADUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_16check {
	public String check(String id)
	{
		if(id.length()!=7) {
			return "长度有误"; }
		
		String id_1=id.substring(0, 1);
		String id_2=id.substring(1, 5);
		String id_3=id.substring(5, 7);
		Id_1check tempCheck1 = new Id_1check();
		
		if((id_1.equals("G"))||(id_1.equals("S"))||(id_1.equals("X"))
				||(id_1.equals("Y"))||(id_1.equals("Z"))){
			if(tempCheck1.iscontain(id_3)){
				if(isNumAndChar(id_2)){
				return "right";
				}
				else return "公路编号格式有误";
			}
			else return "省域编号范围有误";
		}
		return "公路标识符范围有误";
	}
	
	/**
	 * @fuction : 判断字符串是否为：“特定大写英文字母（S，W，E，N）和数字的组合,且字母只出现一次或零次”
	 *
	 */
	public boolean isNumAndChar(String str){
		int i = 0;
		int num = 0;
		for(int index=0;index<str.length();index++){
			if((str.charAt(index)>='0' && str.charAt(index)<='9')){
				++i;
			}
			else if(str.charAt(index)=='W' || str.charAt(index)=='E' || str.charAt(index)=='S' || str.charAt(index)=='N'){
				++i;
				++num;
			}
		}
		if (i==str.length() && (num==0 || num==1)) return true;
		else return false;
	}
}