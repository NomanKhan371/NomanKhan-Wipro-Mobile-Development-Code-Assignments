package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nomandb";
        String user = "root";
        String password = "K@pathan321";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement()) {

            // Create
            // createEmployee(st, 5, "John", "Doe", 44, "West");
            // createEmployee(st, 7, "Anthony", "Joshua", 30, "East");  // Use unique ID 7
            // createEmployee(st, 8, "Tyson", "Fury", 34, "MiddleEast");  // Use unique ID 8

            // Read
            readEmployees(st);
            
            // Update
            // updateEmployee(st, 5, "John", "Doe Updated", 44, "West");
            
            // Uncomment to delete an employee
            // deleteEmployee(st, 5);

            // Read again to see the changes
            // readEmployees(st);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEmployee(Statement st, int empid, String firstName, String lastName, int age, String empZone) throws SQLException {
        String query = "INSERT INTO employee (EmpId, FirstName, LastName, EmpAge, EmpZone) VALUES (" + empid + ", '" + firstName + "', '" + lastName + "', " + age + ", '" + empZone + "')";
        st.executeUpdate(query);
        System.out.println("Employee created: " + firstName + " " + lastName);
    }

    public static void readEmployees(Statement st) throws SQLException {
        String query = "SELECT * FROM employee";
        ResultSet rs = st.executeQuery(query);

        System.out.println("Employees:");
        while (rs.next()) {
            System.out.println(rs.getInt("EmpId") + ", " + rs.getString("FirstName") + ", " + rs.getString("LastName") + ", " + rs.getInt("EmpAge") + ", " + rs.getString("EmpZone"));
        }
    }

    public static void updateEmployee(Statement st, int empid, String newFirstName, String newLastName, int newAge, String newEmpZone) throws SQLException {
        String query = "UPDATE employee SET FirstName='" + newFirstName + "', LastName='" + newLastName + "', EmpAge=" + newAge + ", EmpZone='" + newEmpZone + "' WHERE EmpId=" + empid;
        st.executeUpdate(query);
        System.out.println("Employee updated: " + newFirstName + " " + newLastName);
    }

    public static void deleteEmployee(Statement st, int empid) throws SQLException {
        String query = "DELETE FROM employee WHERE EmpId=" + empid;
        st.executeUpdate(query);
        System.out.println("Employee deleted with id: " + empid);
    }
}
