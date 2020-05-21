package Pack;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllaServlet")
public class ControllaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(DBHandler("SELECT * FROM boxes"));
		
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        out.print("before bean");
        aBean bean=new aBean();  
        request.setAttribute("bean",bean);  
       // bean.setNamePassword(name, password);
        boolean status=bean.validate(name,password);  
        out.print("after bean");  
        if(status){  
    
            RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");  
            rd.forward(request, response);  
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");  
            rd.forward(request, response);  
        }  
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static String DBHandler(String sqlQuery){ 
		String dbOutput = "";
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection(  
		"jdbc:mysql://localhost:3308/foundation?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm","root","");  
		
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(sqlQuery);  
		while(rs.next()) {  
			System.out.println(Integer.toString(rs.getInt(1))+"  "+ Integer.toString(rs.getInt(2))+"  "+Integer.toString(rs.getInt(3))+"  "+Integer.toString(rs.getInt(4))+"  "+Integer.toString(rs.getInt(5))+"  "+rs.getString(6)+"  "+rs.getString(7));
			dbOutput = (Integer.toString(rs.getInt(1))+"  "+ Integer.toString(rs.getInt(2))+"  "+Integer.toString(rs.getInt(3))+"  "+Integer.toString(rs.getInt(4))+"  "+Integer.toString(rs.getInt(5))+"  "+rs.getString(6)+"  "+rs.getString(7));
		}
		con.close(); 
		return dbOutput; 
		}catch(Exception e){ 
			System.out.println(e);
			return "Error";}
		
		
		} 
		}  


