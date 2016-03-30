package cn.hist.security.service.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;

import cn.hist.security.service.domain.MyUserDetail;
import cn.hist.sunshine.service.TeacherService;



public class MyUserDetailService extends HibernateTemplate implements UserDetailsService{
	

	
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Criteria criteria = this.getSessionFactory().openSession()
				.createCriteria(ClientDetails.class);
		@SuppressWarnings("unchecked")
		List<MyUserDetail> list = criteria.add(Restrictions.eq("username", arg0)).list();
		if (list!=null&&list.size()!=0) {
			return (MyUserDetail) list.get(0);
		}else {
			return null;
		}
	}
	
	
	   @Autowired
		private void setProSessionFactory(SessionFactory sessionFactory) {
			
			super.setSessionFactory(sessionFactory);
		}

}
