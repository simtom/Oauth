package cn.hist.security.service.domain;


import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails{

	
	/**
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
		
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public MyUserDetail(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ABCS"); 
		return Collections.singletonList(simpleGrantedAuthority);
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	
	

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
