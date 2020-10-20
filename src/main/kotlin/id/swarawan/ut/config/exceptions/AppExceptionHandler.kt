package id.swarawan.ut.config.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class AppExceptionHandler : ResponseEntityExceptionHandler() {

	@ExceptionHandler(DataNotFoundException::class)
	fun dataNotFound(ex: DataNotFoundException) = throwException(ex, HttpStatus.NOT_FOUND)

	@ExceptionHandler(Exception::class)
	fun exception(ex: Exception) = throwException(ex, HttpStatus.BAD_REQUEST, "error.app")

	private fun throwException(
		throwable: Throwable,
		httpStatus: HttpStatus,
		errorMessage: String? = null
	): ResponseEntity<Any> {

		val message = when (errorMessage) {
			null -> throwable.localizedMessage
			else -> errorMessage
		}

		return ResponseEntity(message, httpStatus)
	}
}