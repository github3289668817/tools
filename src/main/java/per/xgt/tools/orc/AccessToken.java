package per.xgt.tools.orc;

import java.io.Serializable;

/**
 * @Author: Valen
 * @createTime: 2023-05-06日 16:59:15
 * @version: 1.0
 * @Description:
 */
public class AccessToken implements Serializable {

    // API_KEY
    public String client_id;
    // SECRET_KEY
    public String client_secret;
    // AccessToken
    public String access_token;
    // refresh_token
    public String refresh_token;
    // expires_in Access Token的有效期(秒为单位，有效期30天)
    public String expires_in;
    // session_key
    public String session_key;
    // scope
    public String scope;
    // session_secret
    public String session_secret;
    /**
     * 错误码
     * unknown client id API Key不正确
     * Client authentication failed Secret Key不正确
     */
    public String invalid_client;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSession_secret() {
        return session_secret;
    }

    public void setSession_secret(String session_secret) {
        this.session_secret = session_secret;
    }

    public String getInvalid_client() {
        return invalid_client;
    }

    public void setInvalid_client(String invalid_client) {
        this.invalid_client = invalid_client;
    }


}
