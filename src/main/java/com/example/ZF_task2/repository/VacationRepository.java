package com.example.ZF_task2.repository;

import com.example.ZF_task2.entity.VacationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends CrudRepository<VacationEntity, Long> {

    List<VacationEntity> findByEmployeeId(Long employeeId);

    @Query(value = "select COALESCE(sum(registered_days),0) as registered FROM VACATION where employee_id = ?1", nativeQuery = true)
    Long registeredDays(Long employeeId);
}
