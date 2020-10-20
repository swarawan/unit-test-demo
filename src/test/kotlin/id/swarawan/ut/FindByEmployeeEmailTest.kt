package id.swarawan.ut

import id.swarawan.ut.config.exceptions.DataNotFoundException
import id.swarawan.ut.model.entity.Employee
import id.swarawan.ut.repository.EmployeeRepository
import id.swarawan.ut.service.employee.EmployeeService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.Exception

@SpringBootTest
class FindByEmployeeEmailTest @Autowired constructor(
	private val employeeService: EmployeeService,
	private val employeeRepository: EmployeeRepository
) {

	private val validEmail: String = "k1@example.com"

	@BeforeEach
	fun setup() {
		val listOfEmployee = listOf(
			Employee(1, "Kijang Satu", "k1@example.com"),
			Employee(2, "Kijang Dua", "k2@example.com")
		)
		employeeRepository.saveAll(listOfEmployee)
	}

	@AfterEach
	fun finishEachTest() {
		employeeRepository.deleteAll()
	}

	@Test
	fun testSuccess_findSingleData_returnData() {
		val employee = employeeService.findByEmail(validEmail)
		Assertions.assertNotNull(employee)
		Assertions.assertEquals(employee?.email, validEmail)
	}

	@Test
	fun testFailure_notValidEmail_returnError() {
		Assertions.assertThrows(Exception::class.java) {
			employeeService.findByEmail("not-valid-email")
		}
	}

	@Test
	fun testFailure_notFound_returnNotFound() {
		Assertions.assertThrows(DataNotFoundException::class.java) {
			employeeService.findByEmail("not.found@example.com")
		}
	}

	@Test
	fun testFailure_emptyEmail_returnNotFound() {
		Assertions.assertThrows(DataNotFoundException::class.java) {
			employeeService.findByEmail("")
		}
	}

	@Test
	fun testFailure_nullEmail_returnNotFound() {
		Assertions.assertThrows(DataNotFoundException::class.java) {
			employeeService.findByEmail(null)
		}
	}

}
