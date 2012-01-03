<%@page import="boundary.viewLapangan"%>
<%@page import="entity.DaftarLapangan"%>
<%@page import="entity.lapangan"%>
<%@page import="java.util.Iterator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Lapangan</title>
    </head>
    <body>
        <h1>Daftar Lapangan</h1>
        <a href ="logout">Logout</a>
        <a href ="edit-profil">Edit Profil</a>
        <a href ="activity">Activity</a>
        <a href ="list_lapangan">Daftar Lapangan</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Alamat</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                    
                <tr>
          <e:forEach items="${lapangan}" var="ev">
                    <td>${ev.ADDRESSLAP}</td>
                    <td>${ev.STATLAP}</td>
                    <td><a href="view_lapangan=${ev.IDLAP}">show</a></td>
            </e:forEach>
                </tr>
            </tbody>
        </table>
    </body>
   
</html>
