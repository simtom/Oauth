package cn.hist.sunshine.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hist.sunshine.dao.TeacherDao;
import cn.hist.sunshine.domain.Teacher;
import cn.hist.sunshine.service.TeacherService;
@Service
@Transactional(readOnly= false)
public class TeacherServiceImp implements TeacherService{
	@Autowired
	private TeacherDao teacherDao;
	
	public void saveTeacher(Teacher teacher) {
		teacherDao.saveTeacher(teacher);
	}


}
