package com.tm30.softposclient.model.paging;

/**
 * @author Adebayo .A. Okutubo
 */
public interface PageInfo {
	public int getCurrentPage();

	public int getPageLimit() ;

	public int getTotalPages() ;

	public long getTotalElements() ;
}
