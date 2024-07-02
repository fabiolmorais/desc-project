package com.fabiomorais.desc.dto;

import com.fabiomorais.desc.entities.Branch;
import com.fabiomorais.desc.entities.Employee;


public class EmployeeDTO {

    private Long id;
    private String name;
    private String registration;
    private Branch branch;

    public EmployeeDTO(Long id, String name, String registration, Branch branch) {
        this.id = id;
        this.name = name;
        this.registration = registration;
        this.branch = branch;
    }

    public EmployeeDTO(Employee employee) {
        id = employee.getId();
        name = employee.getName();
        registration = employee.getRegistration();
        branch = employee.getBranch();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public Branch getBranch() {
        return branch;
    }
}
