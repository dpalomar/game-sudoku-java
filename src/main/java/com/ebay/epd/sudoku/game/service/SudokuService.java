package com.ebay.epd.sudoku.game.service;

import com.ebay.epd.sudoku.game.domain.Board;
import com.ebay.epd.sudoku.game.util.SudokuValidationException;

public interface SudokuService {
    Board getNewBoard();

    Board getBoard(String id);

    void validateBoard(Board b) throws SudokuValidationException;
}
