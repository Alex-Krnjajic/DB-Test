package Pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Registar")
public class Registar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String nameCheck = name;
        String passCheck = password;
        out.print("<p>"+name+" "+password+"</p>");   
        
        if(nameCheck.equals("") || passCheck.equals("")){
        	out.print("<p>unsuccesful registration</p>");
        	out.print("<p>name and/or password empty</p>");
        }
        else {
          
        aBean bean=new aBean(); 
        System.out.println(bean.getAllAccounts());
        if(bean.setNewAccount(name, password)) {
        	 out.print("<p>succesful registration</p>");
        	 out.print("<p>"+bean.getAccount(bean.getIndex())+"</p>");
        	
        }
        else {
        	 out.print("<p>unsuccesful registration</p>");
        }
          
       
        
        }
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
        rd.forward(request, response);  
      
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
