package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 클라이언트의 요청을 처리
 * get ---> doGet()
 * post --> do Post()
 * 
 * get ---> doPost() 호출 : Error Status Code 405
 * 	 요청 방식과 서블릿 코드가 안맞았다
 */
@WebServlet("/form")
public class FromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FromServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h2>Get방식의 요청입니다.</h2");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		out.println("<li>" + id + "</li>");
		out.println("<li>" + name + "</li>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String gender =request.getParameter("gender");
		String[] techs = request.getParameterValues("tech");
		
		out.println("<h2> 폼값에 입력된 정보들 입니다. </h2>");
		out.println("<li> 아이디 : " + id + "</li>");
		out.println("<li> 비밀번호 : " + password + "</li>");
		out.println("<li> 성별 : " + gender + "</li>");
		out.println("<b> 사용기술 입니다. <b> <br>");
		
		StringBuffer sb = new StringBuffer();
	    sb.append("<h2>ID : ").append(id).append("</h2>");
	    sb.append("<h2>PASSWORD : ").append(password).append("</h2>");
	    sb.append("<h2>GENDER : ").append(gender).append("</h2>");
	    
		StringBuffer sb2 = new StringBuffer();
	    for(String t : techs) {
	        sb2.append(t).append(", ");
	    }
	    sb2.setLength(sb2.length()-2);
	    
	    sb.append("<h2>TECH : ").append(sb2).append("</h2>");
	    
	    out.append(sb);
	}

}
