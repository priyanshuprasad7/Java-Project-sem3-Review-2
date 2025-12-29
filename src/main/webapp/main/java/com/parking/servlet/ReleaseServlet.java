package com.parking.servlet;

import com.parking.service.ParkingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReleaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String vehicleNumber = req.getParameter("number");

        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            resp.getWriter().println("Vehicle number required");
            return;
        }

        try {
            ParkingService service = new ParkingService();
            boolean released = service.release(vehicleNumber);

            if (released) {
                resp.getWriter().println(
                        "Parking slot released for vehicle: " + vehicleNumber
                );
            } else {
                resp.getWriter().println("Vehicle not found");
            }

        } catch (Exception e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
