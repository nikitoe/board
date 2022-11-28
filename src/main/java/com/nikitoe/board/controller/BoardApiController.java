package com.nikitoe.board.controller;

import com.nikitoe.board.config.auth.PrincipalDetail;
import com.nikitoe.board.dto.ReplySaveRequestDto;
import com.nikitoe.board.dto.ResponseDto;
import com.nikitoe.board.model.Board;
import com.nikitoe.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.writePost(board, principalDetail.getUser());
        return new ResponseDto<>(HttpStatus.OK, 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) {
        boardService.deletePost(id);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) {
        boardService.updatePost(id, board);
        return new ResponseDto<>(HttpStatus.OK, 1);
    }

    @PostMapping("/api/board/{boardId}/reply")
    public ResponseDto<Integer> saveReply(@RequestBody ReplySaveRequestDto reply){
        boardService.writeReply(reply);
        return new ResponseDto<>(HttpStatus.OK,1);
    }
    @DeleteMapping("/api/board/reply/{replyId}")
    private ResponseDto<Integer> deleteReply(@PathVariable long replyId){
        boardService.deleteReply(replyId);
        return new ResponseDto<>(HttpStatus.OK,1);
    }

}
