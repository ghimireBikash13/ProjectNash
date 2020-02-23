package com.nash.service;

import java.sql.Connection;
import java.sql.Statement;

import com.nash.db.DbUtility;
import com.nash.patient.model.PatientInfo;

public class PatientService {
	public void savePatientInfo(PatientInfo pat) throws Exception {

		Connection con = DbUtility.getConnection();
		Statement stm = con.createStatement();
		String sql = "insert into patient(name, address, age, dob, phone) values('" + pat.getName() + "','"
				+ pat.getAddress() + "','" + pat.getAge() + "','" + pat.getdOB() + "','" + pat.getPhone() + "')";
		stm.executeUpdate(sql);

	}

}
