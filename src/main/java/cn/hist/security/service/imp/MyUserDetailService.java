package cn.hist.security.service.imp;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.hist.security.service.domain.MyUserDetail;



public class MyUserDetailService implements UserDetailsService{

	
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		MyUserDetail detail = new MyUserDetail(arg0,"123456");
		
		System.out.println(arg0);

		return detail;
	}

}
