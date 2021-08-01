package com.example.ZF_task2.repository;

import com.example.ZF_task2.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "select count(id) as is_vacation FROM VACATION where employee_id = ?1 and CURRENT_TIMESTAMP() between vacation_begin and vacation_end", nativeQuery = true)
    Integer checkStatus(Long employeeId);
}
