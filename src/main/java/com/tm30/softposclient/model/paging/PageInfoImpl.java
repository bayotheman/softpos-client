package com.tm30.softposclient.model.paging;

import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfoImpl implements PageInfo{
	private final int currentPage;
	private final int pageLimit;
	private final int totalPages;
	private final long totalElements;
	private final boolean hasNext;
	private final boolean hasPrevious;


	public static PageInfoImpl of(Pageable pageable, Page<?> page) {
		return new PageInfoImpl(
				pageable.getPageNumber(),
				pageable.getPageSize(),
				page.getTotalPages(),
				page.getTotalElements(),
				page.hasNext(),
				page.hasPrevious()
		);
	}



}
