package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	// tell JPA to use executeUpdate() method instead executeQuery()
	@Modifying
	@Query(value="UPDATE board SET hit_count=hit_count+1 WHERE id=:id", nativeQuery=true)
	public int incrementHitCountById(@Param("id") long id);
}
