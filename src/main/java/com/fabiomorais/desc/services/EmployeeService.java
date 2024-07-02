package com.fabiomorais.desc.services;

import com.fabiomorais.desc.dto.EmployeeDTO;
import com.fabiomorais.desc.entities.Employee;
import com.fabiomorais.desc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).get();
        return new EmployeeDTO(employee);
    }
}
