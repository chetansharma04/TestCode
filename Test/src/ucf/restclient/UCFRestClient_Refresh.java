package ucf.restclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import ucf.beans.OAuthCode;

import com.ibm.icu.util.Calendar;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UCFRestClient_Refresh {
	
	private static Client client = null;
	private static WebResource webRessource= null;
	private static String client_id = null;
	private static String client_secret = null;
	private static String redirect_uri = null;
	private static OAuthCode oAuthCode = null;
	private static OAuthCode refreshCode = null;
	
	
	private static void setUCFMasterSettings(){
		client=Client.create();
		webRessource=client.resource("https://auth.unifiedcompliance.com/token");
		client_id = "8a2d9c18-bca7-4024-8e23-109ca743b349";
		client_secret = "+P+bYsNAMZfOnifPVuJsv9b6y1KggQ5e";
		redirect_uri="http://220.227.11.67:8888/TruOps/lmur/login.do";
	}
	public static void main(String arg[])
	{
		setUCFMasterSettings();
		oAuthCode = getOAuthCode();
		
		checkTokenExpiry();
	
	}
	
	//Retrieve OAuthCode and initial refresh code based on URL Code
	public static OAuthCode getOAuthCode()
	{
		System.out.println("In getOAuthCode()");
		String oAuthCodeStr=null;
		OAuthCode oAuthCode=null;
		try{
			String urlCode = "df505dbf603f0e538a283a958b5ff707e72fbc1f";
			
			String input = "{\"grant_type\":\"authorization_code\",\"code\":\"" +urlCode+ "\",\"client_id\":\"" +client_id+ "\",\"client_secret\":\"" +client_secret+ "\",\"redirect_uri\":\"" +redirect_uri+ "\"}";
			
			ClientResponse response=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
			.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json")
			.post(ClientResponse.class, input);
			
			System.out.println("getOAuthCode response status: "+response.getStatus());
			if(response.getStatus()==200)
			{
				oAuthCodeStr=response.getEntity(String.class);
				oAuthCode=convertJsonToObject(oAuthCodeStr, OAuthCode.class);
				System.out.println("oAuthCode.toString()=="+oAuthCode.toString());
					
			}else{
				System.out.println("oAuthCode not received");
			}
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return oAuthCode;
	}
	
	
	//Retrieve Refresh based on URL Code
	public static OAuthCode getRefreshCode()
	{
		System.out.println("In getRefreshCode()");
		String input = "{\"grant_type\":\"refresh_token\",\"refresh_token\":\"" +refreshCode.getRefresh_token()+ "\",\"client_id\":\"" +client_id+ "\",\"client_secret\":\"" +client_secret+ "\",\"redirect_uri\":\"" +redirect_uri+ "\"}";
		ClientResponse response=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
		.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json").header("Authorization", "Bearer "+refreshCode.getAccess_token())
		.post(ClientResponse.class, input);
		
		System.out.println("getRefreshCode status = "+response.getStatus());
		String refreshCodeString=response.getEntity(String.class);
		
		OAuthCode refreshCode = convertJsonToObject(refreshCodeString, OAuthCode.class);
		System.out.println("refreshCode.toString()=="+refreshCode.toString());
		
		
		return refreshCode;
	}
	
	Calendar lastRefreshCodeTime ;
	static void checkTokenExpiry(){
		for(int minutesCtr=1;minutesCtr<=60;minutesCtr++){
			
			try {
				System.out.println(minutesCtr+". checkTokenExpiry = "+Calendar.getInstance().getTime());
				getEntityList();
				Thread.sleep(1000*60);
				if(minutesCtr == 50){
					getRefreshCode();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	/**
	 * @description used to convert json response String to Object.
	 * @param <T>
	 * @param responseString
	 * @param T
	 * @return
	 */
	public static <T> T convertJsonToObject(String responseString,Class<T> T)
	{
		ObjectMapper mapper=new ObjectMapper();
		T t=null;
		try {
			 t=mapper.readValue(responseString, T);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return t;
	}
	
	
	public static String getEntityList()
	{
		String entityListResponseData=null;
		try{
//			webRessource=client.resource("https://api.unifiedcompliance.com/cch-ad-lists-to-authority-documents/paged");
			webRessource=client.resource("https://api.unifiedcompliance.com/entities");
			ClientResponse entityListResponse=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
			.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json").header("Authorization", "Bearer "+refreshCode.getAccess_token())
			.get(ClientResponse.class);
			
			System.out.println(entityListResponse.getStatus());
			entityListResponseData=entityListResponse.getEntity(String.class);
			System.out.println("entityListResponseData == "+entityListResponseData);
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return entityListResponseData;
			
	}

}
