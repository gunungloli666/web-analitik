<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String m = (String)request.getAttribute("page");
String hal = "/WEB-INF/tesis-s2-part-1/"+m+".jsp";
String next = Integer.toString(Integer.parseInt(m) + 1);
String prev = Integer.toString(Integer.parseInt(m) - 1);

int current = Integer.parseInt(m);
if( current == 1){
	prev = "84";
}else if(current == 84){
	next = "1"; 
}
%>
<p>Daftar Link  Download Tesis ITB</p>


<table><tr>
<td><a href="downloadTa?page=<%=prev%>">prev</a></td>
<td><a href="downloadTa?page=<%=next%>">next</a></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=m%></td>
</tr></table>
<br />


<%
String includePage = "/WEB-INF/s2/"+m +".html"; 
%>
<jsp:include page="<%=includePage%>"></jsp:include>




<table><tr>
<td><a href="downloadTa?page=<%=prev%>">prev</a></td>
<td><a href="downloadTa?page=<%=next%>">next</a></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=m%></td>
</tr></table>
<br />