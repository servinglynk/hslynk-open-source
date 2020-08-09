package com.servinglynk.hive.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcCall {
	public static void main(String args[]) {
		try {
			callStoredProc();
			callStoredProcWithParams(2, "test", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void callStoredProcWithParams(Integer reportId, String projectGroupCode, String functionName) throws ClassNotFoundException, SQLException {
		Connection c = SyncPostgresProcessor.getConnection();
		if (c != null) {
			try {
				CallableStatement stmt = c.prepareCall("{call lsa."+functionName+"(?,?)}");
				stmt.setInt(1, reportId);
				stmt.setString(2, projectGroupCode);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					// TODO: Business Logic
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void callStoredProc() throws ClassNotFoundException, SQLException {
		Connection c = SyncPostgresProcessor.getConnection();
		if (c != null) {
			try {
				CallableStatement stmt = c.prepareCall("{call LSA.fun_create_output_tables}");
				stmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
