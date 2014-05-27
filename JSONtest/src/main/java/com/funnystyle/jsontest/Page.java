package com.funnystyle.jsontest;

public class Page {
	// 아래 두 개만 입력되면 다 계산되어야 함
	// currentPage
	// totalRow

	/* required */
	private int totalRow = 0;
	private int currentPage = 1;
	
	/* option */
	private int pageSize = 10; // row size of 1 page
	private int blockSize = 6;

	/* readonly */
	private int totalPage = 0; 
	private int currentBlock = 1;
	private int totalBlock = 1;
	private int firstPageOfCurrentBlock = 1;
	private int lastPageOfCurrentBlock = 1;
	
	private boolean isFirstPage;
	private boolean isLastpage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	private boolean hasPreviousBlock;
	private boolean hasNextBlock;

	Page(int totalRow, int currentPage) {
		this.totalRow = totalRow;
		this.currentPage = currentPage;
		setPage();
	}

	private void setPage() {
		totalPage = (totalRow - 1) / pageSize + 1;

		currentPage = Math.min(Math.max(1, currentPage), totalPage);
		
		currentBlock = (currentPage - 1) / blockSize + 1;
		totalBlock = (totalPage - 1) / blockSize + 1;
		firstPageOfCurrentBlock = currentPage - ((currentPage - 1) % blockSize);
		lastPageOfCurrentBlock = Math.min(firstPageOfCurrentBlock + blockSize - 1, totalPage);
		
		isFirstPage = (currentPage == 1);
		isLastpage = (currentPage == totalPage);
		
		hasPreviousPage = !isFirstPage; // (currentPage > 1);
		hasNextPage = !isLastpage; // (currentPage < totalPage);
		
		hasPreviousBlock = (blockSize < firstPageOfCurrentBlock);
		hasNextBlock = (lastPageOfCurrentBlock < totalPage);
	}
	
	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		setPage();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		setPage();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setPage();
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
		setPage();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public int getFirstPageOfCurrentBlock() {
		return firstPageOfCurrentBlock;
	}

	public int getLastPageOfCurrentBlock() {
		return lastPageOfCurrentBlock;
	}

	public boolean isIsFirstPage() {
		return isFirstPage;
	}

	public boolean isIsLastpage() {
		return isLastpage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public boolean isHasPreviousBlock() {
		return hasPreviousBlock;
	}

	public boolean isHasNextBlock() {
		return hasNextBlock;
	}
}
