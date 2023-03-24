package com.kosa.myapp;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// add?x=5&y=8 --> add/5/8
	@GetMapping("/add/{x}/{y}")
	public HashMap<String, String> add(@PathVariable("x") int x, @PathVariable("y") int y) {
		int result = x + y;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));

		return map;
	}

	@GetMapping("/calc/{x}/{y}/{z}")
	public HashMap<String, String> clac(@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("z") int z) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));

		if (z == 1)
			map.put("result", String.valueOf(x + y));
		if (z == 2)
			map.put("result", String.valueOf(x - y));
		if (z == 3)
			map.put("result", String.valueOf(x * y));
		if (z == 4)
			map.put("result", String.valueOf(x / y));

		return map;
	}
	
	@GetMapping("/score/{a}/{b}/{c}/{d}")
	public HashMap<String, Object> scroe(@PathVariable("a") String a, @PathVariable("b")int b, @PathVariable("c")int c,
			@PathVariable("d")int d){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", a);
		map.put("kor", b);
		map.put("eng", c);
		map.put("mat", d);
		map.put("total", b+c+d);
		
		return map;
	}
	
	//postman body -> x-form-urlencoded 폼태그로 전송
	@PostMapping("/add_form")
	public HashMap<String, String> add_form(int x, int y) {
		int result = x + y;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));

		return map;
	}
	
	@PostMapping("/add_form2") //요거 쪼금 이상함, 참고하지 마쇼
	public HashMap<String, String> add_form2(int x, int y, HttpServletRequest req) {
		int result = x + y;
		HashMap<String, String> map = new HashMap<String, String>();
		
		//String.valueof(기본타입) -> 문자열로 전환해준다
		//x(int) -> int 는 객체가 아님. toString() 함수 없음
		//java int -> 객체로 전환해야 할 때가 있는데 Integer, Float
		//Double wrapper class 들로 기본값을 감싸서 개체로 전환할 때는 to toString() 
		//s = new Integer(x); s.toString();
		// x+""; 앞에 String이 아닌 타입을 스트링으로 전환시켜 더한다. 
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));

		return map;
	}
	
	@PostMapping("/add_json")
	public HashMap<String, String> add_json(@RequestBody HashMap<String, String> paramMap) {
		//json으로 받을 때는 @requestBody로 받아야 한다.
		//기본타입변수로는 못받는다.
		//HashMap이나 또는 Dto로만 받을 수 있다.
		int result = Integer.parseInt(paramMap.get("x")) + Integer.parseInt(paramMap.get("y"));
		HashMap<String, String> map = new HashMap<String, String>();
		//form 태그에 enctype="multipart/form-data"로 전송하면
		//request 객체로 값을 못받고 MultipartResolver에 의해 값을 처리
		//해야 한다. 스프링부트가 사고 안나게 내부적인 처리가 된다.
		
		//map.put("req_x", req.getParameter("x")); //서블릿에서 작업함
		//map.put("req_y", req.getParameter("y"));
		
		map.put("x", paramMap.get("x"));
		map.put("y", paramMap.get("y"));
		map.put("result", String.valueOf(result));

		return map;
	}
	
	@PostMapping("/score_json")
	public HashMap<String, String> score_json(@RequestBody HashMap<String, String> paramMap){
		int total = Integer.parseInt(paramMap.get("kor")) +Integer.parseInt(paramMap.get("eng"))+Integer.parseInt(paramMap.get("mat"));
		HashMap<String, String> map = new HashMap<String, String>();
		int avg = total/3;
		
		map.put("name", paramMap.get("name"));
		map.put("kor", paramMap.get("kor"));
		map.put("eng", paramMap.get("eng"));
		map.put("mat", paramMap.get("mat"));
		map.put("total", String.valueOf(total));
		map.put("avg", String.valueOf(avg));
		
		return map;
	}
	
	@PostMapping("/score_json2")
	public HashMap<String, Object> score_json2(@RequestBody ScoreDto dto){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int total = dto.getKor()+dto.getEng()+dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		map.put("name", dto.getName());
		map.put("kor", dto.getKor());
		map.put("eng", dto.getEng());
		map.put("mat", dto.getMat());
		map.put("total", dto.getTotal());
		map.put("avg", dto.getAvg());
		
		return map;
	}
	
	@PostMapping("/score_json3")
	public ScoreDto score_json3(@RequestBody ScoreDto dto){
		int total = dto.getKor()+dto.getEng()+dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		return dto;
	}
}
