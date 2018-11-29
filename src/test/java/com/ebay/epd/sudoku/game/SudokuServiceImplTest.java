package com.ebay.epd.sudoku.game;

import com.ebay.epd.sudoku.game.domain.Board;
import com.ebay.epd.sudoku.game.service.BoardLogic;
import com.ebay.epd.sudoku.game.service.BoardState;
import com.ebay.epd.sudoku.game.service.SudokuServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SudokuServiceImplTest.Config.class, SudokuServiceImpl.class})
public class SudokuServiceImplTest {

    @Autowired
    private BoardLogic mockValidator;

    @Autowired
    private SudokuServiceImpl service;

    @Test
    public void shouldNotAddLinkWhenNotCompleted() throws Exception {
        Board board = new Board();
        when(mockValidator.isValid(any())).thenReturn(BoardState.VALID);
        service.validateBoard(board);
        assertThat(board.dealsLink, is(nullValue()));
    }

    @Test
    public void shouldAddLinkWhenCompleted() throws Exception {
        Board board = new Board();
        when(mockValidator.isValid(any())).thenReturn(BoardState.COMPLETED);
        service.validateBoard(board);
        assertThat(board.dealsLink, is("https://www.ebay.co.uk/deals"));
    }

    @Configuration
    public static class Config {
        @Bean
        public BoardLogic validator() {
            return Mockito.mock(BoardLogic.class);
        }
    }
}