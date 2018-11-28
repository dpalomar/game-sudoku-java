package com.ebay.epd.sudoku.game.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InvalidFieldError {

	private int x;
	private int y;


}
