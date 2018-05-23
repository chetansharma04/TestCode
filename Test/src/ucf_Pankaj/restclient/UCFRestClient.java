package ucf_Pankaj.restclient;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import ucf_Pankaj.beans.AccessToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UCFRestClient {
	
	
	public static void main(String arg[])
	{
		//String getAuthCode=getOAuthCode();
		//String getRefreshCode=getRefreshCode("c78f6312bd55b2e3a7981049c105c078d16764fb", "a3150c1eaed19ba6adac252e294c539213834e29");
		
		//String input = "{\"grant_type\":\"refresh_token\",\"refresh_token\":\"a3150c1eaed19ba6adac252e294c539213834e29\",\"client_id\":\"107cce70-194d-4dfc-a5a0-7219ecf90e7c\",\"client_secret\":\"b2ZzMp5Y4pMv4Tko+bBF7STpbebbpE6u\",\"redirect_uri\":\"http://220.227.11.67:8888/TruOps/lmur/login.do\"}";

		//AccessToken accessObject=convertJsonToObject(getRefreshCode, AccessToken.class);
		
		//System.out.println(accessObject);
		
		String response=getEntityList();
		System.out.println(response);
	}
	
	
	
	public static String getRefreshCode(String token,String refreshToken)
	{
		
		Client client=Client.create();
		WebResource webRessource=client.resource("https://auth.unifiedcompliance.com/token");
		String  _oAuth_token="Bearer "+token;
		String input = "{\"grant_type\":\"refresh_token\",\"refresh_token\":\"a3150c1eaed19ba6adac252e294c539213834e29\",\"client_id\":\"107cce70-194d-4dfc-a5a0-7219ecf90e7c\",\"client_secret\":\"b2ZzMp5Y4pMv4Tko+bBF7STpbebbpE6u\",\"redirect_uri\":\"http://220.227.11.67:8888/TruOps/lmur/login.do\"}";
		ClientResponse response=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
		.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json").header("Authorization", _oAuth_token)
		.post(ClientResponse.class, input);

		System.out.println(response.getStatus());
		String jsonString=response.getEntity(String.class);
		System.out.println(jsonString);
		
		return jsonString;
	}
	
	public static String getOAuthCode()
	{
		String oAuthCode=null;
		try{
			Client client=Client.create();
			
			WebResource webRessource=client.resource("https://auth.unifiedcompliance.com/token");
			
			String input = "{\"grant_type\":\"authorization_code\",\"code\":\"bb4e0bcd8fffdfc21fef2d6a6fab53b71ad41b90\",\"client_id\":\"107cce70-194d-4dfc-a5a0-7219ecf90e7c\",\"client_secret\":\"b2ZzMp5Y4pMv4Tko+bBF7STpbebbpE6u\",\"redirect_uri\":\"http://220.227.11.67:8888/TruOps/lmur/login.do\"}";
			
			ClientResponse response=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
			.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json")
			.post(ClientResponse.class, input);
			
			System.out.println(response.getStatus());
			if(response.getStatus()==200)
			{
				oAuthCode=response.getEntity(String.class);
			}
			System.out.println(oAuthCode);
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return oAuthCode;
	}

	/**
	 * @description used to conver json response String to Object.
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
		String responseData=null;
		try{
			Client client=Client.create();
			String  _oAuth_token="Bearer 972eb7b1afede9776ab102f324c62c8f9994df1e";
			WebResource webRessource=client.resource("https://api.unifiedcompliance.com/entities");
			ClientResponse response=webRessource.type(MediaType.APPLICATION_JSON_TYPE)
			.header("Content-Type", "application/json").header("Accept", "application/vnd.ucf.v1+json").header("Authorization", _oAuth_token)
			.get(ClientResponse.class);
			
			System.out.println(response.getStatus());
			responseData=response.getEntity(String.class);
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return responseData;
			
	}
}
