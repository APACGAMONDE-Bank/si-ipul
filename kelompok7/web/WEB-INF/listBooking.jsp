<%@page import="boundary.listBooking"%>
<%@page import="entity.booking"%>
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
        <title>Daftar Booking</title>
    </head>
    <body>
        <h1>Daftar Booking</h1>
        <a href ="logout">Logout</a>
        <a href ="edit-profil-op">Edit Profil</a>
        <a href ="list_berita">Berita</a>
        <a href ="list_booking">Booking</a>
        <a href ="add_berita">Tambah Berita</a>
        <a href ="add_lapangan">Tambah Lapangan</a>
        <a href ="history">History Booking Lapangan</a>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Tanggal</th>
                    <th>Lapangan</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<booking> i = (Iterator<booking>) request.getAttribute("daftar_book");
                int no = 0;
                while(i.hasNext()){
                    booking b= i.next();
                    no++;
                %>
                
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(b.getDateBook())%></td>
                    <td><%=(b.getLapangan())%></td>
                    <td><a href="confirmBook?lap=<%=(b.getid())%>">confirm</a></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </body>
   
</html>
