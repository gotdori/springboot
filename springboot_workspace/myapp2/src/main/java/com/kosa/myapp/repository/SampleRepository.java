package com.kosa.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kosa.myapp.domain.SampleDto;

public interface SampleRepository  extends JpaRepository<SampleDto, Long>{
	List<SampleDto> findByTestOrderBySeqDesc(String test);
	
	@Query("select s from SampleDto s where s.test like %:test%")
	List<SampleDto> searchByTest(@Param("test")String test);
}
