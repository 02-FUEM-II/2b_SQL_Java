package com.cc.java;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;

import java.sql.*;


public class App 
{
    // Argumente für Connection-Parameter
    static String conURL = "jdbc:mysql://139.162.146.108:3306/mydb";
    static String usrStr = "remote_user";
    static String usrPwd = "xAcb12#rem0te!";

    static Connection con;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        
      try {
        
        // Load SQL Server JDBC driver and establish connection.
        System.out.print("Connecting to SQL Server ... ");

        try (Connection con = DriverManager.getConnection(conURL, usrStr, usrPwd)) {

            System.out.println("Success!");  
            System.out.println(con);

             // Creating a statement object
             Statement stmt = con.createStatement();

             // Executing the query and storing the result in a ResultSet object
            //  ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.employees");
             ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.employees WHERE id = 2");
             System.out.println(rs);

            // Iterating through the ResultSet and printing the contents
            while (rs.next()) {

                // fetch
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                int age = rs.getInt("age");
                int salary = rs.getInt("annual_salary");
                String employee_id = rs.getString("employee_id");

                // print
                String printStr =   "ID: " + employee_id +
                                    ", Name: " + surname + " " + name +
                                    ", Salary: " + salary +
                                    ", Age: " + age;

                System.out.println(printStr);
            }

            // Objekte schließen
            rs.close();
            stmt.close();
            con.close();
         
            
        } catch (Exception e) {
            e.printStackTrace();
        }

      } catch (Exception e) {
        e.printStackTrace();
      }


    }
    
}

