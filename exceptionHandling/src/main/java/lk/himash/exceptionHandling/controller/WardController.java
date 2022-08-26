package lk.himash.exceptionHandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.himash.exceptionHandling.Dto.WardDto;
import lk.himash.exceptionHandling.service.WardService;

@RestController
@RequestMapping("/wardApi")
public class WardController {

	@Autowired
	private WardService wardService;

	@GetMapping("/getWardDetails/{wardId}")
	public ResponseEntity<?> getWardDetails(@PathVariable String wardId) {
		return wardService.getWardDetails(wardId);
	}

	@PostMapping("/createWard")
	public ResponseEntity<?> createWard(@RequestBody WardDto wardDto) throws Exception {
		return wardService.saveWardDetails(wardDto);
	}

	@GetMapping("/getWardsDetails")
	public ResponseEntity<?> getWardsDetails() throws Exception {
		return wardService.getAllWardDetails();
	}
	
	@DeleteMapping("/removeWardDetails/{wardId}")
	public ResponseEntity<?> removeWardDetails(@PathVariable String wardId) {
		return wardService.removeWardDetails(wardId);
	}
	
	@PutMapping("/updateWard/{wardId}")
	public ResponseEntity<?> createWard(@RequestBody WardDto updateWard, @PathVariable String wardId) throws Exception {
		return wardService.updateWardDetails(updateWard, wardId);
	}


}
