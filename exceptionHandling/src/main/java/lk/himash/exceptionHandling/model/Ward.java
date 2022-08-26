package lk.himash.exceptionHandling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ward")
public class Ward {

	@Id
	@Column(name = "Ward_ID")
	private String wardId;
	
	@Column(name = "Ward_Number")
	private String wardNo;
	
	@Column(name = "Ward_Name")
	private String wardName;
	
	@Column(name = "Patient")
	private String patient;
	
	@Column(name = "Doctor")
	private String doctor;
	
}
