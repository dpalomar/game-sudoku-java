package com.ebay.epd.sudoku.game.web;

import com.ebay.epd.sudoku.game.domain.Board;
import com.ebay.epd.sudoku.game.service.SudokuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardResource {

	private final SudokuService service;

	@GetMapping
	public Board getBoard() {
		return service.getNewBoard();
	}


	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Board getBoard(@PathVariable("id") String id) {
		return service.getBoard(id);
	}


	@RequestMapping(value = "/validate", method = RequestMethod.PUT)
	public Response validateBoard(@Valid Board b) throws Exception {
		service.validateBoard(b);
		return Response.ok(b).build();
	}
}
