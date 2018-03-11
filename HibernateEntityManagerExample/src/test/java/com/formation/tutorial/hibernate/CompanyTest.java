package com.formation.tutorial.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.tutorial.hibernate.domain.Company;
import com.formation.tutorial.hibernate.domain.Employee;


public class CompanyTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "appConfig.xml" });
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emplyee");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		
		
		//recupérer le bean
		CompanyTest test = new CompanyTest();
		
		//pour creer ma compagnie
		Company c = new Company();
		c.setCompanyId(8);
		c.setCompanyName("Company Test1");
		

		
		//pour me mettre dans ma compagnie
		//je fais un select dans la table Employee et je stocke dans emp, avec une liste
		//je cree une list d'employee
		List<Employee> empl = new ArrayList<Employee>();
		Employee emp = entityManager.find(Employee.class,4);
		Employee emp1 = entityManager.find(Employee.class,1234);
		Employee emp2 = entityManager.find(Employee.class,1235);
		
		//j'ajoute les employes dans la liste
		empl.add(emp);
		empl.add(emp1);
		empl.add(emp2);
		
		//je me mets dans compagnie:
		c.setEmployee(empl);
		
		entityManager.getTransaction().commit();
		
		entityManager.getTransaction().begin();
		//j'enregiste
		entityManager.persist(c);
		
		entityManager.getTransaction().commit();
		
		//je fais un select de ma compagnie  dans la table Compagnie
		c = entityManager.find(Company.class,8);
		

		//j'affiche
		System.out.println(c);
		
		
		// close the entity manager
		entityManager.close();
		entityManagerFactory.close();
		
	}

}