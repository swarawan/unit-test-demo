package id.swarawan.ut.repository

import id.swarawan.ut.model.entity.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<EmployeeEntity, Long>