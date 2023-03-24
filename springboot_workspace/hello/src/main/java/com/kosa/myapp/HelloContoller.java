package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller는 이전과 동일
// return 값을 이용해 필요한 mustache 파일을 찾는다.
//src/main/resource/tamplates 폴더 아래에 html 파일을 두어야 한다.

@Controller
public class HelloContoller {

	@GetMapping("/")
	public String hello() {
		return "/test";
	}
}
