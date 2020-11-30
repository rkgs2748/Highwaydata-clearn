package stringcheck;

public class NumOrChar {
	
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
	
	/**
	 * @fuction : 判断字符串是否为十六进制字母和数字组合
	 *
	 */
	public boolean isNumorHex(String str){
		int i=0;
		for(int index=0;index<str.length();index++){
			if((str.charAt(index)>='0' && str.charAt(index)<='9')
					||(str.charAt(index)>='A' && str.charAt(index)<='F')||(str.charAt(index)>='a' && str.charAt(index)<='f')){
				++i;
			}
		}
		if (i==str.length()) return true;
		return false;
	}
	
	/**
	 * @fuction : 判断字符串是否为纯数字组合
	 *
	 */
	public boolean isNumber(String str){
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)<'0' || str.charAt(index)>'9'){
				return false;
			}
		}
		return true;
	}
}
