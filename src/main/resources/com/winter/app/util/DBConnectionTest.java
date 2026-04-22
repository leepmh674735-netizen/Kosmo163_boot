package com.winter.app.test.util;

import java.sql.Connection;

import com.winter.app.countries.CountryDAO;
import com.winter.app.departments.DepartmentDAO;
import com.winter.app.util.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		CountryDAO countryDAO = new CountryDAO();
		try {
			countryDAO.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}