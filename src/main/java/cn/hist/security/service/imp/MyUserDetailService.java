package cn.hist.security.service.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hist.security.service.domain.MyUserDetail;


@Service
@Transactional
public class MyUserDetailService extends HibernateTemplate implements UserDetailsService{
	

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	
		System.out.println(username);
	
		UserDetails userDetails = this.get(UserDetails.class,1);
		
		System.out.println(userDetails);
		
		
		System.out.println("**************");
		
		
		 return new MyUserDetail("123456", "123456");
	 
		

	}
	
	
	   @Autowired
		private void setProSessionFactory(SessionFactory sessionFactory) {
			
			super.setSessionFactory(sessionFactory);
		}

}
