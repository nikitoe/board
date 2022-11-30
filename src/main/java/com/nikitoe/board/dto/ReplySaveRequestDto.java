package com.nikitoe.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplySaveRequestDto {
    private long userId;
    private long boardId;
    private String content;
}
