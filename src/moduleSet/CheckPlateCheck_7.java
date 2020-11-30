package moduleSet;

import stringcheck.VehiclePlatecheck;

public class CheckPlateCheck_7 {
public static boolean [] array = {false, false,false};
	
	static final String userUploaddw[] = {"vehiclePlate","vehicleColor","vehicleType"};
	
	public static String checkRequiredKey(){  
		String results = "";

			for(int i=0; i<array.length; i++){
//				System.out.println("array： "+array[i]);
				if(array[i] == false){
						if(results.equals("")){
							results = userUploaddw[i];
						}
						else results = results +","+ userUploaddw[i];
				}
			}
			initArray();
			return results;		

	}
	
	public static void initArray(){  //初始化array数组,参数
		for(int i=0; i<array.length; i++){
			array[i] = false;
		}
	}
	
	public static String checkPlateCheck(String key, Object obj){
		if (key.equals("vehiclePlate")) return checkVehiclePlate(obj);
		else if (key.equals("vehicleColor")) return checkVehicleColor(obj);
		else if (key.equals("vehicleType")) return checkVehicleType(obj);
		else if (key.equals("timeMillStr")) return "right";
		else return "NO";
	}

	private static String checkVehiclePlate(Object vehiclePlate) {
		array[0] = true;
		VehiclePlatecheck check1 = new VehiclePlatecheck();
		if (vehiclePlate == null || (vehiclePlate.toString()).length() <= 0
				|| vehiclePlate.toString().equals("null") || vehiclePlate.toString().equals("NULL")){
			return "必填项缺失";
		}
		 boolean type = vehiclePlate instanceof String;
		if (type){
			return check1.check(vehiclePlate.toString());
		}
		return "数据类型不符";
	}

	private static String checkVehicleColor(Object vehicleColor) {
		array[1] = true;
		if (vehicleColor == null || (vehicleColor.toString()).length() <= 0
				|| vehicleColor.toString().equals("null") || vehicleColor.toString().equals("NULL")){
			 return "必填项缺失";
		 }
		 boolean type = vehicleColor instanceof Integer;
		 if (type){
			 int i=Integer.parseInt(vehicleColor.toString());
			 if ((i>=0 && i<=6) || i==9){  //已修改
				 return "right";
			 }
			 else
				 return "编码范围有误";
		 }
		return "数据类型不符";
	}
	
	public static String checkVehicleType(Object type){  //返回:1表示必填为空，2表示类型不符，3表示规则错误，4表示校验通过
		array[2] = true;
		 if(type == null || (type.toString()).length() <= 0
				 || type.toString().equals("null") || type.toString().equals("NULL"))
		 {
			 return "必填项缺失";
		 }
		 boolean type1 = type instanceof Integer;
		 if(type1)
		 {
			 int i=Integer.parseInt(type.toString());
			 if((i>=1&&i<=4) || (i>=11&&i<=15)) {return "right";}  //已修改
			 else return "编码范围有误";
		 }
		 return "数据类型不符";
	 }
}
