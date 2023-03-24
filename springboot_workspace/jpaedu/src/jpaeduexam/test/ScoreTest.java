package jpaeduexam.test;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpaeduexam.dto.ScoreDto;

public class ScoreTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
		// factory - 객체를 생성해내는 별도의 클래스
		EntityManager em = factory.createEntityManager();
		System.out.println("JPA실습");
		
		//데이터 추가하기
		ScoreDto dto = new ScoreDto();
		dto.setName("임꺽정");
		dto.setKor(90);
		dto.setEng(80);
		dto.setMat(70);
		dto.setWdate(LocalDateTime.now());
		
//		em.getTransaction().begin();
//		em.persist(dto);
//		em.getTransaction().commit();
		
		//데이터 가져오기
		//TypedQuery 테이블이 아니라 클래스에서 데이터를 가져온다.
		TypedQuery<ScoreDto> q = em.createQuery("select A from ScoreDto A", ScoreDto.class);
		List<ScoreDto> list = q.getResultList();
		
		//자바스크립트의 화살표함수 자바는 list -> stream객체로 전환 후 사용
		//forEach - 매개변수 하나이고 반환값이 없는 람다함수를 전달해야한다
		list.stream().forEach(e->{
			System.out.println(String.format("%s %d %d %d", e.getName(), e.getKor(), e.getEng(), e.getMat()));
		});
		
		System.out.println("번호로 검색하기");
		//검색
		q = em.createQuery("select A from ScoreDto A where A.seq=:seq", ScoreDto.class);
		//검색조건이 있을 경우에
		q.setParameter("seq", 1);
		
		list = q.getResultList();
		
		list.stream().forEach(e->{
			System.out.println(String.format("%s %d %d %d", e.getName(), e.getKor(), e.getEng(), e.getMat()));
		});
		
		em.close();
		factory.close();
	}
}
