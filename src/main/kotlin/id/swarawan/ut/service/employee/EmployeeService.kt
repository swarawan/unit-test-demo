package id.swarawan.ut.service.employee

import id.swarawan.ut.model.response.EmployeeResponse

interface EmployeeService {

	fun findAll(): List<EmployeeResponse>?

	fun findByEmail(email: String?): EmployeeResponse?
}