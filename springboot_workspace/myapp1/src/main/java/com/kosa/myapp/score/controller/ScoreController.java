package com.kosa.myapp.score.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.score.domain.ScoreDto;
import com.kosa.myapp.score.service.ScoreService;

@RestController
public class ScoreController {

	@Resource(name = "ScoreService")
	ScoreService service;

	@PostMapping("/score/list")
	public HashMap<String, Object> getList(ScoreDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("data", service.getList(dto));
		map.put("result", "ok");

		return map;
	}

	@PostMapping("/score/write")
	public HashMap<String, Object> insert(@RequestBody ScoreDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
			service.insert(dto);
			map.put("result", "ok");
			
		return map;
	}

	@GetMapping("/score/view/{seq}")
	public HashMap<String, Object> getView(@PathVariable("seq") int seq, ScoreDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("data", service.getView(dto));
		map.put("result", "ok");

		return map;
	}

	@GetMapping("/score/delete/{seq}")
	public HashMap<String, Object> delte(@PathVariable("seq") int seq, ScoreDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		service.delete(dto);
		map.put("result", "ok");

		return map;
	}

	@PostMapping("/score/update")
	public HashMap<String, Object> update(@RequestBody ScoreDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		service.update(dto);
		map.put("result", "ok");

		return map;
	}

	@GetMapping("/score/update2/{seq}")
	public HashMap<String, Object> update2(@PathVariable("seq") String seq, @RequestBody ScoreDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		service.update(dto);
		map.put("result", "ok");
		
		return map;
	}
}
