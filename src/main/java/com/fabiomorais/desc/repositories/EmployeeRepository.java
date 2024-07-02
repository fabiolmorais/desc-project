package com.fabiomorais.desc.repositories;

import com.fabiomorais.desc.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}
