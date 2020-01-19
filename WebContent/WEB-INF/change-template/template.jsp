<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.BufferedReader , java.io.FileReader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello World 
<p><a href="change-template">Change</a></p>
<%
String s = application.getRealPath("/WEB-INF/change-template/1.html");
BufferedReader  br = null;
StringBuilder builder = new StringBuilder(); 
try{
br = new BufferedReader(new FileReader(s));
	String temp = ""; 
	while((temp = br.readLine())!= null){
		builder.append(temp); 
	}
}finally{
	if( br != null){
		br.close();
	}
}
%>
<%=builder.toString()%>
</body>
</html>