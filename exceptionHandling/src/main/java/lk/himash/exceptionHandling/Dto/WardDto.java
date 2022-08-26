package lk.himash.exceptionHandling.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WardDto {

	private String wardId;

	private String wardNo;

	private String wardName;

	private String patient;

	private String doctor;

}
