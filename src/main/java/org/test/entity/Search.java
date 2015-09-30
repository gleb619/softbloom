package org.test.entity;

import java.io.Serializable;

public class Search implements Serializable {

	private static final long serialVersionUID = 3057395936127568470L;

	private String filter;

	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Search(String filter) {
		super();
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}
