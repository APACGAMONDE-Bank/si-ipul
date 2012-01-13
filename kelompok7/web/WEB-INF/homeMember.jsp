<%-- 
    Document   : homeMember
    Created on : 16 Nov 11, 23:48:13
    Author     : yogi
--%>

<%@page import="entity.DaftarUser"%>
<%@page import="entity.members"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
String username=(String) session.getAttribute("name");
if(username==null) username="";
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <form id="form1" name="form1" method="post" action="homeMember">
        <h2>SELAMAT DATANG <%=username%>
<table width="200" border="0">
  <tr>
      <td><a href="homeMember"></a></td>
  </tr>
</table>
        </h2>
  <h2></h2>
  
</form>
        <br>
        <a href ="logout">Logout</a>
        <a href ="edit-profil">Edit Profil</a>
        <a href ="list_activity">Activity</a>
        <a href ="list_lapangan">Daftar Lapangan</a>
        <a href ="booking_online">Booking Lapangan</a>
    </body>
</html>
