package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** @WebServlet(url) 어노테이션이 하는 일
 * <servlet>
 * 	<servlet-name>FormServlet
 * 	<servlet-class>web.servlet.form.FormServlet
 * </servlet>
 * <servlet-mapping>
 * 	<servlet-name>FormServlet
 * 	<urlpattern> /FS
 * </servlet-mapping>
 */
@WebServlet("/FS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormServlet() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("서비스는 이쪽으로 들어옵니다.");
		
		// form에 입력된 값 받아서 다시 브라우저로 응답
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		 out.println("<html><body>");
	        out.println("<ul><li>ID : "+id+"</li>");
	        out.println("<li>PASS : "+  pass+"</li></ul>");
	        out.println("</body></html>");
	}

}
