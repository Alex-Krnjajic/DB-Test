<%@page import="Pack.aBean,Pack.ControllaServlet"%>  
  
 
<%  
aBean bean=(aBean)request.getAttribute("bean");  
ControllaServlet db = (ControllaServlet)request.getAttribute("db");
int index = bean.getIndex();
out.print("Welcome, "+bean.getName()); 
//out.print(bean.getInfo(index));

%>

 <p>You are successfully logged in!</p> 
 
<a href="boxes.jsp">boxes</a>
<a href="researchers.jsp">researchers</a>
<a href="sites.jsp">sites</a>
