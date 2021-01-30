package jpatest.yjpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YjparkApplication {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.setData("abc");
		String data = hello.getData();

		System.out.println(data);

		SpringApplication.run(YjparkApplication.class, args);
	}

}
