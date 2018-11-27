package com.ebay.epd.sudoku.game.domain;

import com.ebay.epd.sudoku.game.service.BoardState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class Board {

    @NotNull
    private String id;

    @NotNull
    private Integer[][] fields;


    public String dealsLink;
    private BoardState state = BoardState.VALID;


}
