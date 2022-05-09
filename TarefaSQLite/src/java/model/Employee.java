/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Fatec
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    

    public Employee(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public static ArrayList<Employee> getList() throws Exception{
        ArrayList<Employee> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        //O caminho do arquivo deve ser diferente se executado do seu PC
        //https://www.sqlitetutorial.net/sqlite-sample-database/
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers order by FirstName");
        while(rs.next()){
            int id = rs.getInt("EmployeeId");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            
            Employee b = new Employee(id, firstName, lastName);
            list.add(b);
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
