package lk.himash.exceptionHandling.service;

import org.springframework.http.ResponseEntity;

import lk.himash.exceptionHandling.Dto.WardDto;

public interface WardService {

	public ResponseEntity<?> getWardDetails(String wardId);
	public ResponseEntity<?> saveWardDetails(WardDto wardDto) throws Exception;
	public ResponseEntity<?> getAllWardDetails() throws Exception;
	public ResponseEntity<?> removeWardDetails(String wardId);
	public ResponseEntity<?> updateWardDetails(WardDto updateWard, String wardId) throws Exception;
	
}
