package com.formation.tutorial.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.tutorial.hibernate.domain.Employee;
import com.formation.tutorial.hibernate.domain.EmployeeAffiche;



/**
 * @author Sylvain LALLIER
 *
 */
public class EmployeeTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "appConfig.xml" });
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emplyee");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		

		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		Employee employee = new Employee();
		employee.setName("Malalatiana");
		employee.setEmployeeId(56);
		//Employee employee = entityManager.find(Employee.class, 4);
		employee.setEmail("mllt@gmail.com");
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		//System.out.println("Result Employee ID = " + employee.getEmployeeId() + " et son nom:  " + employee.getName()+ "avec son email:" + employee.getEmail());

		// get an object using primary key.
		//Employee emp = entityManager.find(Employee.class, 4);
		//System.out.println(emp);
		//System.out.println("Got Employee " + emp.getName() + " " + emp.getEmployeeId());

		// get all the objects from Employee table
		/*@SuppressWarnings("unchecked")
		List<Employee> listEmployee = entityManager.createQuery("SELECT e FROM Employee e").getResultList();

		if (listEmployee == null) {
			System.out.println("No employee found . ");
		} else {
			for (Employee empl : listEmployee) {
				System.out.println("Employee name= " + empl.getName() + ", Employee id " + empl.getEmployeeId());
			}
		}*/
		// remove and entity
/*		entityManager.getTransaction().begin();
		System.out.println("Deleting Employee with ID = " + emp.getEmployeeId());
		entityManager.remove(emp);
		entityManager.getTransaction().commit();*/
		
		//methode avec l'appel d'un bean
		EmployeeAffiche ep1 = (EmployeeAffiche) appContext.getBean("employeeAffiche");
		ep1.AfficheEmployee(entityManager);

		// close the entity manager
		entityManager.close();
		entityManagerFactory.close();

	}
}
