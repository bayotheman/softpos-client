package com.tm30.softposclient.entities;

import com.tm30.softposclient.utils.ULIDUtil;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Embeddable
@Getter
@Setter
public class Hsm {
	private String id = ULIDUtil.nextValue();
	private boolean keyTranslationIndex;
	private String ip;
	private Integer port;
	private boolean active;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Hsm hsm)) return false;
		return Objects.equals(id, hsm.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (!(o instanceof Hsm hsm)) return false;
//		return Objects.equals(ip, hsm.ip) && Objects.equals(port, hsm.port);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(ip, port);
//	}
}
