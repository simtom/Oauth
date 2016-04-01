package cn.hist.sunshine.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hist.sunshine.domain.Teacher;
import cn.hist.sunshine.service.imp.TeacherServiceImp;

@Controller
@RequestMapping(value="teacher")
public class TestController {
	@Autowired
	private TeacherServiceImp teacherService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)

	public @ResponseBody Map<String, Object> test(){
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
