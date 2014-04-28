package com.arkaitzgarro.interfaces;

public interface ICompany {
	public String getName();
	public short getSize();
	public IEmployee getEmployee(short id);
	public void fireEmploye(short id);
	public IEmployee newEmployee(String name, float salary);
	public void setEmployee(IExecutive ex);
}
