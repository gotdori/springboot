package jpaeduexam.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//오라클 시퀀스 - 이 어노테이션을 이용해 오라클에 SEQ_SCORE라는 시퀀스가 만들어진다.
//rdbms 중에서 오라클만 필요. 다른 dbms는 필요 없다.
@SequenceGenerator(
		name = "score_seq_generator", //시퀀스 제너레이터 이름
		sequenceName="seq_score", //시퀀스 이름
		initialValue=1, //시작값
		allocationSize=10 //메모리를 통해 할당할 범위 사이즈
		)
@Entity //rdbms 테이블과 Dto객체를 연결한다.
@Table(name="TB_SCORE") //오라클의 TB_SCORE라는 이름의 Table을 생성한다.
public class ScoreDto {
	
	@Id //primary key로 사용한다.
	@GeneratedValue(strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
	generator="SEQ_SCORE") //식별자 생성기를 설정해놓은  SEQ_SCORE으로 설정 / 자동생성, dbms마다 다르게 표시해야 한다.
	private int seq;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime wdate;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

}
