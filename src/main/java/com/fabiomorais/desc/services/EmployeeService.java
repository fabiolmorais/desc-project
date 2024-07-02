package com.fabiomorais.desc.services;

import com.fabiomorais.desc.dto.EmployeeDTO;
import com.fabiomorais.desc.entities.Employee;
import com.fabiomorais.desc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).get();
        return new EmployeeDTO(employee);
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> result = repository.findAll(pageable);
        return result.map(x -> new EmployeeDTO(x));
    }

    @Transactional()
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee employee = new Employee();
        copyDtoToEntity(dto, employee);
        employee = repository.save(employee);
        return new EmployeeDTO(employee);
    }

    private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
        entity.setName(dto.getName());
        entity.setRegistration(dto.getRegistration());
        entity.setBranch(dto.getBranch());
    }
}
