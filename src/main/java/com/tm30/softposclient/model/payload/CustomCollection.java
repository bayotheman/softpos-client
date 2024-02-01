package com.tm30.softposclient.model.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tm30.softposclient.model.paging.PageInfo;
import lombok.Data;

import java.util.Collection;

/**
 * A payload collection class to hold collection of data and page structure.
 * @author Adebayo .A. Okutubo
 * @param <T> data type
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomCollection<T> {
	private Collection<T> content ;
	private PageInfo pageInfo;

	private CustomCollection(){}

	public static <T> CustomCollection<T> create(Collection<T> collection){
		CustomCollection<T> collection1 = new CustomCollection<>();
		collection1.setContent(collection);
		return collection1;
	}

	public static <T> CustomCollection<T> create(Collection<T> collection, PageInfo info){
		CustomCollection<T> collection1 = new CustomCollection<>();
		collection1.setContent(collection);
		collection1.setPageInfo(info);
		return collection1;
	}

}
