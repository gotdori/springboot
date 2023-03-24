package com.kosa.myapp.gusetbook.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.gusetbook.domain.GuestbookDto;
import com.kosa.myapp.gusetbook.service.GuestbookService;

@RestController
public class GuestbookController {
	
	@Resource(name="guestbookService")
	GuestbookService service;

	
	@GetMapping("/guestbook/list/{pg}")
	public HashMap<String, Object> getList(@PathVariable("pg")int pg, GuestbookDto dto){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", service.getTotalCnt(dto));
		map.put("data", service.getList(dto));
		
		return map;
	}
	
	//Post 방식 전송은 브라우저로 안됨
	//json 형태로 데이터  수신 하고 싶다면 매개변수 앞에 @RequestBody 쓰고
	//HashMap이나 Dto 객체로 받아야 함
	@PostMapping("/guestbook/insert")
	public HashMap<String, String> insert(@RequestBody GuestbookDto dto) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
		service.insert(dto);
		map.put("result", "success");
		}
		catch (Exception e) {
			e.printStackTrace(); //실제 운영시에는 없애야 한다.
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@GetMapping("/guestbook/update/{seq}/{title}/{contents}")
	public HashMap<String, Object> update(@PathVariable("seq")String seq, @PathVariable("title")String title,
											@PathVariable("contents")String contents){
		GuestbookDto dto = new GuestbookDto();
		HashMap<String, Object> map = new HashMap<String, Object>();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContents(contents);
		
		map.put("result", "ok");
		return map;
	}
	
	@PostMapping("/guestbook/update2")
	public HashMap<String, Object> update2(@RequestBody GuestbookDto dto){
		HashMap<String, Object> map = new HashMap<String, Object>();
		service.update(dto);
		
		map.put("result", "ok");
		return map;
	}
	
	
	@GetMapping("/guestbook/delete/{seq}")
	public HashMap<String, String> delete(@PathVariable("seq")String seq, GuestbookDto dto){
		HashMap<String, String> map = new HashMap<String, String>();
		dto.setSeq(seq);
		service.delete(dto);
		map.put("result", "ok");
		
		return map;
	}
	
	@PostMapping("/guestbook/delete")
	public HashMap<String, String> delete2(@RequestBody GuestbookDto dto){
		HashMap<String, String> map = new HashMap<String, String>();
		service.delete(dto);
		map.put("result", "ok");
		
		return map;
	}
	
	// /view/2   /view?seq=2  둘 다 옛날 GET 방식, 간단하고 보안이 필요함
	@GetMapping("/guestbook/view/{seq}")
	public HashMap<String, Object> getView(@PathVariable("seq")String seq, GuestbookDto dto){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", "ok");
		map.put("data",service.getView(dto) );

		return map;
	}
	
//	@PostMapping("/guestbook/view2")
//	public HashMap<String, Object> getView(@RequestBody GuestbookDto dto){
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		GuestbookDto dto2 = service.getView(dto.getSeq());   
//		System.out.println(dto2);
//		map.put("result", "ok");
//		map.put("data", dto2);
//		
//		
//		return map;
//	}
	
}