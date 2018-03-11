package com.formation.tutorial.hibernate.domain;

import java.util.List;

import javax.persistence.EntityManager;


public class EmployeeDAO {


	public void create(Employee employee, EntityManager entityManager) {
			entityManager.getTransaction().begin();
			employee.setEmployeeId(employee.getEmployeeId());
			employee.setName(employee.getName());
			employee.setEmail(employee.getEmail());
			System.out.println("EMPLOYEE save with id= "+employee.getEmployeeId()+ " name: "+ employee.getName()+ " , email: "+ employee.getEmail());
			entityManager.close();
		
	}
		
	
	public void update(String e, EntityManager entityManager, int id,String op) {
		entityManager.getTransaction().begin();
		Employee emp = entityManager.find(Employee.class, id);
		if (op=="email") {
			emp.setEmail(e);
		}
		if (op=="name") {
			emp.setName(e);
		}		
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	

	
	public void delete(Employee employee, EntityManager entityManager,int id) {
		entityManager.getTransaction().begin();
		Employee emp = entityManager.find(Employee.class, id);
		entityManager.remove(emp);
		entityManager.getTransaction().commit();
		System.out.println("EMPLOYEE deleted with id="+id);
		entityManager.close();
	}
	

}
