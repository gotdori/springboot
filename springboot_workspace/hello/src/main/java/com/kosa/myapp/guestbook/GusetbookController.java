package com.kosa.myapp.guestbook;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GusetbookController {

	@GetMapping("/guestbook")
	GuestbookDto getView() {
		GuestbookDto dto = new GuestbookDto();
		dto.setId("나는");
		dto.setTitle("똥");
		dto.setWriter("멍청이");
		dto.setContents("입니다.");
		dto.setWdate("찡긋 >.ㅇ");

		return dto;
	}

	@GetMapping("/add")
	public HashMap<String, Integer> question1(int x, int y) {
		HashMap<String, Integer> q = new HashMap<String, Integer>();
		q.put("x", x);
		q.put("y", y);
		q.put("result", x + y);

		return q;
	}

	@GetMapping("/calc")
	public HashMap<String, Object> question2(int x, int y, int oper) {

		
		HashMap<String, Object> h = new HashMap<String, Object>();
		h.put("x", x);
		h.put("y", y);
		
		if(oper==1) {
			h.put("result", x + y);
		}
		if(oper==2) {
			h.put("result", x - y);
		}
		if(oper==3) {
			h.put("result", x * y);
		}
		if(oper==4) {
			h.put("result", x / y);
		}
		
		return h;
	}

	@RequestMapping(value = "/score")
	public HashMap<String, Object> data(String name, int kor, int eng, int mat) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("kor", kor);
		map.put("eng", eng);
		map.put("mat", mat);
		map.put("total", kor + eng + mat);

		return map;
	}
}
