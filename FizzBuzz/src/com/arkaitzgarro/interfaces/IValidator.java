/**
 * 
 */
package com.arkaitzgarro.interfaces;

import com.arkaitzgarro.exception.NumberNotValidException;

/**
 * @author arkaitz
 *
 */
public interface IValidator {
	public boolean validate(int num) throws NumberNotValidException;
	public String getOutput();
	public void setOutput(String output);
}
