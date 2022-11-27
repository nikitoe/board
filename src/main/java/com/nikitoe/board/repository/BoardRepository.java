package com.nikitoe.board.repository;

import com.nikitoe.board.model.Board;
import com.nikitoe.board.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
