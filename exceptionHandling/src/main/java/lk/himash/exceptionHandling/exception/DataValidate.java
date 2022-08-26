package lk.himash.exceptionHandling.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lk.himash.exceptionHandling.utils.ErrorModel;

@ControllerAdvice
public class DataValidate {
	
	@ExceptionHandler(value = {IllegalArgumentException.class})
	public ResponseEntity<?> dataInValidException(IllegalArgumentException e) {
		ErrorModel ex = new ErrorModel(e.getMessage(),400,HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<?> saveException(Exception e) {
		ErrorModel ex = new ErrorModel(e.getMessage(),400,HttpStatus.INTERNAL_SERVER_ERROR,ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
