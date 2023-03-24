package com.kosa.myapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SequenceGenerator(
		name="SEQ_GENERATOR",
		sequenceName = "SEQ_SAMPLE",
		initialValue = 1,
		allocationSize = 1)
@Getter
@Setter
@Entity
@Table(name="tb_sample")
public class SampleDto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "SEQ_SAMPLE"
			)
	private int seq;
	private String test;

}
