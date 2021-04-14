package com.cugb.utils;
/*
 * 分页查询
 */
public class PageTool {
	
	private int pageSize;//页容量
	private int totalCount;//总记录数
	private int totalPages;//总页数
	private int currentPage;//当前页码
	private int prePage;//上一页
	private int nextPage;//下一页
	private int startIndex;//每一页第一条记录起始下标
	
	public PageTool() {}
	
	public PageTool(int totalCount, String currentPage) {
		super();
		this.totalCount = totalCount;
		this.pageSize = 20;//页容量写死，但是可以修改
		initCurrentPage(currentPage);//当前页码的初始化
		initTotalPages();//总页数初始化
		initPrePage();//初始化上一页
		initNextPage();//初始化下一页
		initStartIndex();//初始化起始下标
	}
	
	//给当前类中的当前页码进行初始化操作，如果currentPage为空，默认查询第一页，斗则根据传递过来的页码查询
	private void initCurrentPage(String currentPage) {
		if(currentPage==null) {
			this.currentPage = 1;
		}else {
			this.currentPage = Integer.valueOf(currentPage);
		}
	}
	
	//给总页数初始化
	private void initTotalPages() {
		this.totalPages = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	}
	
	//给上一个初始化
	private void initPrePage() {
		if(this.currentPage == 1) {
			this.prePage = 1;
		}else {
			this.prePage = this.currentPage - 1;
		}
	}
	
	//给下一个初始化
	private void initNextPage() {
		if(this.currentPage == this.totalPages) {
			this.nextPage = this.totalPages;
		}else {
			this.nextPage = this.currentPage + 1;
		}
	}
	
	//给每页第一条起始下标赋值
	private void initStartIndex() {
		this.startIndex = pageSize*(this.currentPage-1);
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
}