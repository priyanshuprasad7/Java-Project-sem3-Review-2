package com.parking.servlet;

import com.parking.dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReleaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String vehicleNumber = req.getParameter("number");

        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            resp.getWriter().println("Vehicle number required");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM parking WHERE vehicle_number = ?"
            );
            ps.setString(1, vehicleNumber);

            int rows = ps.executeUpdate();
            con.close();

            if (rows > 0) {
                resp.getWriter().println("Parking slot released for vehicle: " + vehicleNumber);
            } else {
                resp.getWriter().println("Vehicle not found");
            }

        } catch (Exception e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
