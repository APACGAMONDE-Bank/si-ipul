<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Lapangan</title>
    </head>
    <body>
        <h2><%=(request.getAttribute("message"))%></h2>
        <form action="addLapangan" method="POST">
            <label>Alamat : </label><br />
            <input type="text" name="address" value="" /><br />
            <input type="submit" value="Tambah" />
        </form><br/>
        <a href="homeMember">Kembali Ke Home</a>
    </body>
</html>
