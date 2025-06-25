package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.Service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {

	// 필드
	@Autowired
	private GuestbookService guestbookService;

	// 생성자

	// 메소드-gs
	
	// 메소드일반
	
	// 방명록 리스트 전체 가져오기
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		//service
		//GuestbookService guestbookService = new GuestbookService();
		//guestbookService 메모리에 올려주세요 -> 주소를 주입해주세요
		List<GuestbookVO> guestbookList = guestbookService.exeGetGuestbookList();
		
		// model
		// D.S의 request의 attribute영역에 "gList" 이름으로 guestbookList 넣어줘
		model.addAttribute("gList", guestbookList);

		// view
		// 포워드-jsp파일을 찾아간다
		return "addlist";
	}

	// 방명록 글 저장
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
		// D.S야 파라미터의 값을 꺼내줘
		// GuestbookVO로 묶어줘
		System.out.println("GuestbookController.add()");
		System.out.println(guestbookVO);
		/*
		 * D.S가 하는일
		 * 
		 * 1.파라미터로 세터를 만든다 name=김나라 setName() password=1234 setPassword()
		 * content=asdfzxcv setContent()
		 * 
		 * 2.GuestbookVO(*defualt 생성자로*) 메모리에 올린다 GuestbookVO guestbookVO = new
		 * GuestbookVO()
		 * 
		 * 3.Setter로 값을 넣는다 name=김나라 setName(김나라) password=1234 setPassword(1234)
		 * content=asdfzxcv setContent(asdfzxcv)
		 * 
		 * 4.add(guestbookVO)를 실행한다.
		 * 
		 * url 파라미터 이름과 VO의 필드이름을 같게 만든다
		 * 
		 */
		
		guestbookService.exeGetGuestbookAdd(guestbookVO);
		
		//redirect
		return "redirect:/list";
	}

//	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
//	public String add(@RequestParam(value = "name") String name,
//					  @RequestParam(value = "password") String pw,
//					  @RequestParam(value = "content") String content) {
//						// D.S야 파라미터의 값을 꺼내줘
//						// GuestbookVO로 묶어줘
//		
//		System.out.println("GuestbookController.add()");
//		
//		GuestbookVO guestbookVO = new GuestbookVO();
//		guestbookVO.setName(name);
//		guestbookVO.setName(pw);
//		guestbookVO.setName(content);
//
//		System.out.println(guestbookVO);
//		
//		return "";
//	}
	
	//삭제폼
	@RequestMapping(value="/rform", method = {RequestMethod.GET, RequestMethod.POST})
	public String removeForm() {

		System.out.println("GuestbookController.removeForm()");
		
		return "removeform";
	}
	
	//삭제
		@RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
		public String remove(@ModelAttribute GuestbookVO guestbookVO) {
			System.out.println("GuestbookController.remove()");
			
			guestbookService.exeGuestbookRemove(guestbookVO);//!!주소!!만 줘
			
			return "redirect:/list";
		}

}
