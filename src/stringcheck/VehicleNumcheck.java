package stringcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 10:30
 * @function	： 校验车辆编号（VehicleNumber）
 * @modify		：
 *
 ********************************************/
public class VehicleNumcheck {
	VehiclePlatecheck vpc;  //车号牌校验

	public String check(String num) {
		if(num.equals("默A00000_9")){  //允许默认值
			 return "right";
		 }
		
		if (num.length() != 8 && num.length() != 9 && num.length() != 10) {
			return "长度有误";
		}
		
		String[] numArray;
		if (num.contains("_")) {
			numArray = num.split("_"); // "."为转义字符
			if(numArray.length != 2){ //判断“_”两侧非空
				return "格式有误";
			}
		} else
			return "格式有误";

		vpc = new VehiclePlatecheck();
		int num_1 = 0;

		if (isNumber(numArray[1])) {
			num_1 = Integer.parseInt(numArray[1]);
		} else
			return "车辆颜色格式有误";

		if ( !vpc.check(numArray[0]).equals("right"))
			return vpc.check(numArray[0]);
		else {
			if (num_1 <= 6 || num_1 == 9) {
					return "right";
			} else
				return "车辆颜色范围有误";
		}
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

/*编码规则：车辆编号（id） =车牌号码+间隔符+车牌颜色间隔符： “_”，如：京A88888_1 */