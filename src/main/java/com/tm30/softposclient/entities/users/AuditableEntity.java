package com.tm30.softposclient.entities.users;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AuditableEntity<T> {
	@CreatedBy
	@OneToOne
	private T createdBy;
	@LastModifiedBy
	@OneToOne
	private T modifiedBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateCreated;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateModified;


}
