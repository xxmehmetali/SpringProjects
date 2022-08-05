package com.managementsystem.studentmanagementsystem;

import com.managementsystem.studentmanagementsystem.Entity.Student;
import com.managementsystem.studentmanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class StudentmanagementsystemApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementsystemApplication.class, args);
	}


	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student1=new Student("ali","kara","alikara@gmail.com");
//		Student student2=new Student("veli","selam","selam@gmail.com");
//		Student student3=new Student("mahmut","elma","elma@gmail.com");
//		Student student4=new Student("tülay","canan","canan@gmail.com");
//
//
//		studentRepository.save(student1);
//		studentRepository.save(student2);
//		studentRepository.save(student3);
//		studentRepository.save(student4);

	}
}
