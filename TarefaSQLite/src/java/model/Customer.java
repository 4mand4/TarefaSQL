/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Fatec
 */
public class Customer {
    
    private int Id;
    private String firstName;
    private String lastName;
    
    public Customer(int customerId, String firstName, String lastName) {
        this.Id = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public static ArrayList<Customer> getList() throws Exception{
        ArrayList<Customer> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        //O caminho do arquivo deve ser diferente se executado do seu PC
        //https://www.sqlitetutorial.net/sqlite-sample-database/
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers order by FirstName");
        while(rs.next()){
            int id = rs.getInt("CustomerId");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            
            Customer a = new Customer(id, firstName, lastName);
            list.add(a);
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
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
