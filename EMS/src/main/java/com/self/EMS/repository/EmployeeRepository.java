package com.self.EMS.repository;

import com.self.EMS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository, @Transactional no need to these since it extends JPARepo
public interface EmployeeRepository extends JpaRepository<Employee,  Long> {

}
