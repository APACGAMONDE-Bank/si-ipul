<%@page import="entity.operator"%>
<%@page import="entity.members"%>
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
        <title>Daftar User</title>
    </head>
    <body>
        <h1>Daftar User</h1>
        <a href ="logout">Logout</a>
        <a href ="addUser">Add User</a>
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
                Iterator<members> i = (Iterator<members>) request.getAttribute("daftar_user");
                int no = 0;
                while(i.hasNext()){
                    members im= i.next();
                    no++;
                %>
                
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(im.getNameMb())%></td>
                    <td><%=(im.getAddressMb())%></td>
                    <td><a href="editMember">Edit</a></td>
                    <td><a href="deleteMember">Delete</a></td>
                </tr>
                <%
                }
                %>
            </tbody>
            <thead>
                <tr>
                    <th>No</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<operator> ii = (Iterator<operator>) request.getAttribute("daftar_user");
                int nom = 0;
                while(ii.hasNext()){
                    operator io= ii.next();
                    no++;
                %>
                
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(io.getNameOp())%></td>
                    <td><%=(io.getAddressOp())%></td>
                     <td><a href="editOperator">Edit</a></td>
                    <td><a href="deleteOperator">Delete</a></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </body>
   
</html>
