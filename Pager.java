package com.winter.app.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pager {

	private String search;
	private String kind;

	// 페이지 번호
	private Long page;

	// 시작 ROWNUM
	private Long first;

	// 끝 ROWNUM
	private Long last;

	// 한페이지에 출력할 글의 갯수
	private Long perPage;

	// JSP에 출력할 시작번호
	private Long start;

	// JSP에 출력할 끝번호
	private Long end;

	// 이전 블럭 유무
	private boolean pre;

	// 다음 블럭 유무
	private boolean next;

	public String getSearch() {
		if (search == null) {
			this.search = "";
		}
		return this.search;
	}

	public Long getPerPage() {
		if (this.perPage == null || this.perPage % 5 != 0) {
			this.perPage = 10L;
		}

		return this.perPage;
	}

	public Long getPage() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return this.page;
	}

	// ------------------
	public void makeRowNumber() throws Exception {
		this.first = (this.getPage() - 1) * this.getPerPage() + 1;
		this.last = this.getPage() * this.getPerPage();
	}

	// ------------------
	public void makePageNumber(Long totalCount) throws Exception {

		// 2. 총 페이지수
		// Long totalPage = totalCount/this.getPerPage();
		// if(totalCount%this.perPage != 0) {
		// totalPage++;
		// }

		Long totalPage = (long) (Math.ceil(totalCount / (double) this.getPerPage()));

		if (this.getPage() > totalPage) {
			this.page = totalPage;
		}

		// 3. 총 블럭 갯수
		Long perBlock = 5L;
		Long totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 4. 현재 페이지 번호로 현재 블럭 번호 구하기
		Long curBlock = this.getPage() / perBlock;
		if (this.getPage() % perBlock != 0) {
			curBlock++;
		}

		// 5. 현재 블럭 번호로 시작번호와 끝번호 구하기
		this.start = (curBlock - 1) * perBlock + 1;
		this.setEnd(curBlock * perBlock);

		// 이전블럭이 존재한다면 true, 아니면 false
		if (curBlock > 1) {
			this.pre = true;
		}

		// 다음블럭이 존재한다면 true, 아니면 false
		if (curBlock < totalBlock) {
			this.next = true;
		} else {
			this.setEnd(totalPage);
		}

		this.makeRowNumber();

	}

}