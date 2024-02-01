package com.tm30.softposclient.entities.configvalues;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

//@Embeddable
@Setter
@Getter
public class ConfigDateTime extends ConfigValue {

	private LocalDate startDate;
	private LocalTime startTime;

	private LocalDate endDate;
	private LocalTime endTime;



}
