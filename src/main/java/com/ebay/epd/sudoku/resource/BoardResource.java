package com.ebay.epd.sudoku.resource;

import com.ebay.epd.sudoku.game.domain.Board;
import com.ebay.epd.sudoku.game.service.SudokuService;
import com.ebay.epd.sudoku.game.service.SudokuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Component
@Path("/board")
@Produces("application/json")
@Consumes("application/json")
public class BoardResource {

	@Autowired
	SudokuService service;

	@GET
	public Board getBoard() {
		return service.getNewBoard();
	}

	@GET
	@Path("/{id}")
	public Board getBoard(@PathParam("id") String id) {
		return service.getBoard(id);
	}

	@PUT
	@Path("/validate")
	public Response validateBoard(@Valid Board b) throws Exception {
		Assert.notNull(b,"a board is mandatory to be validated");
		service.validateBoard(b);
		return Response.ok(b).build();
	}
}
