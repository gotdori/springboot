package com.kosa.myapp.score.domain;

import com.kosa.myapp.common.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDto extends BaseDto{

	private String seq     ="";
	private String name    ="";
	private String kor     ="";
	private String eng     ="";
	private String mat     ="";
	private String wdate   ="";
}
