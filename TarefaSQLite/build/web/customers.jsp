<%-- 
    Document   : customers
    Created on : 9 de mai. de 2022, 16:21:50
    Author     : Fatec
--%>

<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Exception requestEx = null;
    ArrayList<Customer> list = new ArrayList<>();
    int count = 0;
    try{
        list = Customer.getList();
    }catch(Exception e){
        requestEx = e;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <h1>Customers</h1>
        
        <%if(requestEx!=null){%>
        <h3 style="color: red"><%= requestEx.getMessage() %></h3>
        <%}%>
        <table border="1">
            <tr><th>id</th><th>name</th></th><th>last name</th></tr>
            <%for(Customer a: list){%>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getFirstName() %></td>
                <td><%= a.getLastName() %></td>   
            </tr>
            <%}%>
        </table>
    </body>
</html>

