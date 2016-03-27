package cn.hist.sunshine.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.hist.sunshine.dao.TeacherDao;
import cn.hist.sunshine.domain.Teacher;

@Component

public class TeacherDaoImp extends HibernateTemplate implements TeacherDao {

	public void saveTeacher(Teacher teacher) {
		
		this.save(teacher);
	}

	@Autowired
	public void setSuperSession(SessionFactory sessionFactory) {

		super.setSessionFactory(sessionFactory);
	}

}
