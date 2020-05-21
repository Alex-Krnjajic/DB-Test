package Pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbEntry
 */
@WebServlet("/dbEntry")
public class dbEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		String height = request.getParameter("height");
		String width = request.getParameter("width");
		String depth = request.getParameter("depth");
		String weight = request.getParameter("weight");
		String colour = request.getParameter("colour");
		String effect = request.getParameter("effect");
		System.out.println("debug before sql");
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3308/foundation?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm","root","");  
			System.out.println("debug during sql");
			
			Statement stmt=con.createStatement();  
			int nbUpdatedResult = stmt.executeUpdate("INSERT INTO `boxes`(`id`, `height`, `width`, `depth`, `weight`, `colour`, `effect`) "
					+ "VALUES ("+id+","+height+","+width+","+depth+","+weight+",'"+colour+"','"+effect+"')");
			System.out.println("debug after sql "+ nbUpdatedResult);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
