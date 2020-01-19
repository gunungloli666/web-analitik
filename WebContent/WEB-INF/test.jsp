<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fajar Tutorial</title>

<%
String path = request.getContextPath(); 
%>
<link rel="stylesheet" href="<%=path%>/style/w3.css" type="text/css" >
<link rel="stylesheet" href="<%=path%>/style/x1.css" type="text/css" >

<%-- <link rel="stylesheet" href="<%=path%>/style/bootstrap.min.css" type="text/css" > --%>

</head>
<body>

<body class="light-grey">

<!-- Top container -->
<div class="container top deep-blue large padding" >

<a href="simple">Home</a>


<!--   <button class="btn deep-blue padding-0 hover-text-white" onclick="location.href='../index.jsp';"><i class="fa fa-home"></i>  Home &nbsp</button> -->
<!--   <button class="btn deep-blue padding-0 hover-text-white" onclick="location.href='../sitemap.jsp';"><i class="fa fa-bars"></i>  Site Map &nbsp</button> -->
<!--   <button class="btn deep-blue padding-0 hover-text-white" onclick="location.href='../about.jsp';"><i class="fa fa-graduation-cap"></i>  About &nbsp</button> -->
<!--   <button class="btn deep-blue padding-0 hover-text-white" onclick="location.href='../contact.jsp';"><i class="fa fa-envelope-o"></i>  Contact Us &nbsp</button> -->
<!--   <button class="btn deep-blue padding-0 right hover-text-white" onclick="language('false');"><img src="../images/indo.jpeg" /> &nbsp</button> -->
<!--   <button class="btn deep-blue padding-0 right hover-text-white" onclick="language('true');"><img src="../images/english.png" /> &nbsp</button> -->
<!--   <span class="right">Language : &nbsp</span> -->

  
</div>


<nav class="sidenav white nav" >
	<a href="print1">Test Syntax Highlighter</a>
	<a href="toConverter">Tutorial</a>
	<a href="downloadTa" >Download TESIS ITB</a>
	<a href="downloadBuku" >Download Buku</a>
	
</nav>

<%
String content = "test1" ; 
if(request.getAttribute("content") != null){
	content = (String) request.getAttribute("content"); 
}
String p =  "/WEB-INF/page/" + content + ".jsp"; 
%>

<div class="main" >
	<div class="container">
	<jsp:include page="<%=p%>"></jsp:include>
	</div>
</div>

</body>
</html>