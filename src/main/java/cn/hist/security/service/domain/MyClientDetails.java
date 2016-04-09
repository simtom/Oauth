package cn.hist.security.service.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Component;

@Component
@Entity(name="client")
public class MyClientDetails implements ClientDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@
	@Id
	@GeneratedValue
	private String id;
	private String clientId;
	private String clientSecret;
    ////
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		// TODO Auto-generated method stub
		return clientId;
	}

	public Set<String> getResourceIds() {
		Set<String> set = new HashSet<String>();
		set.add("mobile-resource");
		return set;
	}

	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getClientSecret() {
		// TODO Auto-generated method stub
		return clientSecret;
	}

	public boolean isScoped() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getAuthorizedGrantTypes() {
		Set<String> set = new HashSet<String>();
		set.add("password");
		set.add("token");
		set.add("implicit");
		return set;
	}

	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		GrantedAuthority authority = new GrantedAuthority() {
			
			public String getAuthority() {
				// TODO Auto-generated method stub
				return "ROLE_ABCS";
			}
		};
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);
		return authorities;

	}

	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return 3600;
	}

	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return 3600;
	}

	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return true;
	}

	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}
    
	
	
	
	
	
}
