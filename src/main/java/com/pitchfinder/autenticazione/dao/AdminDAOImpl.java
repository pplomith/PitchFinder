package com.pitchfinder.autenticazione.dao;

import com.pitchfinder.autenticazione.entity.Admin;
import com.pitchfinder.singleton.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {

    /**
     * Constant for index number 1.
     */
    private static final int INDEX1 = 1;

    /**
     * Constant for index number 1.
     */
    private static final int INDEX2 = 2;

    /**
     * Constant for index number 1.
     */
    private static final int INDEX3 = 3;

    /**
     * Constant for index number 4.
     */
    private static final int INDEX4 = 4;

    /**
     * This method checks weather the subject who is trying to access
     * is a registered admin.
     * @param admin is the admin who is logging in
     * @return boolean
     */
    public Admin checkAdmin(Admin admin) {

        try (Connection con = ConPool.getInstance().getConnection()) {

            int nAdmin = checkAdminExistence(admin);

            PreparedStatement ps = con.prepareStatement(
                    "select * from Admin where Username=?");
            ps.setString(INDEX1, admin.getUsername());

            if (nAdmin == 1) {

                ResultSet rs = ps.executeQuery();
                rs.next();

                if (rs.getString(INDEX4).
                        equalsIgnoreCase(admin.getPasswordHash())) {
                    admin.setNome(rs.getString(INDEX2));
                    admin.setCognome(rs.getString(INDEX3));

                    return admin;
                } else {
                    throw new IllegalArgumentException("Il login non va a buon "
                            + "fine perché la password inserita non è corretta");
                }

            } else {
                return null;
            }

        } catch (SQLException e) {

            return null;
        }
    }

    private int checkAdminExistence(Admin admin) {

        try (Connection con = ConPool.getInstance().getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "select count(*) from Admin where Username=?");
            ps.setString(INDEX1, admin.getUsername());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(INDEX1);
            }

        } catch (SQLException e) {
            return 0;
        }

        return -1;
    }
}
