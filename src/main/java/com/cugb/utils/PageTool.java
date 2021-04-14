package com.cugb.utils;
/*
 * ��ҳ��ѯ
 */
public class PageTool {
	
	private int pageSize;//ҳ����
	private int totalCount;//�ܼ�¼��
	private int totalPages;//��ҳ��
	private int currentPage;//��ǰҳ��
	private int prePage;//��һҳ
	private int nextPage;//��һҳ
	private int startIndex;//ÿһҳ��һ����¼��ʼ�±�
	
	public PageTool() {}
	
	public PageTool(int totalCount, String currentPage) {
		super();
		this.totalCount = totalCount;
		this.pageSize = 20;//ҳ����д�������ǿ����޸�
		initCurrentPage(currentPage);//��ǰҳ��ĳ�ʼ��
		initTotalPages();//��ҳ����ʼ��
		initPrePage();//��ʼ����һҳ
		initNextPage();//��ʼ����һҳ
		initStartIndex();//��ʼ����ʼ�±�
	}
	
	//����ǰ���еĵ�ǰҳ����г�ʼ�����������currentPageΪ�գ�Ĭ�ϲ�ѯ��һҳ��������ݴ��ݹ�����ҳ���ѯ
	private void initCurrentPage(String currentPage) {
		if(currentPage==null) {
			this.currentPage = 1;
		}else {
			this.currentPage = Integer.valueOf(currentPage);
		}
	}
	
	//����ҳ����ʼ��
	private void initTotalPages() {
		this.totalPages = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	}
	
	//����һ����ʼ��
	private void initPrePage() {
		if(this.currentPage == 1) {
			this.prePage = 1;
		}else {
			this.prePage = this.currentPage - 1;
		}
	}
	
	//����һ����ʼ��
	private void initNextPage() {
		if(this.currentPage == this.totalPages) {
			this.nextPage = this.totalPages;
		}else {
			this.nextPage = this.currentPage + 1;
		}
	}
	
	//��ÿҳ��һ����ʼ�±긳ֵ
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