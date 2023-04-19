package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 쿠키 생성
		Cookie cookie1 = new Cookie("id", "KBstar");
		Cookie cookie2 = new Cookie("today", "2023-04-19");
		
		// 2. 만료 시간 지정
		cookie1.setMaxAge(24*60*60);	// 하루동안 브라우저에 정보 변경
		cookie2.setMaxAge(24*60);			// 쿠키 사용 못함
		
		// 3. 서버로 다시 전송
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		// 4. 페이지 이동	- 쿠키는 서버에서 만들어져서 브라우저로 보내짐. 다시 요청시, 이 쿠키가 사용되므로 response
		response.sendRedirect("getCookie.jsp");
		
	}

	

}
