package com.ebay.epd.sudoku.game.web;

import com.ebay.epd.sudoku.game.util.SudokuValidationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;


public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(BoardResourceController.class);
		register(SudokuValidationExceptionMapper.class);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}
}
