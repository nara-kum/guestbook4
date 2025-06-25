package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<GuestbookVO> guestbookSelect() {

		System.out.println("GuestbookDAO.guestbookSelect()");

		List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");
		
		return guestbookList;

	}

	public int guestbookInsert(GuestbookVO guestbookVO) {
		System.out.println("GuestbookDAO.guestbookInsert()");
		
		int count = sqlSession.insert("guestbook.insert",guestbookVO);

		return count;
	}

	public int guestbookDelete(GuestbookVO guestbookVO) {
		System.out.println("GuestbookDAO.guestbookDelete()");
		
		int count = sqlSession.delete("guestbook.delete",guestbookVO);
		
		return count;
	}

}