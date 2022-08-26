package lk.himash.exceptionHandling.utils;

import lk.himash.exceptionHandling.Dto.WardDto;
import lk.himash.exceptionHandling.model.Ward;

public class DtoMapper {

	public static Ward dtoToWard(WardDto wardDto) {
		Ward ward = new Ward(wardDto.getWardId(), wardDto.getWardNo(), wardDto.getWardName(), wardDto.getPatient(),
				wardDto.getDoctor());
		return ward;
	}

	public static WardDto wardObjToWardto(Ward ward) {
		WardDto wardDto = new WardDto(ward.getWardId(), ward.getWardNo(), ward.getWardName(), ward.getPatient(),
				ward.getDoctor());
		return wardDto;
	}

}
