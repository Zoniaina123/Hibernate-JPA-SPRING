package com.formation.tutorial.hibernate.domain;

import java.util.List;

import javax.persistence.EntityManager;

public class EmployeeAffiche {
		
		public void AfficheEmployee(EntityManager entityManager) {
			List<Employee> listemp = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
			for (Employee empl : listemp) {
				System.out.println("Employee name= " + empl.getName() + ", Employee id " + empl.getEmployeeId()+ " Email: " + empl.getEmail());
			}
		}
			
}	
