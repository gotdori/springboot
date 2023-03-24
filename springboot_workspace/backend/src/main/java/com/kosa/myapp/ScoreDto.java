package com.kosa.myapp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC) //기본생성자
//함수의 매개변수, argument, parameter라고도 부른다.
//기본 생성자 만들고 접근권한은 public
public class ScoreDto {
	private String name="";
	private int kor=0;
	private int eng=0;
	private int mat=0;
	private int total=0;
	private int avg=0;

}
