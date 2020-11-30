package checkModule;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import moduleSet.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import stringcheck.TimeMomentcheck;

public class checkModule extends Thread {
	
	public ArrayList<checkResults> storeResult;
	public static ArrayList<docInformation> storeDocInformation = new ArrayList<docInformation>();
	ArrayList<String> businessData = new ArrayList<String>();
	public String DataType="";  //数据类型
	public static int bookNum=1;
	String bookName="";  //工作簿
	String sheetName="";  //sheet
	String idTemp="";  //主键
	int m=0;
	public static long wrong=0;//错误的json对象数
	public static int sheetNum=0;
	
	public int fieldTotal=0;

	public static long totalResults=0;
	public static long result_record=0;
	public static long result_parse=0;
	public static long sum_total=0;
	long  n=0;  //校验的记录总数
	int verifyValue=0;
	int verifyTotal=0;
	public static int percent=0;
	public static String excelFilePath=null;
	public String fileNamePath;
	
	final String dataType[] = {"ISSUERUPLOAD","AGENCYUPLOAD","HALLUPLOAD","MOBILESERVICEUPLOAD","TERMINALUPLOAD",
			"ONLINEUPLOAD","PLATECHECK","USERUPLOAD","VEHICLEUPLOAD","CARDUPLOAD"
			,"BALANCEUPLOAD","OBUUPLOAD","CARDBLACKLISTUPLOAD","OBUBLACKLISTUPLOAD","LINKOWNERUPLOAD"
			,"TOLLROADUPLOAD","SECTIONUPLOAD","TOLLSTATIONUPLOAD","TOLLPLAZAUPLOAD","TOLLLANEUPLOAD"
			,"ENTRANSACTIONUPLOAD","EXTRANSACTIONUPLOAD","RECHARGEUPLOAD","REVERSALUPLOAD","REFUNDUPLOAD"
			,"ETCRESTITUTIONUPLOAD","OTHERRESTITUTIONUPLOAD","RESPLITDOWN","REIMBURSE","ACROSSPROVINCEUPLOAD",
			"ACCOUNTUPLOAD"};
	
	final static String dataTypeChs[] = {"发行方信息","客服合作机构","服务网点信息","流动服务网点信息","自助服务终端信息",
		"线上服务渠道信息","车牌唯一性验证","客户信息","客户车辆信息","用户卡信息"
		,"用户卡帐余额","OBU信息","用户卡黑名单","OBU黑名单","收费公路经营管理单位信息"
		,"收费公路","收费路段","收费站","收费广场","收费车道"
		,"入口交易信息","出口交易信息","充值交易","冲正交易","退费交易"
		,"非现金补交交易","其他补交交易","指令拆分","退款交易","跨省交易",
		"记账交易"};
	
	final static int[] dataFieldNum={8,7,10,4,7,
		6,3,17,33,15,
		3,16,5,5,6,
		14,19,6,10,8,
		13,27,5,3,9,
		8,11,9,4,18,
		3
	};
	//字段固定数，json对象总数
	int dataFieldNumTemp=0;
	int jsonObjectNum=0;
	int datafileNum=0;
	
	//文件数是否为1
	boolean fileNumisOne=false;
	
	final String dataIdentify[] = {"1_1","1_2","1_3","1_4","1_5",
			"1_6","1_7","1_8","1_9","1_10",
			"1_11","1_12","1_13","1_14","1_15",
			"1_16","1_17","1_18","1_19","1_20",
			"2_1","2_2","2_3","2_4","2_5",
			"2_6","2_7","2_8","2_9","3_1",
			"3_2"};
	
	final String dataId[] = {"id","id","id","id","id",
			"id","vehiclePlate","id","id","id",
			"cardId","id","cardId","OBUId","id",
			"id","id","id","id","id",
			"id","id","id","id","id",
			"id","id","id","id","id",
			"id"
	};
	
	public static void setBookNum(){  //设置bookNum为初始1
		bookNum = 1;
	}
	
	public void readFile(String filePath, String moduleNum) throws IOException, ParseException {
		percent=0;
		/**
		 * 初始化静态变量
		 */
		initStaticVariable();
		/**
		 * 初始化百分比配置文件
		 */
		this.initPercent();
		long startTime=System.currentTimeMillis();
		File fileTest = new File("C:\\test");
		if  (!fileTest .exists()  && !fileTest.isDirectory())  //判断文件夹是否存在，不存在则新建test文件夹，并在前端提示用户添加数据
		{
		    System.out.println("文件夹test不存在 !，已新建，请将待检测数据放入test文件夹下！");
		    fileTest .mkdir();
		}
		
		File f = new File(filePath);
		fileNamePath = filePath;
		String[] strModuleNumTemp = moduleNum.split(",");
		if (!f.exists()) {
			System.out.println(filePath + " not exists");
			return;
		}
		storeResult = new ArrayList<checkResults>();
		
		System.out.println("校验开始，请勿刷新或重复点击确认校验按钮，重复点击或刷新后请重新启动tomcat，耐心等待………");
		if (filePath.contains(".json") && iscontain(filePath)!=-1) {
			int i = -1;
			i = iscontain(filePath);
			DataType = dataTypeChs[i]; // 模块名
			
			verifyTotal=1;
//			sum_total=1;
			if (moduleNum.contains(dataIdentify[i])) {
				callFunctions(f, strModuleNumTemp[0]);
			}
		}
		else {
			File file[] = f.listFiles();
			int j = -1;
			verifyTotal=file.length;
//			sum_total=verifyTotal;
			//文件个数为1时，作赋值，为后面打文件处理准备

			if(file.length==1){
				fileNumisOne = true;
			}
			
			if(file.length==0){
				return;
			}
			for (int i = 0; i < file.length; i++) {
				File fs = file[i];
				//datafileNum = (i+1)*10;  //lqy注释，什么意思？
				if (fs.getName().length()<5 || !fs.getName().substring(fs.getName().length()-5).equals(".json")) {
					System.out.println(fs.getName() + "：不是json文件");
				} else {
					int index = -1;
					//System.out.println(fs.getName());
					if (fs.getName().contains(".json") && iscontain(fs.getName())!=-1) {
						index = iscontain(fs.getName());
						if(index!=-1 && !businessData.contains(dataTypeChs[index])){
							businessData.add(dataTypeChs[index]);
						}
						if (i <= 2 && index!=-1) {
							j = iscontain(fs.getName());
							DataType = dataTypeChs[j];
							dataFieldNumTemp = dataFieldNum[j];
						} // 模块名
						int strTempIndex=0;
						for(String strTemp:strModuleNumTemp){
							if (index!=-1 && strTemp.equals(dataIdentify[index])) {
								callFunctions(fs, strModuleNumTemp[strTempIndex]);
								verifyValue++;
							}
							if(!fileNumisOne){
								if((int)((1.0*verifyValue/verifyTotal)*100)!=100){
									percent=(int)((1.0*verifyValue/verifyTotal)*100);
									this.writePercent();  //lqy新增
								}
							}
							strTempIndex++;
						}
					}
				}
			}
		}
		System.out.println("本次校验的记录总数: " + n);
		System.out.println("存在错误的记录总数: " + wrong);
		result_record = wrong;
		wrong = 0;
		
		totalResults += storeResult.size();
		System.out.println("存在错误的字段总数: " + totalResults);
		result_parse = totalResults;
		totalResults= 0;
		

		this.writeResultData(Long.toString(sum_total),Long.toString(result_record),Long.toString(result_parse));
		
//		excelExportTemp.outputFieldErro();
		long endTime=System.currentTimeMillis();
		System.out.println("本次校验耗时: "+(endTime-startTime)+"ms");
		percent=100;
		this.writePercent();
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
	
	public static int iscontainName(String fileName){
		int i =0;
		for(String temp:dataTypeChs){
			if(fileName.contains(temp)){
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public void callFunctions(File file, String moduleNum) throws IOException, ParseException{  //主调函数

	        String enc = null; // or NULL to use systemdefault
	        UnicodeInputStream uin = new UnicodeInputStream(new FileInputStream(file),null);  //如果是本地将url.openStream -> new FileInputStream(f)
	        enc = uin.getEncoding(); // check and skip possible BOM bytes
	        InputStreamReader in;
//	        System.out.println("enc:"+enc);
	        if (enc == null){
//	        	System.out.println("文件格式正确，没有bom头 部。");
	            in = new InputStreamReader(uin,"UTF-8");
	        }else {
	        	System.out.println("文件格式错误，文件不能包含bom头部 ："+file.getName());  //不对含bom头文件校验
//	            in = new InputStreamReader(uin, enc);
	        	uin.close();
	            return;
	        }

		BufferedReader reader = new BufferedReader(in);
		String str = null;
		int idIndex=0;
		for(String temp:dataIdentify){
			if(temp.equals(moduleNum)){
				break;
			}
			idIndex++;
		}
		idTemp=dataId[idIndex]; //存主键
		
		bookName = DataType + "_" + idTemp +"_"+bookNum; //Excel 参数，bookNum为全局参数
		sheetName = DataType;
		
        System.out.println("fileNumisOne： "+fileNumisOne);
        while ((str = reader.readLine()) != null) {
        	String pkeyValue="";  //主键值
    		try {
    			if(!str.contains("[")){  //当文件有1个对象时
    				++jsonObjectNum;
    				JSONObject dataJson = new JSONObject();
    				try {
        				dataJson=JSONObject.fromObject(str);
    					} catch (JSONException e1) {
    						System.out.println("json文件格式有误:"+file.getName());
//    						e1.printStackTrace();
    						reader.close();
    						in.close();
    						return;
    					}	
    				sum_total++;
    				++n;
    				Set<?> keySet = dataJson.keySet(); // key的set集合 
    	            Iterator<?> it = keySet.iterator();
    	            while(it.hasNext()){
		            	 Object k = it.next(); // key
		            	 Object v = dataJson.get(k); //value
		            	 searchRelatedKey(moduleNum, k, v);  //调用关联参数模块
	                     if(k.equals(idTemp)){
	                    	 v = dataJson.get(k);  //value
	                    	 pkeyValue=v.toString();  //primarykey
	                    	 //break;
	                     }
		            }
    	            Iterator<?> it1 = keySet.iterator();
    	            while(it1.hasNext()){
    	            	fieldTotal++;
                         Object k = it1.next(); // key
                         Object v = dataJson.get(k);  //value 
                         String result=callModule(k.toString(), v, moduleNum);
                         //System.out.println("检测结果:"+result);
	                     if ( !result.equals("right") )
                    	 {
                    		 checkResults crs=new checkResults();
                    		 crs.primaryKeyValue=pkeyValue;
                    		 crs.Key=k.toString();
                    		 crs.keyValue=v.toString();
                    		 crs.errorInfo=result;
                    		 storeResult.add(crs);
                    		 ++m;  //指示是否存在错误
                    	 }
    	            }

    	            String error = keyStatistic(moduleNum);  //处理必填字段缺失
					if (!error.equals("")) {
						if (!error.contains(",")) {
							checkResults crs = new checkResults();
							crs.primaryKeyValue = pkeyValue;
							crs.Key = error;
							crs.keyValue = "";
							crs.errorInfo = "记录缺失该必填字段"; // 类型为"less"时，表示必填字段缺失
							storeResult.add(crs);
							
						} // 解决导出错误描述时，出现能够找到编码规范的情况
						else {
							String tempLose[] = error.split(",");
							for (String temp : tempLose) {
								checkResults crsTemp = new checkResults();
								crsTemp.primaryKeyValue = pkeyValue;
								crsTemp.Key = temp;
								crsTemp.keyValue = "";
								crsTemp.errorInfo = "记录缺失该必填字段"; // 类型为"less"时，表示必填字段缺失
								storeResult.add(crsTemp);
								
							}
						}
						if(m==0) ++wrong;  //若记录中不存在不合规数据，则记录数自增1
					}

    	            if(m!=0) ++wrong; m=0;  //wrong统计错误记录数，m进行初始化
    	            if(fileNumisOne){
    	            	percent = 100;
    	            }
    			}
    			else{   //当文件有多个对象时
    				JSONArray dataJson = new JSONArray();
    				try {
    					dataJson = JSONArray.fromObject(str);
    					} catch (JSONException e1) {
    						System.out.println("json文件格式有误:"+file.getName());
//    						e1.printStackTrace();
    						reader.close();
    						in.close();
    						return;
    					}
    				sum_total++;
    				jsonObjectNum+=dataJson.size();
    				System.out.println("jsonObjectNum： "+jsonObjectNum);
    	            for (int index = 0; index < dataJson.size(); index++) {
    	            	++n;
    	            	JSONObject temp=dataJson.getJSONObject(index);
    	            	Set<?> keySet = temp.keySet(); // key的set集合
    		            Iterator<?> it = keySet.iterator();
    		            while(it.hasNext()){
    		            	 Object k = it.next(); // key
    		            	 Object v = temp.get(k);  //value
    		            	 searchRelatedKey(moduleNum, k, v);  //调用关联参数模块
    	                     if(k.equals(idTemp)){
    	                    	 v = temp.get(k);  //value
    	                    	 pkeyValue=v.toString();  //primarykey
    	                     }
    		            }
    		            Iterator<?> it1 = keySet.iterator();
    		            while(it1.hasNext()){
    		            	fieldTotal++;
    	                     Object k = it1.next(); // key
    	                     Object v = temp.get(k);  //value
    	                     String result=callModule(k.toString(), v, moduleNum);
    	                     if ( !result.equals("right"))
                        	 {
                        		 checkResults crs=new checkResults();
                        		 crs.primaryKeyValue=pkeyValue;
                        		 crs.Key=k.toString();
                        		 crs.keyValue=v.toString();
                        		 crs.errorInfo=result;
                        		 storeResult.add(crs);
                        		 ++m;  //指示是否存在错误
                        	 }
    		            }
    		            
        	            String error = keyStatistic(moduleNum);  //处理必填字段缺失
    					if (!error.equals("")) {
    						if (!error.contains(",")) {
    							checkResults crs = new checkResults();
    							crs.primaryKeyValue = pkeyValue;
    							crs.Key = error;
    							crs.keyValue = "";
    							crs.errorInfo = "记录缺失该必填字段"; // 类型为"less"时，表示必填字段缺失
    							storeResult.add(crs);
    							
    						} // 解决导出错误描述时，出现能够找到编码规范的情况
    						else {
    							String tempLose[] = error.split(",");
    							for (String temp1 : tempLose) {
    								checkResults crsTemp = new checkResults();
    								crsTemp.primaryKeyValue = pkeyValue;
    								crsTemp.Key = temp1;
    								crsTemp.keyValue = "";
    								crsTemp.errorInfo = "记录缺失该必填字段"; // 类型为"less"时，表示必填字段缺失
    								storeResult.add(crsTemp);
    								
    							}
    						}
    						if(m==0) ++wrong;  //若记录中不存在不合规数据，则记录数自增1
    					}
        	            
    		            if(fileNumisOne){
    		            	if(index < jsonObjectNum){  //lqy修改
    		            		if(index%1000==0){
    		            			percent=(int)((1.0*(index+1)/jsonObjectNum)*100);
    		            			this.writePercent();
    		            		}
    		            	}
    		            }
    		            if(m!=0) ++wrong; m=0;  //wrong统计错误记录数，m进行初始化
    	            }
    			}
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        reader.close();
        in.close();
	}
	
	public static void searchRelatedKey(String module, Object key, Object value) throws ParseException {   //过滤出关联规则参数
		classDataType dataTypeTemp = new classDataType();
		if (module.equals(dataTypeTemp.USERUPLOAD)) {  //客户信息，registeredtype，userType，userIdType，agentIdType
			if(key.toString().equals("userType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckUserUpload_8.userType = Integer.parseInt(value.toString());  //获取用户类型参数
				 }
			}
			else if(key.toString().equals("registeredType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckUserUpload_8.registeredtype = Integer.parseInt(value.toString());  //获取开户方式参数
				 }
			}
			else if(key.toString().equals("userIdType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckUserUpload_8.userIdType = Integer.parseInt(value.toString());  //获取开户人证件类型参数
				 }
			}
			else if(key.toString().equals("agentIdType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckUserUpload_8.agentIdType = Integer.parseInt(value.toString());  //获取指定经办人证件类型参数
				 }
			}
		}
		else if (module.equals(dataTypeTemp.VEHICLEUPLOAD)) {  //客户车辆，registeredTypeTemp，
			if(key.toString().equals("registeredType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckVehicleUpload_9.registeredTypeTemp = Integer.parseInt(value.toString());  //获取录入方式参数
				 }
			}
			else if(key.toString().equals("ownerIdType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckVehicleUpload_9.ownerIdType = Integer.parseInt(value.toString());  //获取机动车所有人证件类型参数
				 }
			}
		}
		else if (module.equals(dataTypeTemp.CARDUPLOAD)) {  //用户卡信息，issuedTypeTemp
			if(key.toString().equals("issuedType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckCardUpload_10.issuedTypeTemp = Integer.parseInt(value.toString());  //获取用户类型参数
				 }
			}
			else if(key.toString().equals("enableTime")){
				 TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
				 boolean type1 = value instanceof String;
				 if (type1){
					 if(TimeMomentTemp.checkStandard(value.toString()).equals("-1")||
							 TimeMomentTemp.checkStandard(value.toString()).equals("0")||
							 TimeMomentTemp.checkStandard(value.toString()).equals("1")){
						     CheckCardUpload_10.enableTimeTemp = value.toString();  //获取用户卡启用时间参数
					 }
				 }
			}
		}
		else if (module.equals(dataTypeTemp.OBUUPLOAD)) {  //OBU信息，registeredTypeTemp，installTypeTemp
			if(key.toString().equals("registeredType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckOBUUpload_12.registeredTypeTemp = Integer.parseInt(value.toString());  //获取用户类型参数
				 }
			}
			else if(key.toString().equals("installType")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckOBUUpload_12.installTypeTemp = Integer.parseInt(value.toString());  //获取用户类型参数
				 }
			}
			else if(key.toString().equals("enableTime")){
				 TimeMomentcheck TimeMomentTemp = new TimeMomentcheck();
				 boolean type1 = value instanceof String;
				 if (type1){
					 if(TimeMomentTemp.checkStandard(value.toString()).equals("-1")||
							 TimeMomentTemp.checkStandard(value.toString()).equals("0")||
							 TimeMomentTemp.checkStandard(value.toString()).equals("1")){
						     CheckOBUUpload_12.enableTimeTemp = value.toString();  //获取OBU启用时间参数
					 }
				 }
			}
		}
		else if (module.equals(dataTypeTemp.TOLLSTATIONUPLOAD)) {  //收费站，type
			if(key.toString().equals("type")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckTollstationUpload_18.stationType = Integer.parseInt(value.toString());  //获取站类型参数
				 }
			}
		}
		else if (module.equals(dataTypeTemp.ENTRANSACTIONUPLOAD)) {  //入口交易，transType
			if(key.toString().equals("type")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckEnTransactionUpload_21.transType = Integer.parseInt(value.toString());  //获取交易类型参数
				 }
			}
		}
		else if (module.equals(dataTypeTemp.EXTRANSACTIONUPLOAD)) {  //出口交易，transType
			if(key.toString().equals("type")){
				 boolean type1 = value instanceof Integer;
				 if (type1){
					 CheckExTransactionUpload_22.transType = Integer.parseInt(value.toString());  //获取交易类型参数
				 }
			}
		}
		return ;
	}
	
	public static String callModule(Object key, Object value, String module) throws ParseException {
		classDataType dataTypeTemp = new classDataType();
		if (module.equals(dataTypeTemp.ISSUERUPLOAD)) {
			return CheckIssuerUpload_1.checkIssuers(key.toString(), value);  //1_1
		}
		else if (module.equals(dataTypeTemp.AGENCYUPLOAD)) {
			return CheckAgencyUpload_2.checkClientAgency(key.toString(), value);  //1_2
		}
		else if (module.equals(dataTypeTemp.HALLUPLOAD)) {
			return CheckHallUpload_3.checkServeStation(key.toString(), value);  //1_3
		}
		else if (module.equals(dataTypeTemp.MOBILESERVICEUPLOAD)) {
			return CheckMobileServiceUpload_4.checkMobileServiceUpload(key.toString(), value);  //1_4
		}
		else if (module.equals(dataTypeTemp.TERMINALUPLOAD)) {
			return CheckTerminalUpload_5.checkTerminalUpload(key.toString(), value);  //1_5
		}
		else if (module.equals(dataTypeTemp.ONLINEUPLOAD)) {
			return CheckOnlineUpload_6.checkOnlineUpload(key.toString(), value);  //1_6
		}
		else if (module.equals(dataTypeTemp.PLATECHECK)) {
			return CheckPlateCheck_7.checkPlateCheck(key.toString(), value);  //1_7
		}
		else if (module.equals(dataTypeTemp.USERUPLOAD)) {
			return CheckUserUpload_8.checkUserUpload(key.toString(), value);  //1_8,4个参数 
		}
		else if (module.equals(dataTypeTemp.VEHICLEUPLOAD)) {
			return CheckVehicleUpload_9.checkVehicleUpload(key.toString(), value);  //1_9
		}
		else if (module.equals(dataTypeTemp.CARDUPLOAD)) {
			return CheckCardUpload_10.checkCardUpload(key.toString(), value);  //1_10
		}
		else if (module.equals(dataTypeTemp.BALANCEUPLOAD)) {
			return CheckBalanceUpload_11.BalanceUpload(key.toString(), value);  //1_11
		}
		else if (module.equals(dataTypeTemp.OBUUPLOAD)) {
			return CheckOBUUpload_12.checkOBUUpload(key.toString(), value);  //1_12
		}
		else if (module.equals(dataTypeTemp.CARDBLACKLISTUPLOAD)) {
			return CheckCardBlackListUpload_13.checkCardBlackListUpload(key.toString(), value);  //1_13
		}
		else if (module.equals(dataTypeTemp.OBUBLACKLISTUPLOAD)) {
			return CheckOBUblackUpload_14.checkOBUblack(key.toString(), value);  //1_14
		}
		else if (module.equals(dataTypeTemp.LINKOWNERUPLOAD)) {
			return CheckLinkOwnerUpload_15.checkLinkOwnerUpload(key.toString(), value);  //1_15
		}
		else if (module.equals(dataTypeTemp.TOLLROADUPLOAD)) {
			return CheckTollroadUpload_16.checkTollroadUpload(key.toString(), value);  //1_16
		}
		else if (module.equals(dataTypeTemp.SECTIONUPLOAD)) {
			return CheckSectionUpload_17.checkSectionUpload(key.toString(), value);  //1_17
		}
		else if (module.equals(dataTypeTemp.TOLLSTATIONUPLOAD)) {
			return CheckTollstationUpload_18.checkTollstationUpload(key.toString(), value);  //1_18
		}
		else if (module.equals(dataTypeTemp.TOLLPLAZAUPLOAD)) {
			return CheckTollPlazaUpload_19.checkTollPlazaUpload(key.toString(), value);  //1_19
		}
		else if (module.equals(dataTypeTemp.TOLLLANEUPLOAD )) {
			return CheckTollLaneUpload_20.checkTollLane(key.toString(), value);  //1_20
		}
		else if (module.equals(dataTypeTemp.ENTRANSACTIONUPLOAD)) {  //2_1  3个参数
			return CheckEnTransactionUpload_21.checkEnTransaction(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.EXTRANSACTIONUPLOAD)) {  //2_2  3个参数
			return CheckExTransactionUpload_22.checkExTransaction(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.RECHARGEUPLOAD)) {  //2_3
			return CheckRechargeUpload_23.checkRecharge(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.REVERSALUPLOAD)) {  //2_4
			return CheckReversalUpload_24.checkReversal(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.REFUNDUPLOAD)) {  //2_5
			return CheckRefundUpload1_25.checkRefund(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.ETCRESTITUTIONUPLOAD)) {  //2_6
			return CheckETCRestitutionUpload_26.checkETCRestitution(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.OTHERRESTITUTIONUPLOAD)) {  //2_7
			return CheckOtherRestitutionUpload_27.checkOtherRestitution(key.toString(), value);
		}
		else if (module.equals(dataTypeTemp.REIMBURSE)) {  //2_8
			return CheckRefundUpload2_28.checkRefund(key.toString(), value);
		}
//		else if (module.equals(dataTypeTemp.ACROSSPROVINCEUPLOAD)) {  //3_1
//			return CheckAcrossProvinceUpload_29.checkAcrossProvince(key.toString(), value);
//		}
//		else if (module.equals(dataTypeTemp.ACCOUNTUPLOAD)) {  //3_2
//			return CheckAccountUpload_30.checkAccount(key.toString(), value);
//		}
		return "NE";
	}
	
	public static String keyStatistic(String module) {  //统计必填项
		classDataType dataTypeTemp = new classDataType();
		if (module.equals(dataTypeTemp.ISSUERUPLOAD)) {
			return CheckIssuerUpload_1.checkRequiredKey();  //1_1
		}
		else if (module.equals(dataTypeTemp.AGENCYUPLOAD)) {
			return CheckAgencyUpload_2.checkRequiredKey();  //1_2
		}
		else if (module.equals(dataTypeTemp.HALLUPLOAD)) {
			return CheckHallUpload_3.checkRequiredKey();  //1_3
		}
		else if (module.equals(dataTypeTemp.MOBILESERVICEUPLOAD)) {
			return CheckMobileServiceUpload_4.checkRequiredKey();  //1_4
		}
		else if (module.equals(dataTypeTemp.TERMINALUPLOAD)) {
			return CheckTerminalUpload_5.checkRequiredKey();  //1_5
		}
		else if (module.equals(dataTypeTemp.ONLINEUPLOAD)) {
			return CheckOnlineUpload_6.checkRequiredKey();  //1_6
		}
		else if (module.equals(dataTypeTemp.PLATECHECK)) {
			return CheckPlateCheck_7.checkRequiredKey();  //1_7
		}
		if (module.equals(dataTypeTemp.USERUPLOAD)) {
			return CheckUserUpload_8.checkRequiredKey();  //1_8,4个参数
		}
		else if (module.equals(dataTypeTemp.VEHICLEUPLOAD)) {
			return CheckVehicleUpload_9.checkRequiredKey();  //1_9
		}
		else if (module.equals(dataTypeTemp.CARDUPLOAD)) {
			return CheckCardUpload_10.checkRequiredKey();  //1_10
		}
		else if (module.equals(dataTypeTemp.BALANCEUPLOAD)) {
			return CheckBalanceUpload_11.checkRequiredKey();  //1_11
		}
		else if (module.equals(dataTypeTemp.OBUUPLOAD)) {
			return CheckOBUUpload_12.checkRequiredKey();  //1_12
		}
		else if (module.equals(dataTypeTemp.CARDBLACKLISTUPLOAD)) {
			return CheckCardBlackListUpload_13.checkRequiredKey();  //1_13
		}
		else if (module.equals(dataTypeTemp.OBUBLACKLISTUPLOAD)) {
			return CheckOBUblackUpload_14.checkRequiredKey();  //1_14
		}
		else if (module.equals(dataTypeTemp.LINKOWNERUPLOAD)) {
			return CheckLinkOwnerUpload_15.checkRequiredKey();  //1_15
		}
		else if (module.equals(dataTypeTemp.TOLLROADUPLOAD)) {
			return CheckTollroadUpload_16.checkRequiredKey();  //1_16
		}
		else if (module.equals(dataTypeTemp.SECTIONUPLOAD)) {
			return CheckSectionUpload_17.checkRequiredKey();  //1_17
		}
		else if (module.equals(dataTypeTemp.TOLLSTATIONUPLOAD)) {
			return CheckTollstationUpload_18.checkRequiredKey();  //1_18
		}
		else if (module.equals(dataTypeTemp.TOLLPLAZAUPLOAD)) {
			return CheckTollPlazaUpload_19.checkRequiredKey();  //1_19
		}
		else if (module.equals(dataTypeTemp.TOLLLANEUPLOAD )) {
			return CheckTollLaneUpload_20.checkRequiredKey();  //1_20
		}
		else if (module.equals(dataTypeTemp.ENTRANSACTIONUPLOAD)) {  //2_1  3个参数
			return CheckEnTransactionUpload_21.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.EXTRANSACTIONUPLOAD)) {  //2_2  3个参数
			return CheckExTransactionUpload_22.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.RECHARGEUPLOAD)) {  //2_3
			return CheckRechargeUpload_23.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.REVERSALUPLOAD)) {  //2_4
			return CheckReversalUpload_24.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.REFUNDUPLOAD)) {  //2_5
			return CheckRefundUpload1_25.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.ETCRESTITUTIONUPLOAD)) {  //2_6
			return CheckETCRestitutionUpload_26.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.OTHERRESTITUTIONUPLOAD)) {  //2_7
			return CheckOtherRestitutionUpload_27.checkRequiredKey();
		}
		else if (module.equals(dataTypeTemp.REIMBURSE)) {  //2_8
			return CheckRefundUpload2_28.checkRequiredKey();
		}
		return "";
	}
	
	public void writePercent(){
		File fileTemp = new File("C:\\configurationFile\\percent.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileTemp,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.write(Integer.toString(percent));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("percent6："+percent);
	}
	
	public void writeResultData(String sumTotal,String result_total,String result_parse) throws IOException{
		File fileTemp = new File("C:\\configurationFile\\result.txt");
		FileWriter fw = new FileWriter(fileTemp,false);
		fw.write(sumTotal+",");
		fw.write(result_total+",");
		fw.write(result_parse);
		fw.close();
	}
	
	//初始化百分比配置文件
	public void initPercent() throws IOException{
		FileReader fr=new FileReader("C:\\configurationFile\\percent.txt");
		BufferedReader br=new BufferedReader(fr);
		String line = br.readLine();
		if (line==null || line!="0"){
		    	File fileTemp = new File("C:\\configurationFile\\percent.txt");
				FileWriter fw = new FileWriter(fileTemp,false);
				fw.write("0");
				fw.close();	
		}
		br.close();
		fr.close();
	}
	
	public void initStaticVariable(){   //初始化全局信息
		if(storeDocInformation.size()!=0){
			storeDocInformation.clear();
		}		
		bookNum=1;
		wrong=0;//错误的json对象数
		sheetNum=0;
		totalResults=0;
		result_record=0;
		result_parse=0;
		sum_total=0;
		percent=0;
		excelFilePath=null;
		
//		if(ExcelExport.fieldCountList.size()!=0){
//			ExcelExport.fieldCountList.clear();
//		}
//		ExcelExport.callIndex=0;
//		ExcelExport.bookNumIndex=1;
//		ExcelExport.filePathPub ="";
//		ExcelExport.fileName ="";
//		ExcelExport.provinceName = "";
//		ExcelExport.docFileName ="";
	}
}
