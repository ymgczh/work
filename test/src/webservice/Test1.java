package webservice;

import javax.xml.ws.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test1 {
	public static void main(String[] args) {
		String str = \"http://211.82.159.104:8081/IntegrationRouteService/ws/card-service/search/user?studentCode=2014050801\";
//		Service ser = new Service();
//		String result = \"{\\"data\\":{\\"uno\\":\\"000000007506\\",\\"uname\\":\\"���������\\",\\"sexname\\":\\"Ů\\",\"
//				+ \"\\"idsno\\":\\"2014050801\\",\"
//				+ \"\\"bankAcc\\":\\"6216638401000064416 \\"} }\";
//		JSONArray json = JSONArray.fromObject(result);
//		System.out.println(json.getString(0));
		JSONObject ob = JSONObject.fromObject(result);
		JSONObject ba = JSONObject.fromObject(ob.get(\"data\"));
		System.out.println(ba.get(\"uname\"));
//		Gson gson = new Gson();
//		StudentInOneCard stu = gson.fromJson(result, StudentInOneCard.class);
		
//		{\"state\":0,\"data\":{\"uno\":\"000000007506\",\"uname\":\"���������\",\"sexname\":\"Ů\",\"idsno\":\"2014050801\",\"idclass\":\"1\",\"pidname\":\"������\",\"idbirthday\":null,\"idtypecode\":null,\"idnumber\":\"150426199307044876\",\"area\":\"���ɹ�ҽ�ƴ�ѧ\",\"iddept\":\"��ҽҩѧԺ-����ѧ(�ɻ�����)-2014��\",\"idindate\":null,\"nationname\":null,\"peoplename\":null,\"zzmmname\":null,\"idtel\":null,\"uzip\":null,\"uaddress\":null,\"uemail\":null,\"ujg\":null,\"checkflag\":\"1\",\"openflag\":\"1\",\"writeflag\":null,\"account\":7327,\"cardid\":\"2555157647\",\"openaccdate\":\"20150828135603\",\"lastupdate\":\"20150828111745\",\"expdate\":null,\"right\":null,\"bankAcc\":\"6216638401000064416 \",\"balance\":\"0\",\"flag\":\"000001000100000\",\"preTmpBalance\":\"0\",\"tmpBalance\":\"9500\"},\"totalCount\":null,\"message\":\"success\",\"success\":true}
	}
}
