package Address;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class AddressManager {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
	EntityManager em = factory.createEntityManager();

	public void close() {
		em.close();
		factory.close();
	}

	public void insert(String name, String phone, String email) {

		AddressDto dto = new AddressDto();

		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setWdate("2023-02-21");

		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
	}

	public void searchName(String name) {

		String sql = "select a from AddressDto a where a.name like ?1";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter(1, "%" + name + "%");

		List<AddressDto> list = q.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});
	}

	public void searchPhone(String phone) {

		String sql = "select a from AddressDto a where a.phone like ?1";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter(1, "%" + phone + "%");

		List<AddressDto> list = q.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});
	}

	public void searchEmail(String Email) {

		String sql = "select a from AddressDto a where a.Email like ?1";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter(1, "%" + Email + "%");

		List<AddressDto> list = q.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});
	}

	public void update(int seq) {
		Scanner sc = new Scanner(System.in);
		String sql = "select a from AddressDto a";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});

		sql = "select a from AddressDto a where a.seq = ?1";
		q = em.createQuery(sql, AddressDto.class);
		q.setParameter(1, seq);

		AddressDto dto = (AddressDto) q.getSingleResult();
		System.out.println("1.이름수정   2.전화번호수정   3.이메일수정");
		int n = sc.nextInt();
		if (dto != null) {
			if (n == 1) {
				String something = sc.next();
				dto.setName(something);
			}
			else if (n == 2) {
				String something = sc.next();
				dto.setPhone(something);
			} else {
				String something = sc.next();
				dto.setEmail(something);
			}
			em.getTransaction().begin();
			em.getTransaction().commit();
		}
	}
	public void delete(Integer seq) {
		String sql = "select a from AddressDto a";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});
		
		try {
			em.getTransaction().begin();
			AddressDto dto = em.find(AddressDto.class, seq);
			em.remove(dto);
			em.getTransaction().commit();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void printAll() {
		String sql = "select a from AddressDto a";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(e -> {
			System.out.println(e);
		});
	}
	
	public void insert10() {

		for (int i = 0; i < 10; i++) {
		AddressDto dto = new AddressDto();
		dto.setName("유저"+i);
		dto.setPhone("010-"+i);
		dto.setEmail(i+"@naver.com");
		dto.setWdate("2023-02-21");

		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
		}
	}
}
