package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ParkingDAO {

    // Allocate first free slot
    public int allocate(String vehicleNumber) throws Exception {

        String selectSql =
                "SELECT slot_id FROM parking WHERE occupied = false LIMIT 1";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSql);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) {
                throw new Exception("No parking slot available");
            }

            int slotId = rs.getInt("slot_id");

            String updateSql =
                    "UPDATE parking SET occupied = true, vehicle_number = ? WHERE slot_id = ?";

            try (PreparedStatement ups = con.prepareStatement(updateSql)) {
                ups.setString(1, vehicleNumber);
                ups.setInt(2, slotId);
                ups.executeUpdate();
            }

            return slotId;
        }
    }

    // Release slot by vehicle number
    public boolean release(String vehicleNumber) throws Exception {

        String sql =
                "UPDATE parking SET occupied = false, vehicle_number = NULL WHERE vehicle_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vehicleNumber);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
