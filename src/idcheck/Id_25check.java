package idcheck;

import stringcheck.NumOrChar;

/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 16:35
 * @function	： 检测退费交易编号（REFUNDUPLOAD）
 * @modify		：
 *
 ********************************************/
public class Id_25check {
	Id_21check id21;
	
	public String check(String id)
	{
		if(id.length()!=39) {
			return "长度有误"; }
		
		id21= new Id_21check();
		NumOrChar temp = new NumOrChar();
		String id_1 = id.substring(0, 37);
		String id_2 = id.substring(37, 38);
		String id_3= id.substring(38, 39);
		
		if( !id_2.equals("1") ){  //退费交易默认为"1"？
			return "退费交易默认值错误";
		}
		
		if ( !temp.isNumber(id_3)){
			return "退费交易流水号格式错误";
		}
		
		if(id21.check(id_1).equals("right")){
			return "right";
		}
		else return id21.check(id_1);
	}
}
//G000511002001010100102016120115123401  37    交易编号
//G00051100200101010010201612011512340111 39   退费编号=交易编号+退费类型+流水