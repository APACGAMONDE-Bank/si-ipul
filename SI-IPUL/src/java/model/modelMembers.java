package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class modelMembers {

    Connection conn;
    public modelMembers (Connection conn) {
        this.conn = conn;
    }

    public List<members> getAllUsers() throws Exception {
        List<members> members = new ArrayList<members>();
        String sql = "SELECT * FROM members";
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                members mem = new members();
                mem.setUsernameMb(rs.getString(1));
                mem.setNameMb(rs.getString(2));
                mem.setAddressMb(rs.getString(3));
                mem.setHandphoneMb(rs.getInt(4));
                mem.setEmailMb(rs.getString(5));
                members.add(mem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }

    public members getUser(String email) {
        members mem = new members();
        String sql = "SELECT * FROM mem WHERE EMAIL = ?";
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    mem.setUsernameMb(rs.getString(1));
                    mem.setNameMb(rs.getString(2));
                    mem.setAddressMb(rs.getString(3));
                    mem.setHandphoneMb(rs.getInt(4));
                    mem.setEmailMb(rs.getString(5));
                   }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mem;
    }

    public void insertUser(String username, String name, String address, int handphone, String email) throws Exception {
        String sql = "INSERT INTO members VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, name);
            st.setString(3, address);
            st.setInt(4, handphone);
            st.setString(5, email);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String username, String name, String address, int handphone, String email) throws Exception {
        String sql = "UPDATE members SET usernameMb=?, nameMb=?, addressMb=?, handphoneMb=?, emailMb=? WHERE usernameMb=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, name);
            st.setString(3, address);
            st.setInt(4, handphone);
            st.setString(5, email);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int usernameMb) {

        String sql = "DELETE FROM members WHERE usernameMb = ?";
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);
            st.setInt(1, usernameMb);

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
