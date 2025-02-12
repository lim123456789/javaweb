package kr.co.zerock.api01.repository;

import kr.co.zerock.api01.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.zerock.api01.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
