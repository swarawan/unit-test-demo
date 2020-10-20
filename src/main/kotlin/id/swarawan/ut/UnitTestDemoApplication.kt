package id.swarawan.ut

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnitTestDemoApplication

fun main(args: Array<String>) {
	runApplication<UnitTestDemoApplication>(*args)
}
