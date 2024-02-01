package com.tm30.softposclient.entities.configvalues;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tm30.softposclient.entities.ProcessorConfig;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ConfigValue {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@JsonIgnore
	private Long id;
	private String name;
	private String description;
	
	@OneToOne
	@JsonBackReference
//	@JoinColumn(name="processor_id")
	@JsonIgnore
	private ProcessorConfig processor;

}
