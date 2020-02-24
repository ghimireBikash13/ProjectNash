package com.nash.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nash.db.DbUtility;
import com.nash.patient.model.PatientInfo;

public class PatientListInfo {
	
	public List<PatientInfo>  getPatientInfo() throws SQLException {

		Connection con = DbUtility.getConnection();
		Statement st = con.createStatement();
		String sql = "Select * from patient";
		ResultSet rs = st.executeQuery(sql);
		List<PatientInfo> patients = new ArrayList<PatientInfo>();
		
		while (rs.next()) {
			PatientInfo pin1 = new PatientInfo();
			pin1.setName(rs.getString("name"));

			pin1.setAddress(rs.getString("address"));

			pin1.setAge(rs.getString("age"));

			pin1.setdOB(rs.getString("dOB"));
			patients.add(pin1);

		}
		return patients;
	}

}
