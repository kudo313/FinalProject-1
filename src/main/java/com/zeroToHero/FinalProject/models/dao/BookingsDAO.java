package com.zeroToHero.FinalProject.models.dao;

import com.zeroToHero.FinalProject.database.DBConnectionManager;
import com.zeroToHero.FinalProject.database.queries.mainQueries.BookingsQuery;
import com.zeroToHero.FinalProject.models.beans.Bookings;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class BookingsDAO {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private Statement st = null;
    private ResultSet rs = null;

    public void bookings(Bookings newBooking)
    {
        try {
            conn = DBConnectionManager.getConnection();
            pst = conn.prepareStatement((BookingsQuery.insertBooking));

            pst.setString(1, newBooking.getUserId());
            pst.setLong(2, newBooking.getTourId());
            pst.setDate(3, newBooking.getStartDate());
            pst.setDate(4, newBooking.getEndDate());
            pst.setString(5, newBooking.getPrice());

            System.out.println(newBooking.getUserId());
            System.out.println(newBooking.getTourId());
            System.out.println(newBooking.getStartDate());
            System.out.println(newBooking.getEndDate());
            System.out.println(newBooking.getPrice());

            pst.executeUpdate();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            DBConnectionManager.closeConnection(conn, pst, rs);
        }
    }

    public ArrayList<Bookings> getBookingsByUserId(String userId)
    {
        ArrayList<Bookings> result = new ArrayList<>();
        try {
            conn = DBConnectionManager.getConnection();
            pst = conn.prepareStatement(BookingsQuery.getBookingsByUserId);
            pst.setString(1, userId);
            rs = pst.executeQuery();

            while (rs.next())
            {
                Bookings temp = new Bookings();
                temp.setBookingId(rs.getLong("booking_id"));
                temp.setTourId(rs.getLong("tour_id"));
                temp.setUserId(rs.getString("user_id"));
                temp.setCreatedAt(rs.getTimestamp("created_at"));
                temp.setStartDate(rs.getDate("start_date"));
                temp.setEndDate(rs.getDate("end_date"));
                temp.setPrice(rs.getString("price"));

                result.add(temp);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            DBConnectionManager.closeConnection(conn, pst, rs);
        }

        return result;
    }
}
