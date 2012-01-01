<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <table border="1">
            <form method="post" action="editProfil">
            <thead>
               
                    <th>Edit Profile</th>
                
            </thead>
            <tbody>
                <tr>
                    <td>Nama    </td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Alamat  </td>
                    <td><input type="text" name="address" /></td>
                </tr>
                <tr>
                    <td>Telepon </td>
                    <td><input type="text" name="handphone" /></td>
                </tr>
                <tr>
                    <td>Email   </td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Username    </td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password    </td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>Confirm Password    </td>
                    <td><input type="password" name="confirm password" /></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Edit" />
        </form>
            <br>
        <a href="homeMember">Back to Home</a>
    </body>
</html>
