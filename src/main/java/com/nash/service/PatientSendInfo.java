package com.nash.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nash.db.DbUtility;
import com.nash.patient.model.PatientInfo;

public class PatientSendInfo {
	public PatientInfo getPatientInfo(String id) throws Exception {

		Connection con = DbUtility.getConnection();

		Statement st = con.createStatement();

		String sql = "Select * from patient where id= " + id;

		ResultSet rs = st.executeQuery(sql);

		PatientInfo pti = new PatientInfo();
		while (rs.next()) {
			int CutId = rs.getInt("id");

			pti.setName(rs.getString("name"));

			pti.setAddress(rs.getString("address"));

			pti.setAge(rs.getString("age"));

			pti.setdOB(rs.getString("dOB"));

			pti.setPhone(rs.getString("phone"));

		}
		return pti;

	}

}
