package com.parking.servlet;

import com.parking.model.Car;
import com.parking.service.ParkingService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AllocateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String number = req.getParameter("number");
            ParkingService service = new ParkingService();
            int slot = service.park(new Car(number));
            res.getWriter().print("Allocated Slot: " + slot);
        } catch (Exception e) {
            res.getWriter().print(e.getMessage());
        }
    }
}
