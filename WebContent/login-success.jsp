<%@page import="Pack.aBean,Pack.ControllaServlet"%>  
  
 
<%  
aBean bean=(aBean)request.getAttribute("bean");  
ControllaServlet db = (ControllaServlet)request.getAttribute("db");
int index = bean.getIndex();
out.print("Welcome, "+bean.getName()); 
//out.print(bean.getInfo(index));

%>

 <p>You are successfully logged in!</p> 
 
<form action="dbEntry" method="post">  
id:<input type="text" name="id"><br>  
height<input type="text" name="height"><br>  
width:<input type="text" name="width"><br>
weight:<input type="text" name="weight"><br>
colour:<input type="text" name="colour"><br>
effect:<input type="text" name="effect"><br>
<input type="submit" value="submit info">  
</form> 