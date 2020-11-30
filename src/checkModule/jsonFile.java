package checkModule;

import java.io.File;
import java.util.ArrayList;

public class jsonFile {
	
	public String fileNamePath;
	
	final String dataType[] = {"ISSUERUPLOAD","AGENCYUPLOAD","HALLUPLOAD","MOBILESERVICEUPLOAD","TERMINALUPLOAD",
			"ONLINEUPLOAD","PLATECHECK","USERUPLOAD","VEHICLEUPLOAD","CARDUPLOAD"
			,"BALANCEUPLOAD","OBUUPLOAD","CARDBLACKLISTUPLOAD","OBUBLACKLISTUPLOAD","LINKOWNERUPLOAD"
			,"TOLLROADUPLOAD","SECTIONUPLOAD","TOLLSTATIONUPLOAD","TOLLPLAZAUPLOAD","TOLLLANEUPLOAD"
			,"ENTRANSACTIONUPLOAD","EXTRANSACTIONUPLOAD","RECHARGEUPLOAD","REVERSALUPLOAD","REFUNDUPLOAD"
			,"ETCRESTITUTIONUPLOAD","OTHERRESTITUTIONUPLOAD","RESPLITDOWN","REIMBURSE","ACROSSPROVINCEUPLOAD"
			,"ACCOUNTUPLOAD"
	};
	
	final String dataIdentify[] = {"1_1","1_2","1_3","1_4","1_5",
			"1_6","1_7","1_8","1_9","1_10",
			"1_11","1_12","1_13","1_14","1_15",
			"1_16","1_17","1_18","1_19","1_20",
			"2_1","2_2","2_3","2_4","2_5",
			"2_6","2_7","2_8","2_9","3_1",
			"3_2"};
	
	public String read(String filePath){
		File f = new File(filePath);
		fileNamePath = filePath;
		ArrayList<String> dataNum = new ArrayList<String>();
		if(!f.exists()){
			System.out.println(filePath + " not exists");
			return null;
		}
		if(filePath.contains(".json")){
			int i=-1;
			i=iscontain(filePath);
			dataNum.add(dataIdentify[i]);
		}
		else{
			File file[] = f.listFiles();
			for (int i = 0; i < file.length; i++) {
				File fs = file[i];
				if (fs.isDirectory()) {
					System.out.println(fs.getName() + " [目录]");
				}
				else{
					int index=-1;
//					System.out.println(fs.getName());
					if(fs.getName().contains(".json")){
						index=iscontain(fs.getName());
						if(index!=-1 && !dataNum.contains(dataIdentify[index])){
							dataNum.add(dataIdentify[index]);
						}
						if(index==-1){
							System.out.println("测试文件夹test存在非法命名的业务类型文件：" + fs.getName());
						}
					}
				}
			}
		}
		String choose = "";
		for (int j=0; j<dataNum.size();j++){
			choose = choose + dataNum.get(j) + ",";
		}
		if(choose.equals("")){
			System.out.println("测试文件夹test无合法业务数据，请放入待校验单类业务数据json文件 !!!");
		}
		else{
			choose = choose.substring(0,choose.length()-1);
			System.out.println("+++++:" + choose);
		}
		return choose;
	}
	
	public int iscontain(String fileName){
		int i =0;
		for(String temp:dataType){
			if(fileName.contains(temp)){
				return i;
			}
			i++;
		}
		return -1;
	}
}
