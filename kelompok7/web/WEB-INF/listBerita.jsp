<%@page import="entity.infoBerita"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Berita</title>
    </head>
    <body>
        <h1>Daftar Berita</h1>
        <a href ="logout">Logout</a>
        <a href ="edit-profil">Edit Profil</a>
        <a href ="add_berita">Tambah Berita</a>
        <a href ="add_lapangan">Tambah Lapangan</a>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Judul</th>
                    <th>Info</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<infoBerita> i = (Iterator<infoBerita>) request.getAttribute("daftar_berita");
                int no = 0;
                while(i.hasNext()){
                    infoBerita ib= i.next();
                    no++;
                %>
                
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(ib.getTitle())%></td>
                    <td><%=(ib.getInfoBerita())%></td>
                    <td><a href="view_lapangan">show</a></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </body>
   
</html>
