package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.Assert.*;

public class AppTest {
    private Connection con;
    private Statement st;

    @Before
    public void setUp() throws Exception {
        String url = "jdbc:mysql://localhost:3306/nomandb";
        String user = "root";
        String password = "K@pathan321";
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
    }

    @After
    public void tearDown() throws Exception {
        st.executeUpdate("DELETE FROM employee WHERE EmpId IN (5, 7, 8)");
        st.close();
        con.close();
    }

    @Test
    public void testCreateEmployee() throws SQLException {
        App.createEmployee(st, 5, "John", "Doe", 30, "ZoneA");
        ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE EmpId = 5");
        assertTrue(rs.next());
        assertEquals("John", rs.getString("FirstName"));
        assertEquals("Doe", rs.getString("LastName"));
        assertEquals(30, rs.getInt("EmpAge"));
        assertEquals("ZoneA", rs.getString("EmpZone"));
    }

    @Test
    public void testReadEmployees() throws SQLException {
        App.createEmployee(st, 7, "Anthony", "Joshua", 30, "ZoneB");
        ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE EmpId = 7");
        assertTrue(rs.next());
        assertEquals("Anthony", rs.getString("FirstName"));
        assertEquals("Joshua", rs.getString("LastName"));
        assertEquals(30, rs.getInt("EmpAge"));
        assertEquals("ZoneB", rs.getString("EmpZone"));
    }

    @Test
    public void testUpdateEmployee() throws SQLException {
        App.createEmployee(st, 8, "Tyson", "Fury", 34, "ZoneC");
        App.updateEmployee(st, 8, "Tyson", "Fury Updated", 35, "ZoneD");
        ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE EmpId = 8");
        assertTrue(rs.next());
        assertEquals("Tyson", rs.getString("FirstName"));
        assertEquals("Fury Updated", rs.getString("LastName"));
        assertEquals(35, rs.getInt("EmpAge"));
        assertEquals("ZoneD", rs.getString("EmpZone"));
    }

    @Test
    public void testDeleteEmployee() throws SQLException {
        App.createEmployee(st, 5, "John", "Doe", 30, "ZoneA");
        App.deleteEmployee(st, 5);
        ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE EmpId = 5");
        assertFalse(rs.next());
    }
}
