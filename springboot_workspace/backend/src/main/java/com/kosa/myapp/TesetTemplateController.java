package com.kosa.myapp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Springboot에서 jsp 사용하지말고 mustache 쓰라고 함
//템플릿, 템플릿엔진
//html 파일을 src/main/resources/template 폴더
@Controller
public class TesetTemplateController {

	@GetMapping("/template1")
	public String template(Model model, HttpServletRequest req) {
		model.addAttribute("msg", "스프링부트 템플릿 엔진!!");
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 33);
		//template1.html로 찾아간다.
		
		List<String> sList = new ArrayList<>();
		sList.add("장미");
		sList.add("국화");
		sList.add("매화");
		sList.add("동백");
		sList.add("무궁화");
		sList.add("작약");
		sList.add("백일홍");
		model.addAttribute("sList", sList);
		
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		boardList.add(new BoardDto("1", "제목1", "내용1", "작성자1", "11", "21"));
		boardList.add(new BoardDto("2", "제목2", "내용2", "작성자2", "12", "22"));
		boardList.add(new BoardDto("3", "제목3", "내용3", "작성자3", "13", "23"));
		boardList.add(new BoardDto("4", "제목4", "내용4", "작성자4", "14", "24"));
		boardList.add(new BoardDto("5", "제목5", "내용5", "작성자5", "15", "25"));
		
		model.addAttribute("boardList", boardList);
		
		HttpSession session = req.getSession();
		session.setAttribute("userid", "test1234");
		session.setAttribute("username", "홍길동");
		
		return "/template1";
	}
	
	@GetMapping("/board/list")
	public String board_list(Model model, HttpServletRequest req) {
		return "board_list";
	}
}
