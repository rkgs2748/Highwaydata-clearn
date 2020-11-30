package checkModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class enCodingClass {
	ArrayList<String> field = new ArrayList<String>();
	ArrayList<String> codeStandard = new ArrayList<String>();
	String configurationFilePath="C:\\configurationFile";
	
	final String dataType[] = {"ISSUERUPLOAD","AGENCYUPLOAD","HALLUPLOAD","MOBILESERVICEUPLOAD","TERMINALUPLOAD",
			"ONLINEUPLOAD","PLATECHECK","USERUPLOAD","VEHICLEUPLOAD","CARDUPLOAD"
			,"BALANCEUPLOAD","OBUUPLOAD","CARDBLACKLISTUPLOAD","OBUBLACKLISTUPLOAD","LINKOWNERUPLOAD"
			,"TOLLROADUPLOAD","SECTIONUPLOAD","TOLLSTATIONUPLOAD","TOLLPLAZAUPLOAD","TOLLLANEUPLOAD"
			,"ENTRANSACTIONUPLOAD","EXTRANSACTIONUPLOAD","RECHARGEUPLOAD","REVERSALUPLOAD","REFUNDUPLOAD1"
			,"ETCRESTITUTIONUPLOAD","OTHERRESTITUTIONUPLOAD","REFUNDUPLOAD2","ACROSSPROVINCEUPLOAD","ACCOUNTUPLOAD"
	};
	
	public void readConfiguration(String moduleFileName) throws IOException{
		File f = new File(configurationFilePath);
		if (!f.exists()) {
			System.out.println(configurationFilePath + " not exists");
			return;
		}

		File file[] = f.listFiles();
		for (int i = 0; i < file.length; i++) {
			File fs = file[i];
			if (fs.isDirectory()) {
				System.out.println(fs.getName() + " [目录]");
			} else {
				String str = null;
				if (fs.getName().contains(moduleFileName)) {
//					System.out.println("fs.getName()："+fs.getName());
					 	String enc = null; // or NULL to use systemdefault
				        UnicodeInputStream uin = new UnicodeInputStream(new FileInputStream(fs),enc);  //如果是本地将url.openStream -> new FileInputStream(f)
				        enc = uin.getEncoding(); // check and skip possible BOM bytes
				        InputStreamReader in;
				        if (enc == null){
				            in = new InputStreamReader(uin);
				        }else {
				            in = new InputStreamReader(uin, enc);
				        }
					BufferedReader reader = new BufferedReader(in);
					while ((str = reader.readLine()) != null) {
						if(str.contains(":")){
//							System.out.println("str："+str);
							String[] temp = str.split(":");
							field.add(temp[0].toString());
							codeStandard.add(temp[1].toString());
						}
						
					}
				}
			}
		}
	}
	
	public String getCodeStandard(String fieldName){
		int i=0;
		i = field.indexOf(fieldName);
//		System.out.println("i："+i);
//		System.out.println("fieldName："+fieldName);
//		System.out.println("fieldName："+fieldName.length());
//		System.out.println("codeStandard.get(i)："+codeStandard.get(i));
		return codeStandard.get(i);
	}
	
	public int isContainFeild(String fieldName){
		return field.indexOf(fieldName);
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
