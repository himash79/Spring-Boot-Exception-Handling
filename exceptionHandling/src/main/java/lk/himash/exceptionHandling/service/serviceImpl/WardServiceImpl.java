package lk.himash.exceptionHandling.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.himash.exceptionHandling.Dto.WardDto;
import lk.himash.exceptionHandling.model.Ward;
import lk.himash.exceptionHandling.repository.WardRepository;
import lk.himash.exceptionHandling.service.WardService;
import lk.himash.exceptionHandling.utils.DtoMapper;

@Service
@Transactional
public class WardServiceImpl implements WardService {

	@Autowired
	private WardRepository wardRepo;

	@Override
	public ResponseEntity<?> getWardDetails(String wardId) {
		System.out.println("Start | getWardDetails() method | WardServiceImpl.class |");
		Ward ward = null;
		try {
			ward = wardRepo.findById(wardId).get();
		} catch (Exception ex) {
			System.out.println("Exception found on | getWardDetails() method | WardServiceImpl.class |");
			throw new IllegalArgumentException("Ward Id Not Found");
		}
		return new ResponseEntity<>(ward, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> saveWardDetails(WardDto wardDto) throws Exception {
		System.out.println("Start | saveWardDetails() method | WardServiceImpl.class |");
		System.out.println("wardDto : " + wardDto);
		Ward ward = null;
		if (wardDto.getWardId().equals(null) || wardDto.getWardId().length() == 0) {
			throw new IllegalArgumentException("Ward Id Required");
		} else if (wardDto.getWardNo().equals(null) || wardDto.getWardNo().length() == 0) {
			throw new IllegalArgumentException("Ward Number Required");
		} else {
			try {
				ward = DtoMapper.dtoToWard(wardDto);
				ward = wardRepo.save(ward);
			} catch (Exception ex) {
				System.out.println("Exception found on | saveWardDetails() method | WardServiceImpl.class |");
				throw new Exception("Ward Details Must be Filled");
			}
		}
		return new ResponseEntity<>(ward, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getAllWardDetails() throws Exception {
		System.out.println("Start | getAllWardDetails() method | WardServiceImpl.class |");
		List<Ward> wards = new ArrayList<>();
		try {
			wards = wardRepo.findAll();
		} catch (Exception ex) {
			System.out.println("Exception found on | getAllWardDetails() method | WardServiceImpl.class |");
			throw new Exception("Ward Details Couldn't fetched");
		}
		return new ResponseEntity<>(wards, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> removeWardDetails(String wardId) {
		System.out.println("Start | removeWardDetails() method | WardServiceImpl.class |");
		Ward ward = null;
		try {
			wardRepo.deleteById(wardId);
		} catch (Exception ex) {
			System.out.println("Exception found on | removeWardDetails() method | WardServiceImpl.class |");
			throw new IllegalArgumentException("Ward Id Not Found");
		}
		return new ResponseEntity<>(ward, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateWardDetails(WardDto updateWard, String wardId) throws Exception {
		System.out.println("Start | removeWardDetails() method | WardServiceImpl.class |");
		Ward ward, prevWard, newWard = null;
		if (updateWard.getWardId().equals(null) || updateWard.getWardId().length() == 0) {
			throw new IllegalArgumentException("Ward Id Not Found");
		} else if (updateWard.equals(null)) {
			throw new Exception("Request object not found");
		} else {
			try {
				newWard = DtoMapper.dtoToWard(updateWard);
				prevWard = wardRepo.findById(wardId).get();
				ward = updatedWardDetails(prevWard, newWard);
			} catch (Exception ex) {
				System.out.println("Exception found on | removeWardDetails() method | WardServiceImpl.class |");
				throw new Exception("Ward Details Update Fail");
			}
		}
		return new ResponseEntity<>(ward, HttpStatus.OK);
	}

	private static Ward updatedWardDetails(Ward prevWard, Ward newWard) {
		if (prevWard.getWardId().equalsIgnoreCase(newWard.getWardId())) {
			prevWard.setWardNo(newWard.getWardNo());
			prevWard.setWardName(newWard.getWardName());
			prevWard.setPatient(newWard.getPatient());
			prevWard.setDoctor(newWard.getDoctor());
		}
		return prevWard;
	}

}
