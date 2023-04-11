package com.sns.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.post.dao.PostMapper;

@Controller
public class TestController {

	@Autowired
	PostMapper postMapper;
	
	@ResponseBody
	@RequestMapping("/test1")
	public String test1() {
		return "Hello world!";
	}
	
	@ResponseBody
	@RequestMapping("/test2")
	public Map<String, Object> test2(){
		Map<String, Object> map = new HashMap<>();
		map.put("aaa", 111);
		map.put("bbb", 111);
		map.put("ccc", 22);
		map.put("ddd", 33);
		return map;
	}
	
	@RequestMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	@ResponseBody
	@RequestMapping("/test4")
	public List<Map<String, Object>> test4() {
		return postMapper.selectPostList();
	}
}
