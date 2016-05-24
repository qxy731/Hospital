/**
 * @author : zhoutuo
 * @version : 1.0
 * @date : Oct 11, 2015 9:29:56 AM
 * @discription : TODO
 */
package com.ydisoft.hospital.util;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName : Page.java
 * @author : franke2009
 * @version : 1.0
 * @date : Oct 11, 2015 9:29:56 AM
 * @discription : TODO
 */
public class Page<T> implements Iterable<T>{

	private int currentPage = 1;// 当前页
	private int pageSize = 2;// 每页条数
	
	private int prePage;// 上一页
	private int nextPage;// 下一页
	
	private int totalRow;// 总条数
	private int totalPage;// 总页数
	
	private List<T> result;

	public Page() {
	}

	public Page(int curPage) {
		this.setCurrentPage(curPage);
	}

	public Page(int currentPage, int pageSize) {
		this.setCurrentPage(currentPage);
		this.setPageSize(pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		if (this.currentPage < 1) {
			this.currentPage = 0;
		}
	}
	
	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		if(totalRow > 0){
			this.totalRow = totalRow;
		}
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
	}
	
	public int getOffset(){
		int page_index = getCurrentPage() - 1;
		page_index = page_index < 0 ? 0 : page_index;
		return page_index * pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalPage() {
		return (int) Math.ceil((double) getTotalRow() / (double) getPageSize());
	}
	
	public int getNextPage() {
		return nextPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void refresh() {
		
		if (totalRow == 0){
			currentPage = 1;
			totalPage = 1;
		}
		else{
			totalPage = getTotalPage();
			
			currentPage = currentPage < 1 ? 1 : currentPage;
			currentPage = currentPage > totalPage ? totalPage : currentPage;
		}
		
		nextPage = (currentPage < totalPage ? currentPage + 1 : totalPage);
		prePage = (currentPage - 1 > 1 ? currentPage - 1 : 1);
	}
	
	/**
	 * 数据结果集
	 * @param elements
	 */
	public void setResult(List<T> elements) {
		if (elements == null){
			throw new IllegalArgumentException("Page's 'result' must be not null!");
		}
		this.result = elements;
	}
	
	/**
	 * 当前页包含的数据
	 *
	 * @return 当前页数据源
	 */
	public List<T> getResult() {
		return result;
	}
	
	/** 
	 * 实现Iterable接口, 可以for(Object item : page)遍历使用
	 */
//	@Override
	public Iterator<T> iterator() {
		if(result == null){
			return null;
		}
		return result.iterator();
	}
	
	/**
	 * 是否还有下一页.
	 */
	public boolean hasNextPage() {
		return (getPageSize() + 1 <= getTotalPage());
	}

	/**
	 * 是否最后一页.
	 */
	public boolean isLastPage() {
		return !hasNextPage();
	}
	
}
