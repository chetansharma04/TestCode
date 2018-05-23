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

public class UCFRestClient {
	
	private static Client client = null;
	private static WebResource webRessource= null;
	private static String client_id = null;
	private static String client_secret = null;
	private static String redirect_uri = null;
	private static OAuthCode oAuthCode = null;
	
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
		
		OAuthCode refreshCode = getRefreshCode(oAuthCode.getAccess_token(), oAuthCode.getRefresh_token());
		
//		String responseEntity=getEntityList(refreshCode);
//		System.out.println("responseEntity = "+responseEntity);
		
//		checkTokenExpiry(refreshCode);
//		checkTokenExpiry(oAuthCode);
		getAuthorityDocIdList(oAuthCode.getAccess_token());
	
	}
	
	//Retrieve OAuthCode and initial refresh code based on URL Code
	public static OAuthCode getOAuthCode()
	{
		System.out.println("In getOAuthCode()");
		String oAuthCodeStr=null;
		OAuthCode oAuthCode=null;
		try{
			String urlCode = "685010dcd41a0ccb0d5beb4686cfaec3d46c9303";
			
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
	public static OAuthCode getRefreshCode(String token,String refreshToken)
	{
		System.out.println("In getRefreshCode()");
		String  _oAuth_token="Bearer "+token;
		String input = "{\"grant_type\":\"refresh_token\",\"refresh_token\":\"" +refreshToken+ "\",\"client_id\":\"" +client_id+ "\",\"client_secret\":\"" +client_secret+ "\",\"redirect_uri\":\"" +redirect_uri+ "\"}";
		ClientResponse response=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
		.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json").header("Authorization", _oAuth_token)
		.post(ClientResponse.class, input);
		
		System.out.println("getRefreshCode status = "+response.getStatus());
		String refreshCodeString=response.getEntity(String.class);
		
		OAuthCode refreshCode = convertJsonToObject(refreshCodeString, OAuthCode.class);
		System.out.println("refreshCode.toString()=="+refreshCode.toString());
		
		
		return refreshCode;
	}
	
	static void checkTokenExpiry(OAuthCode refreshCode){
		for(int minutesCtr=1;minutesCtr<=60;minutesCtr++){
			
			try {
				System.out.println(minutesCtr+". checkTokenExpiry = "+Calendar.getInstance().getTime());
//				getEntityList(refreshCode);
				getAuthorityDocIdList(refreshCode.getAccess_token()); 
//				getEntityList(refreshCode);
				if(minutesCtr == 50){
					refreshCode = getRefreshCode(oAuthCode.getAccess_token(), oAuthCode.getRefresh_token());
					
					
				}
				Thread.sleep(1000*10*60);//10 minutes
				
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
	
	
	public static String getEntityList(OAuthCode refreshCode)
	{
		String entityListResponseData=null;
		try{
//			Client client=Client.create();
//			String  _oAuth_token="Bearer 262f0cee5280abb7c0eba2233dbb948ec057f23b";
			webRessource=client.resource("https://api.unifiedcompliance.com/entities");
			ClientResponse entityListResponse=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
			.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json").header("Authorization", "Bearer "+refreshCode.getAccess_token())
			.get(ClientResponse.class);
			
			System.out.println("getEntityList - entityListResponse.getStatus() = "+entityListResponse.getStatus());
			entityListResponseData=entityListResponse.getEntity(String.class);
			System.out.println("getEntityList - entityListResponseData == "+entityListResponseData);
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return entityListResponseData;
			
	}


	public static String getCCHAdListToAuthDocs(OAuthCode refreshCode)
	{
		String entityListResponseData=null;
		try{
//			Client client=Client.create();
//			String  _oAuth_token="Bearer 262f0cee5280abb7c0eba2233dbb948ec057f23b";
			webRessource=client.resource("https://sandbox.unifiedcompliance.com/cch-ad-lists-to-authority-documents/paged");
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

//abhinav
	public static void getAuthorityDocIdList(String accessCode) {
//        client=Client.create();
        String entityListResponseData=null;
        //webRessource=client.resource("https://api.unifiedcompliance.com/cch-ad-lists-to-authority-documents/paged");
        
        webRessource=client.resource("https://sandbox.unifiedcompliance.com/cch-ad-lists-to-authority-documents/paged");
        List authorityDocIdList = new ArrayList<Integer>();
        try{
               
               String  _oAuth_token="Bearer "+accessCode;
               ClientResponse entityListResponse=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
                            .header("Content-Type", "application/json")
                            .header("Accept", "application/vnd.ucf.v1+json")
                            .header("Authorization", _oAuth_token).get(ClientResponse.class);
               
//               System.out.println("######client::"+client+"  ### auth_token::"+_oAuth_token);
               
               System.out.println("getAuthorityDocIdList - entityListResponse.getStatus() = "+entityListResponse.getStatus());
               System.out.println("getAuthorityDocIdList - entityListResponse = "+entityListResponse);
               if(entityListResponse.getStatus()!=200){
//                     return null;
               }
               
               entityListResponseData=entityListResponse.getEntity(String.class);
               System.out.println("entityListResponseData = "+entityListResponseData);
               JSONObject object = new JSONObject(entityListResponseData);
        }catch(Exception exception){
        	exception.printStackTrace();
        }
	}
	
	//abhinav
	
	

}
