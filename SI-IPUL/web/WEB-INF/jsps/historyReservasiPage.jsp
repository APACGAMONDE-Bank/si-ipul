<%-- 
    Document   : historyReservasiPage
    Created on : Nov 28, 2011, 10:37:34 AM
    Author     : yogi
--%>

<%@page import="model.members"%>
<%@page import="model.listBooking"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Reservasi</title>
    </head>
    <body>
        <h1>Sepuluh Reservasi Terbaru Yang Sudah Masuk</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Tanggal</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<listBooking> histori = (Iterator<listBooking>) request.getAttribute("listBooking");
                int no = 0;
                while(histori.hasNext()){
                    listBooking lst = listBooking.next();
                    members member = members.getUsernameMb();
                    no++;
                %>
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(members.getUsernameMb())%></td>
                    <td><%=(pesan.getTanggal())%></td>
                    <td><%=(pesan.getPesan())%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
            <p>Jadikan Pesan Anda yang teratas! masukan pesan anda di <a href="tambah_pesan">sini</a> sekarang juga</p>
    </body>
</html>
