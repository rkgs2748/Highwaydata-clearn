package moduleSet;

/*import java.io.UnsupportedEncodingException;
import java.util.List;
import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Util;

public class ResolveOBUjson {
	  @SuppressWarnings({ "static-access", "deprecation", "unchecked" })
	    public static void main(String[] args) throws UnsupportedEncodingException {
	        String JsonContext = new Util().ReadFile("C:\\Users\\Administrator\\Desktop\\apkinfo.json");
	        System.out.println("JsonContext:" + JsonContext);
	        //String s= java.net.URLDecoder.decode(JsonContext, "UTF-8");
	   
	        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
	        //String s= java.net.URLDecoder.decode(JsonContext, "utf-8");
	        //JSONObject jsonArray = new JSONObject();
	        CheckOBUblack_14 cob= new CheckOBUblack_14();
	  
	        int size = jsonArray.size();
	        System.out.println("Size: " + size);
	        int type1,type2,type3,type4,type5;
	        for(int  i = 0; i < size; i++){
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            type1=cob.checkOBUblack("issuerId", jsonObject.get("issuerId"));
	            type2=cob.checkOBUblack("creationTime", jsonObject.get("creationTime"));
	            type3=cob.checkOBUblack("OBUId", jsonObject.get("OBUId"));
	            type4=cob.checkOBUblack("type", jsonObject.get("type"));
	            type5=cob.checkOBUblack("status", jsonObject.get("status"));
	            System.out.println("type1:" + type1);
	            System.out.println("type2:" + type2);
	            System.out.println("type3:" + type3);
	            System.out.println("type4:" + type4);
	            System.out.println("type5:" + type5);
	            //System.out.println("[" + i + "]name=" + jsonObject.get("name"));
	            //System.out.println("[" + i + "]package_name=" + jsonObject.get("package_name"));
	            //System.out.println("[" + i + "]check_version=" + jsonObject.get("check_version"));
	              
	        }
	        /*List<MorphDynaBean> listObject = jsonArray.toList(jsonArray);
	        for(int i = 0, j = listObject.size(); i < j ; i++){
	            System.out.println(listObject.get(i));
	        }
	        for(MorphDynaBean temp: listObject){
	            System.out.println(temp.get("name"));
	        }  */
	    /*}
}*/
