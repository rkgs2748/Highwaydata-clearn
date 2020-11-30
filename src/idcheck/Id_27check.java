package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 16:35
 * @function	： 检测其他补交交易信息编号（OTHERESTITUTIONUPLOAD）
 * @modify		：
 *
 ********************************************/
import stringcheck.NumOrChar;
import stringcheck.TimeMomentcheck;

public class Id_27check { // 其他补交交易信息编号=出口车道编号+补交时间+保留位+交易类型+流水号
	Id_20check id20;
	TimeMomentcheck tmc;

	public String check(String id) {
		if (id.length() != 39) {
			return "长度有误";
		}
		
		id20 = new Id_20check(); // 收费车道编号
		NumOrChar temp = new NumOrChar();  // 数字校验
		tmc = new TimeMomentcheck(); // 时刻校验

		String id_1 = id.substring(0, 21);
		String id_2 = id.substring(21, 35);
		String id_3 = id.substring(35, 38); //保留位（2）+交易类型（1）
		String id_4 = id.substring(38, 39);
		
		if( !id20.check(id_1).equals("right")){
			return id20.check(id_1);
		}
		
		if( !temp.isNumber(id_4)){
			return "补交交易流水号格式错误";
		}
		
		if( !tmc.checkAbbr(id_2).equals("right")){
			return tmc.checkAbbr(id_2);
		}
		
		if(id_3.equals("002")){
			return "right";
		}
		else return "保留位或交易类型为非默认值";
	}
}
//G000511002001010100102016120115123401  37    交易编号
//G00051100200101010010201612011512340111 39   退费编号=交易编号+退费类型+流水
//G00051100200101010010201612011512340121 39   非现金补交交易编号

//G00051100200101010010201612011512340021  39  其他补交交易信息编号=出口车道编号+补交时间+保留位+交易类型+流水号
//G00051100200101010010201612011512340121