package com.arkaitzgarro.factories;

import com.arkaitzgarro.googleplex.Company;

public abstract class CompanyFactory {
	
	public static Company getNewCompany(String name, short size) {
		Company c = new Company(name, size);
		
		return c;
	}
}
