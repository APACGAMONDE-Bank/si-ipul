<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%
String n=(String) session.getAttribute("name");
String a=(String) session.getAttribute("address");
String e=(String) session.getAttribute("email");
String h=(String) session.getAttribute("hp");
%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <table border="1">
            <form method="post" action="edit-profil-op">
            <thead>
               
                    <th>Edit Profile</th>
                
            </thead>
            <tbody>
                <tr>
                    <td>Nama    </td>
                    <td><input type="text" name="name" value="<%=n%>"/></td><input type="hidden" name="act" value="add" />
                </tr>
                <tr>
                    <td>Alamat  </td>
                    <td><input type="text" name="address" value="<%=a%>"/></td>
                </tr>
                <tr>
                    <td>Telepon </td>
                    <td><input type="text" name="handphone" value="<%=h%>"/></td>
                </tr>
                <tr>
                    <td>Email   </td>
                    <td><input type="text" name="email" value="<%=e%>"/></td>
                </tr>
                <tr>
                    <td>Password    </td>
                    <td><input type="password" name="password" value=""/></td>
                </tr>
                
            </tbody>
        </table>
        <input type="submit" value="Edit" />
        </form>
            <br>
        <a href="homeMember">Back to Home</a>
    </body>
</html>
