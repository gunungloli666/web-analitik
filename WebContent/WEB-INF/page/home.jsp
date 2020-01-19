<% 
String hasil = (String) request.getAttribute("hasil");
String content  = (String) request.getParameter("content"); 
%>
Untuk sekarang baru bisa menghighlight syntax java, itupun masih banyak kekurangan
<br/>
<br/>

<div style="position:relative; float: left; width: 100%;">

<div style="position:relative; float: left; width: 50%; overflow:auto; ">
	<form method="post" action="highlight"  >
	<table>
		<tr><td><textarea rows="13" cols="50" name="content" ><%if(content!= null){%><%=content%><%}%></textarea></td></tr>
		<tr><td><button type="submit" class="btn green">higlight</button></td></tr>
	</table>
	
	</form>
	
	<% 
	if(hasil != null){
	%>	
	<table>
		<tr><td><textarea rows="13" cols="50" ><%=hasil%></textarea></td></tr>
	</table>
	<%}%>
</div>

<%
if(hasil!=null){
%>

<pre class="result-area" >
<%=hasil%>
</pre>

<%}%>

</div>