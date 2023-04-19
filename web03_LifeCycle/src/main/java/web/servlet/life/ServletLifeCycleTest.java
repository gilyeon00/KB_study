package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Servlet API 와 컨테이너가 어떻게 callback메서드를 호출하는지 순서를 알아보자
 */

//@WebServlet("/Life")  // 주석했다 -> d.d파일이없다 -> servlet instance 생성 불가
public class ServletLifeCycleTest extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private int count = 0;
       

    public ServletLifeCycleTest() {
        System.out.println("1. 컨테이너에 의해 서블릿 객체 생성");
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	System.out.println("2. 컨테이너에 의해 init() 호출 ");
    }
    
    public void destroy() {
    	System.out.println("4. 컨테이너에 의해 destroy() 호출");
    	
    }

	
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("3. doGet()호출..컨테이너에 의해서.. 요청때마다 계속 호출");
        
        // 클라이언트의 요청을 처리...
        PrintWriter out = response.getWriter();
        
        //브라우저로 바로 출력
        out.print("<body bgcolor = 'yellow'>");
        out.println("<h3>LifeCycle CallBack Method...</h3>");
        out.println("<b>Count:: " + ++count + "<b>");
        out.println("</body>");
        out.close();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 컨테이너에 의해 doPost() 호출 ... 요청때 마다 계속 호출");
	}

}
