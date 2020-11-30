package idcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： caohsh
 * @create date	：20170907 15:35
 * @function	： 检测充值交易流水编号（RECHARGEUPLOAD）
 * @modify		：
 *
 ********************************************/
import stringcheck.TimeMomentcheck;

public class Id_23check {
	public String check(String id) {
		if (id.length() > 38 || id.length() < 32) {
			return "长度有误";
		}
		
		String id_1 = id.substring(0, 1);
		String id_2 = null;
		String id_3 = null;
		String id_4 = null;
		TimeMomentcheck timeTemp = new TimeMomentcheck();
		Id_1check tempCheck1 = new Id_1check();
		
		if (id_1.equals("1")) {  //服务网点,19
			if(id.length() < 35){
				return "渠道类型1与流水号长度不符";
			}
			id_2 = id.substring(1, 20);
			id_3 = id.substring(20, 34);
			id_4 = id.substring(34, id.length());
			Id_3check tempCheck3 = new Id_3check();
			if (tempCheck3.check(id_2).equals("right")) {
				if (timeTemp.checkAbbr(id_3).equals("right")) {
					if (tempCheck1.isNumber(id_4)) {
						return "right";
					} else
						return "流水号格式有误";
				} else
					return timeTemp.checkAbbr(id_3);
			} else
				return tempCheck3.check(id_2);
		} 
		else if (id_1.equals("2")) {  //自助终端,19
			if(id.length() < 35){
				return "渠道类型2与流水号长度不符";
			}
			id_2 = id.substring(1, 20);
			id_3 = id.substring(20, 34);
			id_4 = id.substring(34, id.length());
			Id_5check tempCheck5 = new Id_5check();
			if (tempCheck5.check(id_2).equals("right")) {
				if (timeTemp.checkAbbr(id_3).equals("right")) {
					if (tempCheck1.isNumber(id_4)) {
						return "right";
					} else
						return "流水号格式有误";
				} else
					return timeTemp.checkAbbr(id_3);
			} else
				return tempCheck5.check(id_2);
		} 
		else if (id_1.equals("3")) {  //线上渠道,15
			id_2 = id.substring(1, 16);
			id_3 = id.substring(16, 30);
			id_4 = id.substring(30, id.length());
			Id_6check tempCheck6 = new Id_6check();
			if (tempCheck6.check(id_2).equals("right")) {
				if (timeTemp.checkAbbr(id_3).equals("right")) {
					if (tempCheck1.isNumber(id_4)) {
						return "right";
					} else
						return "流水号格式有误";
				} else
					return timeTemp.checkAbbr(id_3);
			} else
				return tempCheck6.check(id_2);
		} 
		
		else if (id_1.equals("4")) {  //流动服务点,15
			id_2 = id.substring(1, 16);
			id_3 = id.substring(16, 30);
			id_4 = id.substring(30, id.length());
			Id_4check tempCheck4 = new Id_4check();
			if (tempCheck4.check(id_2).equals("right")) {
				if (timeTemp.checkAbbr(id_3).equals("right")) {
					if (tempCheck1.isNumber(id_4)) {
						return "right";
					} else
						return "流水号格式有误";
				} else
					return timeTemp.checkAbbr(id_3);
			} else
				return tempCheck4.check(id_2);
		} 
		
		else {
			return "渠道类型范围有误";
		}
	}
}
