package stringcheck;

public class telIdentification {
	String[] NIN = {"13","14","15","17","18","19"};
//	String[] zoneNum = {"010","021","022","023","852","853",
//			"031","033","057","058","024","041","042","027","071","072",
//			"025","051","052","047","048","079","070","035","093","094",
//			"053","045","059","020","075","076","066","028","081","082",
//			"083","084","073","074","037","039","087","069","088","055",
//			"056","095","043","044","077","085","029","091","097","089",
//			"099","090"};
	
	public String identifyTel(String tel){
		//座机号识别
		if(tel.contains("-")){
			if(tel.toString().length() < 10){  //添加长度进行拦截
				return "长度有误";
			}
			String[] temp;
			if(tel.contains("-")){
				temp = tel.split("-");
				if(temp[0].length()!=3 && temp[0].length()!=4){
					return "区号长度有误";
				}
				if(temp[1].length()!=6 && temp[1].length()!=7 && temp[1].length()!=8){
					return "号码长度有误";
				}
				if(temp.length > 2){  //当有分机情况时，校验分机号格式
					if(!isNumber(temp[2])){
						return "分机号格式有误";
					}
				}
				
				String zoneNum1 = "";
				String zoneNum2 = "A";
				if(temp[0].length()==3){
				zoneNum1 = temp[0];
				}
				if(temp[0].length()==4){
				zoneNum1 = temp[0].substring(0, 3);
				zoneNum2 = temp[0].substring(3, 4);
				}
				
				if(isNumber(zoneNum1) && (isNumber(zoneNum2)|| zoneNum2.equals("A"))){  //不校验区号范围，只校验格式为数字即可
					if(isNumber(temp[1])){
						return "right";
					}
					else return "号码格式有误";
				}
				else{
					return "区号范围有误";
				}
			}
			
		}
		//手机号识别
		else if(tel.toString().charAt(0)=='1'){
			if(tel.toString().length() != 11){
				return "手机号长度有误";
			}
				String tel1 = tel.substring(0, 2);
				String tel2 = tel.substring(2, 11);
				if(isNumber(tel2)){
					if(iscontainNIN(tel1)){
					return "right";
					}
					else return "运营商号码段范围有误";
				}
				else return "号码格式有误";
		}
		return "座机号格式有误，请检查连字符是否正确";
	}
	
	public boolean iscontainNIN(String id){
		for(String temp:NIN){
			if(id.equals(temp)){
				return true;
			}
		}
		return false;
	}
	
//	public boolean iscontainzoneNum(String id){
//		for(String temp:zoneNum){
//			if(id.equals(temp)){
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean isNumber(String str){
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)<'0' || str.charAt(index)>'9'){
				return false;
			}
		}
		return true;
	}
}
