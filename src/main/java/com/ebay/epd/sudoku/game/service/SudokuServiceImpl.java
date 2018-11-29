package com.ebay.epd.sudoku.game.service;

import com.ebay.epd.sudoku.game.util.SudokuValidationException;
import com.ebay.epd.sudoku.game.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SudokuServiceImpl implements SudokuService {

    @Autowired
    BoardLogic boardLogic;

//FIXME: static objects are dangerous in a concurrent context and must be removed. If it was necessary then considerate a light memory database or filesystem per user
    static Map<String, Board> boards = new HashMap<>();

    @Override
    public Board getNewBoard() {
        Board newBoard = boardLogic.generateBoard();
        boards.put(newBoard.getId(), newBoard);

        return newBoard;
    }

    @Override
    public Board getBoard(String id) {
        return boards.get(id);
    }

    @Override
    public void validateBoard(Board b) throws SudokuValidationException {
        BoardState state = boardLogic.isValid(b);
        b.setState(state);
        if (state == BoardState.COMPLETED) {
            b.setDealsLink("https://www.ebay.co.uk/deals");
        }
        boards.put(b.getId(), b);
    }
}
