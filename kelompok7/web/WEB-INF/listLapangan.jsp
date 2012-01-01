<%-- 
    Document   : homeMember
    Created on : 16 Nov 11, 23:48:13
    Author     : yogi
--%>

<%@page import="entity.DaftarLapangan"%>
<%@page import="entity.lapangan"%>
<%@page import="java.util.Iterator"%>
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
        <a href ="editProfil">Edit Profil</a>
        <a href ="activity">Activity</a>
        <a href ="listLapangan">Daftar Lapangan</a>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<lapangan> daftarLap = (Iterator<lapangan>) request.getAttribute("listLapangan");
                int no = 0;
                while(daftarLap.hasNext()){
                    lapangan lap = daftarLap.next();
                    //Pengunjung pengunjung = lap.getPengunjung();
                    no++;
                %>
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(lapangan.getOperator())%></td>
                    <td><%=(lapangan.getAddressLap())%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
            <p>Jadikan Pesan Anda yang teratas! masukan pesan anda di <a href="tambah_pesan">sini</a> sekarang juga</p>
    </body>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello Member</h1>
        <br>
        
    </body>
</html>
