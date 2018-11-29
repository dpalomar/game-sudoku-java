package com.ebay.epd.sudoku.game.util;

import java.util.List;

public class SudokuValidationException extends Exception {

	private List<InvalidFieldError> errors;
	
	public SudokuValidationException(List<InvalidFieldError> errors) {
		super();
		this.errors = errors;
	}
	
	public List<InvalidFieldError> getErrors() {
		return errors;
	}
}
