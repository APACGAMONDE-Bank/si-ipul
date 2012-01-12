<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Berita</title>
    </head>
    <body>
        <h2><%=(request.getAttribute("message"))%></h2>
        <form action="register" method="POST">
            <label>Title : </label><br />
            <input type="text" name="title" value="" /><br /> <input type="hidden" name="act" value="add" /><br />
            <label>Berita : </label><br />
            <textarea name="berita" rows="4" cols="20">
            </textarea><br/>
            <label>Picture:
            <input name="picture" type="file" id="pic" />
            </label>
            <input type="submit" value="Tambah" />
        </form><br/>
        <a href="homeOperator">Kembali Ke Home</a>
    </body>
</html>
