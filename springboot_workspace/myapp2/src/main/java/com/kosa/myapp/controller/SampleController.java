package com.kosa.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.domain.SampleDto;
import com.kosa.myapp.service.SampleService;

@RestController
public class SampleController {

	@Autowired
	SampleService service;
	
	@GetMapping("/sample/list")
	List<SampleDto> getList(SampleDto dto){
		return service.getList(dto);
	}
	
	// sample/insert?test=
	@GetMapping("/sample/insert")
	HashMap<String, Object> insert(SampleDto dto){
		HashMap<String, Object> map = new HashMap<>();
		try {
			service.insert(dto);
			map.put("result", "success");
		} catch (Exception e) {
			map.put("result", "fail");
		}
		return map;
	}
	
	// sample/update?seq=1&test=
	//seq를 안써주면 insert가 됨
	@GetMapping("/sample/update")
	HashMap<String, Object> update(SampleDto dto){
		HashMap<String, Object> map = new HashMap<>();
		try {
			service.delete(dto);
			map.put("result", "success");
		} catch (Exception e) {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("/sample/delete")
	HashMap<String, Object> delete(SampleDto dto){
		HashMap<String, Object> map = new HashMap<>();
		try {
			service.delete(dto);
			map.put("result", "success");
		} catch (Exception e) {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("/sample/find")
	List<SampleDto> findByTest(SampleDto dto){
		return service.findTest(dto);
	}
	
	@GetMapping("/sample/search")
	List<SampleDto> findByTest2(SampleDto dto){
		return service.findTest2(dto);
	}
}
