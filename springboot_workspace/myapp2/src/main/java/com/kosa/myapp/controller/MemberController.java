package com.kosa.myapp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.myapp.domain.MemberDto;
import com.kosa.myapp.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	//등록 페이지로 이동하기
	@GetMapping("/member/write")
	String member_write() {
		return "/member/write";
	}
	
	@PostMapping("/member/save")
	String member_save(MemberDto dto) {
		service.insert(dto);
		return "redirect:/member/write";
	}
	
	@ResponseBody
	@PostMapping("/member/idcheck")
	HashMap<String, Object> idCheck(MemberDto dto) {
		HashMap<String, Object> map = new HashMap<>();
		if(service.idCheck(dto)) {
			map.put("result", "Y");}
		else
			map.put("result", "N");
		return map;
	}
	
	
}
