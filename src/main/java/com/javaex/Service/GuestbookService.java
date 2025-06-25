package com.javaex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {

	// 필드
	@Autowired
	private GuestbookDAO guestbookDAO;

	// 생성자

	// 메소드-gs

	// 메소드일반
	// 전체 방명록 리스트 가져오기
	public List<GuestbookVO> exeGetGuestbookList() {
		System.out.println("GuestbookService.exeGetGuestbookList()");

		// dao 통해서 일한다
		List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();

		return guestbookList;
	}

	// 방명록 저장하기
	public int exeGetGuestbookAdd(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookAdd()");

		int count = guestbookDAO.guestbookInsert(guestbookVO);

		return count;

	}

	// 방명록 삭제하기
	public int exeGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookRemove()");

		int count = guestbookDAO.guestbookDelete(guestbookVO);
		
		return count;
		
	}

}
