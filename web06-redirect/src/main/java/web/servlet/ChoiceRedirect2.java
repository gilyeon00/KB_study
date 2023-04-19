package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Redirect2")
public class ChoiceRedirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * form 값 받아서 처리
		 * 1) 에러가 발생하는 경우(체크박스 선택 안할 때) -> 에러페이지(정적문서 -> 웹서버를 다시 거쳐야함 -> redirect) 연결 
		 * 2) 에러가 발생하지 않는 경우 -> 결과 페이지 (jsp) -> 서버에서 다이렉트 연결 -> forward
		 */
		
		String city = request.getParameter("city");
		if(city!=null)
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		else
			response.sendRedirect("./error/error2.html");
	}



}
