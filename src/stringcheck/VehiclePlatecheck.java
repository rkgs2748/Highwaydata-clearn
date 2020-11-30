package stringcheck;
/********************************************
 * 											*
 * ******************************************
 * @author		： liuqy
 * @create date	：20170907 10:30
 * @function	： 校验汽车号牌（VehiclePlate）
 * @modify		：
 *
 ********************************************/
public class VehiclePlatecheck {
    //public String provinceAbbr="粤";  //配置参数，当前省份简称
    final String provinceAbbr[] = {"京","津","沪","渝","黑",
			"吉","辽","晋","冀","青",
			"鲁","豫","苏","皖","浙",
			"闽","赣","湘","鄂","粤",
			"琼","甘","陕","贵","云",
			"川","蒙","新","藏","宁",
			"桂","南","成","广","空","军","济","兰","海","沈" //31个省，直辖市，自治区简称，军区简称
	};
    
    final String plateSuffix[] = {"学","警","挂","港","澳","领"  //专用号牌后缀 "试","超"
	};
    
    public char maxCityNumber='Z';  //配置参数，当前省份汽车号牌字母最大
    
	public String check(String plate)
	{
	    if(plate.length()!=6 && plate.length()!=7 && plate.length()!=8) {
			return "长度有误";
			}
	    
	    if(plate.equals("默A00000_9")){  //放行默认值车辆号牌
	    	return "right";
	    }
	    
	    if(plate.contains("使")){  //放行大使馆车
	    	return "right";
	    }
	    
	    String head = plate.substring(0, 2);
	    if(head.equals("WJ")){  //放行长度为8的武警号牌车，如：WJ粤12345_0
	    	if(plate.length()==8){
	    		if(isProvinceAbbr(head)){
	    			return "right";
	    		} else
	    			return "武警车号牌省份简称有误";
	    	} else
	    		return "武警车号牌长度有误";
	    }
	    
	    if(charNum(head) == 2 && !head.equals("WJ")){  //放行长度为7且首部两位为字母组合的军车(不含WJ)
	    	if(plate.length()==7){
	    		return "right";
	    	}
	    	return "军车号牌长度有误";
	    }
	    
		String plate_1="";
		String plate_2="";
		String plate_3="";
		String plate_4="";
		
		if(plate.length()==6){
		plate_1=plate.substring(0, 1);
		plate_2=plate.substring(1, 2);
		plate_3=plate.substring(2, 5);
		plate_4=plate.substring(5, 6);
		}
		
		if(plate.length()==7){
		plate_1=plate.substring(0, 1);
		plate_2=plate.substring(1, 2);
		plate_3=plate.substring(2, 6);
		plate_4=plate.substring(6, 7);
		}
		
		if(plate.length()==8){
		plate_1=plate.substring(0, 1);
		plate_2=plate.substring(1, 2);
		plate_3=plate.substring(2, 7);
		plate_4=plate.substring(7, 8);
		}
		
		if (!isProvinceAbbr(plate_1))
			return "车牌号省份简称错误";
		else {
			if (!((plate_2.charAt(0) >= 'A') && (plate_2.charAt(0) <= maxCityNumber))) { // 发证机关代号范围判断
				return "发证机关代号范围错误";
			}
			
			if(plate_3.contains("O") || plate_4.contains("O")){  //顺序码排除字母O
				return "顺序码中不能包含字母O";
			}
			
			if ((isNumAndChar(plate_3) == 0 || isNumAndChar(plate_3) == 1
					|| isNumAndChar(plate_3) == 2 || isNumAndChar(plate_3) == 3)) {
				if (isPlateSuffix(plate_4) || isNumAndChar(plate_4) != -1) {
					if (isNumAndChar(plate_4) + isNumAndChar(plate_3) < 4) { // 顺序码最多允许出现3个字母
						return "right";
					} else
						return "顺序码字母数超出范围";
				} else
					return "车号牌最后一位编码范围有误";
			}
			return "顺序码字母数超出范围";
		}
	}
	
	/**
	 * @fuction : 计算字符串字母数之和
	 *
	 */
	public int charNum(String str){
		int i=0;
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)>='A' && str.charAt(index)<='Z') {
				++i;
			}
		}
		return i;
	}
	
	/**
	 * @fuction : 判断字符串是否为大写英文字母和数字组合
	 *
	 */
	public boolean isNumorChar(String str){
		int i=0;
		for(int index=0;index<str.length();index++){
			if((str.charAt(index)>='0' && str.charAt(index)<='9')||(str.charAt(index)>='A' && str.charAt(index)<='Z')){
				++i;
			}
		}
		if (i==str.length()) return true;
		return false;
	}
	
//	/**
//	 * @fuction : 判断字符串是否为大写英文字母和数字组合，且不包含‘I’，‘O’
//	 *
//	 */
//	public int isNumAndChar(String str){  //当字符串为纯字母和数字组合时，返回字母数目sum，若不是，返回-1
//		int i = 0;
//		int sum = 0;
//		for(int index=0;index<str.length();index++){
//			if((str.charAt(index)>='A' && str.charAt(index)<='Z' && (str.charAt(index) !='I') && (str.charAt(index) !='O'))){
//				   ++sum; //判断字母数目
//				   ++i;
//			}
//			else if((str.charAt(index)>='0' && str.charAt(index)<='9')){
//				++i;
//			}
//		}
//		if (i==str.length()) return sum;
//		else return -1;
//	}
	
	/**
	 * @fuction : 判断字符串是否为大写英文字母和数字组合，正确时返回存在的字母数，错误时返回-1
	 *
	 */
	public int isNumAndChar(String str){  //当字符串为纯字母和数字组合时，返回字母数目sum，若不是，返回-1
		int i = 0;
		int sum = 0;
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)>='A' && str.charAt(index)<='Z'){
				   ++sum; //字母数目自增
				   ++i;
			}
			else if((str.charAt(index)>='0' && str.charAt(index)<='9')){
				++i;
			}
		}
		if (i==str.length()) return sum;
		else return -1;
	}
	
	/**
	 * @fuction : 判断车牌简称是否合规
	 *
	 */
	public boolean isProvinceAbbr(String abbr){
		for(String temp:provinceAbbr){
			if(abbr.equals(temp)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @fuction : 判断车牌后缀是否合规
	 *
	 */
	public boolean isPlateSuffix(String suffix){
		for(String temp:plateSuffix){
			if(suffix.equals(temp)){
				return true;
			}
		}
		return false;
	}
}

/*编码规则：京A12345 */