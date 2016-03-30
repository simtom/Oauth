package cn.hist.sunshine.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hist.sunshine.domain.Teacher;
import cn.hist.sunshine.service.imp.TeacherServiceImp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "WEB-INF/security/*.xml,WEB-INF/spring/*.xml,WEB-INF/spring-mvc/*.xml")
@Controller
@RequestMapping(value="oauth")
public class TestController {
	@Autowired
	private TeacherServiceImp teacherService;
	@Test
	@RequestMapping(value="/hello",method=RequestMethod.PUT)
	public @ResponseBody Map<String, Object> test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", "hello world!");
		Teacher teacher = new Teacher();
		teacher.setName("wang");
		teacher.setSex("f");
		teacher.setTel("010");
	    teacherService.saveTeacher(teacher);
		return map;
	}

}
