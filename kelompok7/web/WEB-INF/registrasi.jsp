<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Registrasi SI-IPUL</title>
    </head>
    <body>
        <h2><%=(request.getAttribute("message"))%></h2>
        <form action="register" method="POST">
            <label>Username : </label><br />
            <input type="text" name="username" value="" /> <input type="hidden" name="act" value="add" /> <br />
            <label>Password : </label><br />
            <input type="password" name="password" value="" /><br />
            <label>Nama : </label><br />
            <input type="text" name="name" value="" /><br />
            <label>Alamat : </label><br />
            <input type="text" name="address" value="" /><br />
            <label>Nomer Handphone : </label><br />
            <input type="text" name="handphone" value="" /><br />
            <label>Email: </label><br />
            <input type="text" name="email" value="" /><br />
            <label>Tipe     :
                <label><input type="radio" name="tp" value="1" />Member</label>
                <td></td>
                <label><input type="radio" name="tp" value="0" />Operator</label>
            </label>
            <input type="submit" value="Submit" />
        </form><br/>
        <a href="">Kembali Ke Halaman Login</a>
    </body>
</html>
