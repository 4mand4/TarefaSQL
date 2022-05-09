<%-- 
    Document   : employees
    Created on : 9 de mai. de 2022, 16:21:55
    Author     : Fatec
--%>

<%@page import="model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Exception requestEx = null;
    ArrayList<Employee> list = new ArrayList<>();
    int count = 0;
    try{
        list = Employee.getList();
    }catch(Exception e){
        requestEx = e;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <h1>Lista de EmployeesC</h1>
        <%if(requestEx!=null){%>
        <h3 style="color: red"><%= requestEx.getMessage() %></h3>
        <%}%>
        <table border="1">
            <tr><th>id</th><th>name</th></th><th>last name</th></tr>
            <%for(Employee b: list){%>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getFirstName() %></td>
                <td><%= b.getLastName() %></td>   
            </tr>
            <%}%>
        </table>
    </body>
</html>


