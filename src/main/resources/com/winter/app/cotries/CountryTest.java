package com.winter.app.test.coutries;

import com.winter.app.countries.CountryDAO;

public class CountryTest {

	public static void main(String[] args) {
		CountryDAO countryDAO = new CountryDAO();
		
		try {
			countryDAO.detail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
