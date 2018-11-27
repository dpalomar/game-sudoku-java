package com.ebay.epd.sudoku.resource;

import com.ebay.epd.sudoku.game.util.SudokuValidationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(BoardResource.class);
		register(SudokuValidationExceptionMapper.class);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}
}
