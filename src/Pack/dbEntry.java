package Pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
	public ServletRequest request;
	public String table;
	public Connection con;
       
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
		table = request.getParameter("table");
		this.request = request;
		
		 
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3308/foundation?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm","root","");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println("debug during sql");
		
		switch(table) {
			case "boxes":
				boxesMethod();
			case "researchers":
				researchersMethod();
			case "sites":
				sitesMethod();
				
		};
			
		
	}
	private void sitesMethod() {
		// TODO Auto-generated method stub
		
		String idString = request.getParameter("id");
	int id = Integer.parseInt(idString); 
	String xCordString = request.getParameter("xCord");
	float xCord = Float.parseFloat(xCordString);
	String yCordString = request.getParameter("yCord");
	float yCord = Float.parseFloat(yCordString); 
	String siteManager = request.getParameter("siteManager");

	System.out.println("debug before sql");
	
	try{ 
		 
		String Query = "INSERT INTO `sites`(`id`, `xCord`, `yCord`, `siteManager`) "
				+ "VALUES (?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setInt(1, id);
		pstmt.setFloat(2, xCord);
		pstmt.setFloat(3, yCord);
		pstmt.setString(4, siteManager);
		pstmt.executeUpdate();
		System.out.println("debug after sql ");
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}

	private void researchersMethod() {
		// TODO Auto-generated method stub
		
	String idString = request.getParameter("id");
	int id = Integer.parseInt(idString); 
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	 
	String boxesIdString = request.getParameter("boxesId");
	int boxesId = Integer.parseInt(boxesIdString); 
	String sitesIdString = request.getParameter("sitesId");
	int sitesId = Integer.parseInt(sitesIdString); 
	String securityClearanceString = request.getParameter("securityClearance");
	int securityClearance = Integer.parseInt(securityClearanceString);
	System.out.println("debug before sql");
	
	try{  
		 
		String Query = "INSERT INTO `researchers`(`id`,`firstName`, `lastName`, `boxesId`, `sitesId`, `securityClearance`) "
				+ "VALUES (?,?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setInt(1, id);
		pstmt.setString(2, firstName);
		pstmt.setString(3, lastName);
		pstmt.setInt(4, boxesId);
		pstmt.setInt(5, sitesId);
		pstmt.setInt(6,securityClearance);
		pstmt.executeUpdate();
		System.out.println("debug after sql ");
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}

	private void boxesMethod() {
		
		String idString = request.getParameter("id");
	int id = Integer.parseInt(idString); 
	String heightString = request.getParameter("height");
	int height = Integer.parseInt(heightString); 
	String widthString = request.getParameter("width");
	int width = Integer.parseInt(widthString); 
	String depthString = request.getParameter("depth");
	int depth = Integer.parseInt(depthString); 
	String weightString = request.getParameter("weight");
	int weight = Integer.parseInt(weightString); 
	String colour = request.getParameter("colour");
	String effect = request.getParameter("effect");
	System.out.println("debug before sql");
	
	try{  
	
		String Query = "INSERT INTO `boxes`(`id`, `height`, `width`, `depth`, `weight`, `colour`, `effect`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setInt(1, id);
		pstmt.setInt(2, height);
		pstmt.setInt(3, width);
		pstmt.setInt(4, depth);
		pstmt.setInt(5, weight);
		pstmt.setString(6,colour);
		pstmt.setString(7, effect);
		pstmt.executeUpdate();
		System.out.println("debug after sql ");
		
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
