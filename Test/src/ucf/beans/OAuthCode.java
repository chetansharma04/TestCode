package ucf.beans ;


//changed AccessToken to oAuthCode
public class OAuthCode {
	
private String access_token;
private int expires_in;
private String token_type;
private String scope;
private String refresh_token;
private String error;
private String error_description;
private String error_uri;

public String getAccess_token() {
	return access_token;
}
public void setAccess_token(String accessToken) {
	access_token = accessToken;
}
public int getExpires_in() {
	return expires_in;
}
public void setExpires_in(int expiresIn) {
	expires_in = expiresIn;
}
public String getToken_type() {
	return token_type;
}
public void setToken_type(String tokenType) {
	token_type = tokenType;
}
public String getScope() {
	return scope;
}
public void setScope(String scope) {
	this.scope = scope;
}
public String getRefresh_token() {
	return refresh_token;
}
public void setRefresh_token(String refreshToken) {
	refresh_token = refreshToken;
}


public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public String getError_description() {
	return error_description;
}
public void setError_description(String error_description) {
	this.error_description = error_description;
}
public String getError_uri() {
	return error_uri;
}
public void setError_uri(String error_uri) {
	this.error_uri = error_uri;
}

@Override
public String toString() {
	return "AccessToken [access_token=" + access_token + ", expires_in=" + expires_in + ", refresh_token=" + refresh_token
			+ ", scope=" + scope + ", token_type=" + token_type + ", error=" + error + ", error_description=" + error_description + ", error_uri=" + error_uri + "]";
}




}
