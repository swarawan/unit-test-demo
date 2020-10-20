package id.swarawan.ut.service.employee

import id.swarawan.ut.config.exceptions.DataNotFoundException
import id.swarawan.ut.model.entity.Employee
import id.swarawan.ut.model.response.EmployeeResponse
import id.swarawan.ut.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.regex.Pattern

@Service
class EmployeeServiceImpl @Autowired constructor(
	private val employeeRepository: EmployeeRepository
) : EmployeeService {

	override fun findAll(): List<EmployeeResponse>? {
		return employeeRepository.findAll().map {
			EmployeeResponse(it.name, it.email)
		}.toList()
	}

	override fun findByEmail(email: String?): EmployeeResponse? {
		when {
			email.isNullOrEmpty() ->
				throw DataNotFoundException()

			!Pattern.compile(REGEX_EMAIL).matcher(email.trim()).matches() ->
				throw Exception()
		}

		val employee: Employee? = employeeRepository.findAll().firstOrNull() {
			it.email.equals(email, true)
		} ?: throw DataNotFoundException()

		return EmployeeResponse(employee?.name, employee?.email)
	}

	companion object {
		const val REGEX_EMAIL =
			"^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$"

	}
}