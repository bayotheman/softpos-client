package com.tm30.softposclient.entities.configvalues;

import com.tm30.softposclient.entities.users.Acquirer;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;


//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@EqualsAndHashCode(callSuper=false)
@Table(indexes = @Index(name = "number", columnList = "number"))
public class CardBin extends ConfigValue{

//	@Column(unique = true)
	private String number;
	private String brand;
	@ManyToOne
	private Acquirer acquirer;
	
}
