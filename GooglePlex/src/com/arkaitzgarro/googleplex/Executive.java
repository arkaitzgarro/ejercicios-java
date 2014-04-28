package com.arkaitzgarro.googleplex;

import com.arkaitzgarro.interfaces.ICompany;
import com.arkaitzgarro.interfaces.IExecutive;

public class Executive extends Employee implements IExecutive {
	
	private float budget;

	public Executive(ICompany c, String name, float salary) {
		super(c, name, salary);
	}

	public Executive(ICompany c, String name, float salary, short id) {
		super(c, name, salary, id);
	}
	
	public float getBudget() {
		return this.budget;
	}
	
	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	@Override
	public String toString() {
		return "Executive " + super.toString();
	}
}
