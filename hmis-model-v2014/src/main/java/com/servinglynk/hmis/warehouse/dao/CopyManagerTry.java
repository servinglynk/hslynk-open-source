package com.servinglynk.hmis.warehouse.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class CopyManagerTry {
	public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        FileReader fr = null;

        String url = "jdbc:postgresql://hmis-v2-db.ct16elltavnx.us-west-2.rds.amazonaws.com:5432/hmis";
        String user = "hmisdb1";
        String password = "hmisdb1234";

        try {

            con = DriverManager.getConnection(url, user, password);
           
            CopyManager cm = new CopyManager((BaseConnection) con);

            fr = new FileReader("C:\\Users\\sdolia\\Downloads\\bctop10.csv");
            cm.copyIn("COPY bctop10 FROM STDIN WITH DELIMITER ',' csv header", fr);
            
        } catch (SQLException | IOException ex) {
            Logger lgr = Logger.getLogger(CopyManagerTry.class.getName());
            lgr.log(Level.INFO, ex.getMessage(), ex);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
                if (fr != null) {
                    fr.close();
                }

            } catch (SQLException | IOException ex) {
                Logger lgr = Logger.getLogger(CopyManagerTry.class.getName());
                lgr.log(Level.WARN, ex.getMessage(), ex);
            }
        }
    }
}
