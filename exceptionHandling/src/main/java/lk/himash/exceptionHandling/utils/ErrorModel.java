package lk.himash.exceptionHandling.utils;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {

	private String mesasge;
	private Integer errorCode;
	private HttpStatus httpStatus;
	private ZonedDateTime timeStamp;
	
	
}
