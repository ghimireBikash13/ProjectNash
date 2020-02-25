package com.nash.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nash.db.DbUtility;
import com.nash.patient.model.PatientInfo;

public class PatientService {

	public void savePatientInfo(PatientInfo pat) throws Exception {

		Connection con = DbUtility.getConnection();
		Statement stm = con.createStatement();
		String sql = "insert into patient(name, address, age, dob, phone) values('" + pat.getId() + "','"
				+ pat.getName() + "','" + pat.getAddress() + "','" + pat.getAge() + "','" + pat.getdOB() + "','"
				+ pat.getPhone() + "')";
		stm.executeUpdate(sql);

	}

	public PatientInfo getPatientById(String id) throws Exception {

		Connection con = DbUtility.getConnection();

		Statement st = con.createStatement();

		String sql = "Select * from patient where id= " + id;

		ResultSet rs = st.executeQuery(sql);

		PatientInfo pti = new PatientInfo();
		
		while (rs.next()) {
			int custId = rs.getInt("id");

			pti.setId(custId + "");

			pti.setName(rs.getString("name"));

			pti.setAddress(rs.getString("address"));

			pti.setAge(rs.getString("age"));

			pti.setdOB(rs.getString("dOB"));

			pti.setPhone(rs.getString("phone"));

		}
		return pti;

	}

	public List<PatientInfo> getPatientInfo() throws SQLException {

		Connection con = DbUtility.getConnection();
		Statement st = con.createStatement();
		String sql = "Select * from patient";
		ResultSet rs = st.executeQuery(sql);
		List<PatientInfo> patients = new ArrayList<PatientInfo>();

		while (rs.next()) {
			PatientInfo pin1 = new PatientInfo();
			pin1.setId(rs.getString("id"));

			pin1.setName(rs.getString("name"));

			pin1.setAddress(rs.getString("address"));

			pin1.setAge(rs.getString("age"));

			pin1.setdOB(rs.getString("dOB"));

			pin1.setPhone(rs.getString("phone"));

			patients.add(pin1);

		}
		return patients;
	}

	public PatientInfo updateNashPatient(PatientInfo pal) throws Exception {
		Connection con = DbUtility.getConnection();
		Statement st = con.createStatement();
		String sql = "update patient set name= '" + pal.getName() + "', address='" + pal.getAddress() + "', age='"
				+ pal.getAge() + "', dOB='" + pal.getdOB() + "',phone='" + pal.getPhone() + "'where id=" + pal.getId() + "";
		
		st.executeUpdate(sql);

		return pal;
	}
}
