package com.kosa.myapp.guestbook;

import lombok.Getter;
import lombok.Setter;

// getter, setter 어노테이션으로 갈음한다.
// 이걸 지원하는 라이브러리가 lombok
// 근데 잘 안될 때가 많아서 jar파일을 다운 받아야 함
@Setter
@Getter
public class GuestbookDto {
	
	private String id="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
}
