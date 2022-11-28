package com.nikitoe.board.service;

import com.nikitoe.board.dto.ReplySaveRequestDto;
import com.nikitoe.board.model.Board;
import com.nikitoe.board.model.Reply;
import com.nikitoe.board.model.User;
import com.nikitoe.board.repository.BoardRepository;
import com.nikitoe.board.repository.ReplyRepository;
import com.nikitoe.board.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void writePost(Board board, User user) {
        board.setUser(user);
        boardRepository.save(board);
    }

    public Page<Board> getPostList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board getPost(long id) {
        return boardRepository.findById(id)
            .orElseThrow(
                () -> new IllegalArgumentException("Failed to load post : cannot find post id"));
    }

    @Transactional
    public void deletePost(long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updatePost(long id, Board requestBoard) {
        Board board = boardRepository.findById(id)
            .orElseThrow(
                () -> new IllegalArgumentException("Failed to load post : cannot find post id"));
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());

    }

    @Transactional
    public void writeReply(ReplySaveRequestDto replyDto){
        Board board = boardRepository.findById(replyDto.getBoardId())
            .orElseThrow(()-> new IllegalArgumentException("Failed to write reply : cannot find post id"));

        User user = userRepository.findById(replyDto.getUserId())
            .orElseThrow(()-> new IllegalArgumentException("Failed to write reply : cannot find post id"));

        Reply reply = Reply.builder()
            .user(user)
            .board(board)
            .content(replyDto.getContent())
            .build();

        replyRepository.save(reply);
    }

    @Transactional
    public void deleteReply(long replyId){replyRepository.deleteById(replyId);}

}
