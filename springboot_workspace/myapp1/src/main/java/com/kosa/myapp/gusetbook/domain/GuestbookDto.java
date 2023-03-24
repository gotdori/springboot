package com.kosa.myapp.gusetbook.domain;

import com.kosa.myapp.common.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestbookDto extends BaseDto{

	private String seq="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
	private String hit="";
	@Override
	public String toString() {
		return "GuestbookDto [seq=" + seq + ", title=" + title + ", writer=" + writer + ", contents=" + contents
				+ ", wdate=" + wdate + ", hit=" + hit + "]";
	}
	
}
