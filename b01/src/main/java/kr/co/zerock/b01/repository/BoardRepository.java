package kr.co.zerock.b01.repository;

import kr.co.zerock.b01.domain.Board;
import kr.co.zerock.b01.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    Page<Board> findByTitleContainingOrderByBnoDesc(String keyword, Pageable pageable);

    @Query("select b from Board b where b.title like concat('%', :keyword, '%')")
    Page<Board> findKeyword(String keyword, Pageable pageable);

    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
