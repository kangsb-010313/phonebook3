package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhonebookDAO;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVO;

@WebServlet("/pbc2")
public class PhonebookController2 extends HttpServlet {
	
	//필드
	private static final long serialVersionUID = 1L;
	
       
	//생성자 -> 기본생성자 사용으로 삭제
	

    //메소드 gs
	
    
    //메소드 일반
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직
		
		//작동했는지 확인용
		System.out.println("PhonebookController");
		
		//action 파라미터의 값이 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action); //업무구분
		
		
		if("list".equals(action)) { // 리스트 업무
			System.out.println("리스트");
			//db 데이터 가져온다 --> List
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			List<PersonVO> personList = phonebookDAO.personSelect();
			
			System.out.println(personList);
			
			//저 밑에 있는 list.jsp 에게 후반일을 시킨다
			// 1)request객체에 데이터를 넣어준다
			request.setAttribute("pList", personList);
								  //String //0x333
			
			// 2)list.jsp에 request객체와 response객체를 보낸다
			//*forward 포워드
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
		
		
		////////////////////////////////////////////////////////////////////////
		}else if("wform".equals(action)) {// 등록폼 업무 (등록이랑 다른 업무: 등록이랑 구별할 것)
			
			System.out.println("등록폼");
		
			//등록폼을 응답해야함
			//1) DB관련 할 일이 없다 -> 안하면 된다
			
			//2) jsp에게 화면을 그리게 한다(포워드)
			//writeForm.jsp 포워드한다
			RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
			rd.forward(request, response);
			
		////////////////////////////////////////////////////////////////////////
		}else if("write".equals(action)) {// 등록 업무
			System.out.println("등록");
			
			//파라미터3개 꺼내기
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//데이터를 묶는다
			PersonVO personVO = new PersonVO(name, hp, company);
			System.out.println(personVO);
			
			//DAO를 통해서 저장시키기
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			phonebookDAO.personInsert(personVO);
			
			
			
			//리다이렉트 list 요청해주세요
			//http://localhost:8080/phonebook2/pbc?action=list
			response.sendRedirect("http://localhost:8080/phonebook2/pbc?action=list");
			
			/*
			//응답 (리스트) 하기 -------------------------------------------
			// --dao 시켜서 데이터 가져오기
			List<PersonVO> personList = phonebookDAO.personSelect();
			
			//request의 Attribute영역에 데이터 넣기
			request.setAttribute("pList", personList);
			
			
			
			//*forward 포워드
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
			*/
			
			
		////////////////////////////////////////////////////////////////////////
		}else if("delete".equals(action)) {
			System.out.println("삭제");
			
			//파라미터에서 no 꺼내온다
			int no = Integer.parseInt(request.getParameter("no"));
			
			//DAO를 통해서 no를 주고 삭제
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			phonebookDAO.personDelete(no);
			
			
			//리다이렉트 list 요청해주세요
			//http://localhost:8080/phonebook2/pbc?action=list
			response.sendRedirect("http://localhost:8080/phonebook2/pbc?action=list");
			
			
		////////////////////////////////////////////////////////////////////////
		}else if("mform".equals(action)) {//수정폼
			System.out.println("수정폼");
			
			//2) jsp에게 화면을 그리게 한다(포워드)
			//writeForm.jsp 포워드한다
			RequestDispatcher rd = request.getRequestDispatcher("/modifyForm.jsp");
			rd.forward(request, response);
			
	
		////////////////////////////////////////////////////////////////////////
		}else if("modify".equals(action)) {
			System.out.println("수정");
			
			//파라미터 4개의 정보를 꺼내온다
			int personId =  Integer.parseInt(request.getParameter("person_id"));
			String name = request.getParameter("name");
			String hp =  request.getParameter("hp");
			String company = request.getParameter("company");
			
			//데이터를 묶는다
			PersonVO personVO = new PersonVO(personId, name, hp, company);
			
			//dao를 통해서 no를 주고 삭제
			PhonebookDAO phonebookDAO= new PhonebookDAO();
			phonebookDAO.personUpdate(personVO);
			
			//리다이렉트 action=list
			WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
			
		}
		
		
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
