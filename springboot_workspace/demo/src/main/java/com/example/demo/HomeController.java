package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

//@Controller 기존 스프링프레임워크랑 동일
//스프링부트는 기본이 json 형태로 데이터를 받고 결과값도 json 형태로 내보낸다.
@RestController
public class HomeController {
	
	@RequestMapping(value="/")
	public String home() {
		return "Hello";
	}
	
	//@ResponseBody 안붙여도 된다.
	@RequestMapping(value="/data")
	public HashMap<String, String> data() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("age", "23");
		map.put("phone", "010-0000-0001");
		map.put("email", "hong@daum.net");
		
		return map;
	}
	
	//스프링부트는 수정하면 반드시 서버를 껐다가 재시작 해야함
	//뭔가 깔면 전 처럼 쓸 수 있음
	//스프링부트는 제약이 많아서 은행같은 곳에서는 못쓰고 소규모에서 유리함
	
	//@ResponseBody 안붙여도 된다.
	@RequestMapping(value="/dataList")
	public List<HashMap<String, String>> data_list() {
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("age", "23");
		map.put("phone", "010-0000-0001");
		map.put("email", "hong@daum.net");
		dataList.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "임꺽정");
		map.put("age", "33");
		map.put("phone", "010-1111-0003");
		map.put("email", "leem@daum.net");
		dataList.add(map);
		
		return dataList;
	}
	
	// http://localhost:9000/info?userid=test&password=1234
	@GetMapping("info") //GET 방식 맵핑
	public HashMap<String, String>info(String userid, String password){
		 HashMap<String, String> map = new  HashMap<String, String>();
		 map.put("userid", userid);
		 map.put("password", password);
		 
		 return map;
	}
}


