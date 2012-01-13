<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Online</title>
    </head>
    <body>
        <h2><%=(request.getAttribute("message"))%></h2>
        <form action="booking_online" method="POST">
            <label>Lapangan : </label><br />
            <input type="text" name="idLap" value="" /><br /><input type="hidden" name="act" value="add" /><br />
            <label>Berapa Jam : </label><br />
            <input type="text" name="jam" value="" /><br />
            <input type="submit" value="Book" />
        </form><br/>
        <a href="login">Kembali Ke Halaman Login</a>
    </body>
</html>
