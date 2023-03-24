package com.kosa.myapp.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
	protected int pg=0;
	protected int pgSize=10;
	protected int num=0;
	protected String searchGbn="";
	protected String searchKeyword="";

}
