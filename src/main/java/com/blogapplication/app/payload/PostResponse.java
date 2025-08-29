package com.blogapplication.app.payload;

import java.util.List;

import com.blogapplication.app.entities.Post;

public class PostResponse {

	List<PostDto> content;
	int pageNumber;
	int pagesize;
	long totalElement;
	int totalPges;
	boolean isLastPage;
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}
	public int getTotalPges() {
		return totalPges;
	}
	public void setTotalPges(int totalPges) {
		this.totalPges = totalPges;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
