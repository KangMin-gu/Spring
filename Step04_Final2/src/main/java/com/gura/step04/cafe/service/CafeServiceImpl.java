package com.gura.step04.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.cafe.dao.CafeDao;
import com.gura.step04.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeDao cafeDao;

	// 한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT = 3;
	// 하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT = 5;

	@Override
	public void insert(CafeDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CafeDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public ModelAndView list(HttpServletRequest request) {
		/*
		 * request 에 검색 keyword 가 전달 될수도 있고 안될수도 있다. 
		 * 1. 전달 안되는 경우 : home.jsp 에서 목록보기를 누른경우 
		 * 2. 전달 되는 경우 : list.jsp 에서 검색어를 입력후 form 전송한 경우. 
		 * 3. 전달 되는 경우 : 이미 검색을 한 상태에서 페이지 링크를 누른경우
		 */
		// 검색과 관련된 파라미터를 읽어와 본다.
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");

		// 글정보를 담을 ModelAndView 객체
		ModelAndView mView = new ModelAndView();

		// CafeDto 객체를 생성해서
		CafeDto dto = new CafeDto();
		if (keyword != null) { // 검색어가 전달된 경우
			if (condition.equals("titlecontent")) { // 제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			} else if (condition.equals("title")) {// 제목 검색
				dto.setTitle(keyword);
			} else if (condition.equals("writer")) {// 작성자 검색
				dto.setWriter(keyword);
			}

			mView.addObject("condition", condition);
			mView.addObject("keyword", keyword);
		}

		// 보여줄 페이지의 번호
		int pageNum = 1;
		// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum = request.getParameter("pageNum");
		if (strPageNum != null) {// 페이지 번호가 파라미터로 넘어온다면
			// 페이지 번호를 설정한다.
			pageNum = Integer.parseInt(strPageNum);
		}
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum * PAGE_ROW_COUNT;
		// 전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = cafeDao.getCount(dto); //필드에 오토와이어드하고있기때문에 getinstance() 안해도됨
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
		// 끝 페이지 번호가 잘못된 값이라면
		if (totalPageCount < endPageNum) {
			endPageNum = totalPageCount; // 보정해준다.
		}

		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		// 1. 글목록을 불러온다.
		List<CafeDto> list = cafeDao.getList(dto);

		mView.addObject("list", list);
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		mView.addObject("totalPageCount", totalPageCount);

		return mView;
	}

	@Override
	public ModelAndView detail(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseViewCount(int num) {
		// TODO Auto-generated method stub

	}

}
