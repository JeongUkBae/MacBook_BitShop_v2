package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import domain.MemberBean;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 디폴트 값
		 * cmd : move
		 * dir : mamber ....
		 * page : main
		 * dest : none
		 * */
		
		System.out.println("======> 맴버 서블릿 입장");
		String context = request.getContextPath();
		HttpSession session = request.getSession();
		session.setAttribute("context", context);
		MemberBean member = null;
		MemberService memberService = MemberServiceImpl.getInstance();
		String cmd = request.getParameter("cmd");
		cmd = (cmd == null) ? "move" : cmd;
		
		String dir = request.getParameter("dir");
		if(dir == null) {
			String sPath =  request.getServletPath();
			sPath = sPath.replace(".do", "");
			dir=sPath.substring(1);
		}
		
		String page = request.getParameter("page");
		if(page == null) {page="main";}
		
		String dest = request.getParameter("dest");
		if(dest ==null) { 
			dest = "NONE";
		}
		
		
		switch(cmd) {
		case "login": 
			System.out.println("스위치 오면서  ==="+dir);
			System.out.println("case = login ,액션이 ="+cmd);
			
			boolean checkId = memberService.existMember(request.getParameter("uid"), request.getParameter("upw"));
			if(checkId) {
				dir = "";
				page = "index";
			}else {
				System.out.println("어디인가. ");
				member = MemberServiceImpl.getInstance().findMemberById(request.getParameter("uid"));
				session.setAttribute("user", member);
				request.setAttribute("dest", "welcome");
			}
			
			
			break;
			
		case "move" : 
			System.out.println("case = move ,액션이 ="+cmd);
			System.out.println("3====맴버서블릿에서 OUT");
			
			request.setAttribute("dest", dest);
			
			break;
			
		case "join" :
			System.out.println("조인?? 들어왔어?");
			member = new MemberBean();
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPass(request.getParameter("pass"));
			member.setSsn(request.getParameter("ssn"));
			
			System.out.println("어디로 갈까"+dir+"/"+page);
			MemberServiceImpl.getInstance().creatMember(member);
			member = MemberServiceImpl.getInstance().findMemberById(member.getId());
			System.out.println(">>>>>> 조회결과 "+member.toString());
			
			session.setAttribute("user", member);
			request.setAttribute("dest", dest);
			//request.setAttribute("member", MemberServiceImpl.getInstance().findById(member.getId()));
			
			break;
		}
		Command.move(request, response, dir, page);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
