package com.fabiomorais.desc.services;

import com.fabiomorais.desc.dto.EmployeeDTO;
import com.fabiomorais.desc.entities.Employee;
import com.fabiomorais.desc.repositories.EmployeeRepository;
import com.fabiomorais.desc.services.exception.DatabaseException;
import com.fabiomorais.desc.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
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

    @Transactional()
    public EmployeeDTO update(Long id, EmployeeDTO dto) {

        try {

        Employee employee = repository.getReferenceById(id);
        copyDtoToEntity(dto, employee);
        employee = repository.save(employee);
        return new EmployeeDTO(employee);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
        entity.setName(dto.getName());
        entity.setRegistration(dto.getRegistration());
        entity.setBranch(dto.getBranch());
    }
}
