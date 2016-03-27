package cn.hist.security.service.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class MyClientDetailsService extends HibernateTemplate implements ClientDetailsService {

	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		
		
		Criteria criteria = this.getSessionFactory().openSession()
				.createCriteria(ClientDetails.class);
		@SuppressWarnings("unchecked")
		List<ClientDetails> list = criteria.add(Restrictions.eq("clientId", clientId)).list();
		if (list!=null&&list.size()!=0) {
			return (ClientDetails) list.get(0);
		}else {
			return null;
		}

	}
    @Autowired
	private void setProSessionFactory(SessionFactory sessionFactory) {
		
		super.setSessionFactory(sessionFactory);
	}

}
