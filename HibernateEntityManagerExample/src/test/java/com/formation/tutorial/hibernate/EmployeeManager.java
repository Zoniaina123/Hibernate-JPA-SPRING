package com.formation.tutorial.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.tutorial.hibernate.domain.Employee;
import com.formation.tutorial.hibernate.domain.EmployeeDAO;

public class EmployeeManager {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "appConfig.xml" });
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emplyee");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		
		
		/*Employee emp = new Employee();
		emp.setName("Miana");
		emp.setEmployeeId(89);
		emp.setEmail("miana@gmail.com");
		*/
		/*entityManager.persist(emp);
		entityManager.getTransaction().commit();*/
		
		
		//entityManager.getTransaction().begin();
		
		Employee emp2 = new Employee();
		//emp2.setName("dana");
		//emp2.setEmployeeId(35);
		emp2.setEmail("kopana@gmail.com");
		
		//entityManager.persist(emp2);
		//entityManager.getTransaction().commit();
		
		
		//create
	/*	EmployeeDAO ep1 = (EmployeeDAO) appContext.getBean("employeeDAO");
		ep1.create(emp, entityManager);
		EmployeeDAO ep2 = (EmployeeDAO) appContext.getBean("employeeDAO");
		ep2.create(emp2, entityManager);*/
		
		//update email emp2
		
		EmployeeDAO ep3 = (EmployeeDAO) appContext.getBean("employeeDAO");	
	
		ep3.update("raha",entityManager,35,"name");
		
	
		
	
		
		
		//delete
		//ep2.delete(emp2, entityManager, 25);
		
		
		// close the entity manager
		//entityManager.close();
		entityManagerFactory.close();
		
		
	}

}
