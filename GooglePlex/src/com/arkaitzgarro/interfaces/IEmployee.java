package com.arkaitzgarro.interfaces;

public interface IEmployee {
	public void setName(String name);
	public String getName();
	public void setSalary(float salary);
	public float getSalary();
	public void raiseSalary(int raise);
	public short getEmployeeId();
	public void fire();
	public ICompany getCompany();
}
