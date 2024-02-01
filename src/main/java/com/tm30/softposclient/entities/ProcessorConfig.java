package com.tm30.softposclient.entities;

import com.tm30.softposclient.entities.users.Acquirer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProcessorConfig
//		extends AuditableEntity<BaseUser>
		implements Comparable<ProcessorConfig>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private boolean active;
	private String terminalId;
	private String merchantId;
	private String vendorCode;
	private String institutionBin;


	@Enumerated(EnumType.STRING)
	private ProcessorPriority priority;

	private boolean hsmTranslation;
	private boolean keyEncryptionEnabled;

	@OneToOne
	private Processor processor;


	@ManyToOne
	private Acquirer acquirer;

	@Override
	public int compareTo(ProcessorConfig o) {
		return Integer.compare(this.getPriority().getValue(), o.getPriority().getValue());
	}


	@Override
	public String toString() {
		return "ProcessorConfig{" +
				"id=" + id +
				", name='" + name + '\'' +
				", active=" + active +
				", terminalId='" + terminalId + '\'' +
				", merchantId='" + merchantId + '\'' +
				", vendorCode='" + vendorCode + '\'' +
				", institutionBin='" + institutionBin + '\'' +
				", priority=" + priority +
				", hsmTranslation=" + hsmTranslation +
				", keyEncryptionEnabled=" + keyEncryptionEnabled +
				", processor=" + processor +
				", acquirer=" + acquirer +
				'}';
	}
}
