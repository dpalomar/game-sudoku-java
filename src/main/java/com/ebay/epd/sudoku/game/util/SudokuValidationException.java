package com.ebay.epd.sudoku.game.util;

import com.ebay.epd.sudoku.game.InvalidFieldError;

import java.util.List;

public class SudokuValidationException extends Exception {

	List<InvalidFieldError> errors;
	
	public SudokuValidationException(List<InvalidFieldError> errors) {
		super();
		this.errors = errors;
	}
	
	public List<InvalidFieldError> getErrors() {
		return errors;
	}
}
