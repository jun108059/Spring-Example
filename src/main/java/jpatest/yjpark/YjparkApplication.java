package jpatest.yjpark;

import jpatest.yjpark.domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class YjparkApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Member member = new Member();
		member.setId(1L);
		member.setName("Hello");

		em.persist(member);

		tx.commit();

		em.close();

		emf.close();

		Hello hello = new Hello();
		hello.setData("abc");
		String data = hello.getData();

		System.out.println(data);

		SpringApplication.run(YjparkApplication.class, args);
	}

}
