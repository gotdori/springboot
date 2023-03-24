package jpaeduexam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpaeduexam.dto.EmpDto;

public class EmpDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
	EntityManager em = factory.createEntityManager();
	
	public void close() {
		em.close();
		factory.close();
	}
	
	public void printAll() {
		TypedQuery<EmpDto> query = em.createQuery("select t from EmpDto t", EmpDto.class);
		List<EmpDto> list = query.getResultList();
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		//람다식으로 전환 / 자바가 람다식을 프로그램에 편입한게 자바8 부터
		//list -> stream 객체로 전환해야한다.
		//forEach는 매개변수로 전달해야 한다.
		list.stream().forEach(e->{
			System.out.println(e);
		});
	}
	//이름으로 검색
	public void searchName(String name) {
		String sql = "select t from EmpDto t where t.ename like :ename";
		TypedQuery q = em.createQuery(sql, EmpDto.class);
		q.setParameter("ename", "%"+name+"%");
		
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	//2가지 조건을 묶을 때
	public void searchNameAndJob(String name, String job) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t from EmpDto t ");
		buffer.append("where t.ename like :ename and t.job like :job");
		TypedQuery q = em.createQuery(buffer.toString(), EmpDto.class);
		q.setParameter("ename", "%"+name+"%");
		q.setParameter("job", "%"+job+"%");
		
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	//2가지 조건을 묶을 때(2)
	public void searchNameAndJob2(String name, String job) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t from EmpDto t ");
		buffer.append("where t.ename like ?1 and t.job like ?2");
		//?1 : 첫번째 파라미터
		//?2 : 두번쨰 파라미터
		TypedQuery q = em.createQuery(buffer.toString(), EmpDto.class);
		q.setParameter(1, "%"+name+"%");
		q.setParameter(2, "%"+job+"%");
		
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void groupFunctionTest() {
		Query query = em.createQuery("select sum(t.sal) from EmpDto t");
		Object result = query.getSingleResult();
		System.out.println(result);
	}
	
	public void update(int empno, Integer sal) {
		String sql = "select t from EmpDto t where t.empno = :empno";
		TypedQuery q = em.createQuery(sql, EmpDto.class);
		q.setParameter("empno", empno);
		
		EmpDto dto  = (EmpDto)q.getSingleResult();
		if(dto!=null) {
			em.getTransaction().begin();
			dto.setSal(sal);
			em.getTransaction().commit();
		}
	}
	
	public void deleteEmpno(Integer empno) {
		try {
			em.getTransaction().begin();
			EmpDto dto = em.find(EmpDto.class, empno);
			em.remove(dto); //삭제
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
