package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ParkingDAO {

    public void saveAllocation(String vehicle, int slot) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO parking VALUES (?,?)");
        ps.setString(1, vehicle);
        ps.setInt(2, slot);
        ps.executeUpdate();
        con.close();
    }
}
