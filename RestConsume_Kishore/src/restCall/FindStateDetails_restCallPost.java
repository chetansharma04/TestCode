package restCall;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class FindStateDetails_restCallPost {

	public static String main(String[] args) { 
		
		return callWS(args);
		

	}
	
	public static Stri ng callWS(String[] value){
		String result = "Not Found" ;
		try {
			URL url = new URL("http://services.groupkt.com/state/get/USA/all");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			Client client=Client.create();
			WebResource webRessource=client.resource("http://services.groupkt.com/state/get/USA/all");
			ClientResponse entityListResponse=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
					.header("Content-Type", "application/json")
					.header("Accept", "application/vnd.ucf.v1+json").get(ClientResponse.class);

			String entityListResponseData=entityListResponse.getEntity(String.class);
			JSONObject object = new JSONObject(entityListResponseData);

			
			Iterator<String> keys= object.keys();
			while (keys.hasNext()) 
			{
				String keyValue = (String)keys.next();
				JSONObject jsonObjectRestResponse = object.getJSONObject(keyValue);
					JSONArray resultObjArr = jsonObjectRestResponse.getJSONArray("result");
					for(int i=0; i<resultObjArr.length(); i++){
						JSONObject jsonObject = (JSONObject) resultObjArr.get(i);
						if(jsonObject.get("name").toString().equalsIgnoreCase(value[0]) || jsonObject.get("abbr").toString().equalsIgnoreCase(value[0])){
							result = "Largest City = "+jsonObject.get("largest_city") + 
									" - Capital = "+jsonObject.get("capital");
							System.out.println("result = "+result);
							
						}
				}
			}
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();
		  } 
	 catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

}
