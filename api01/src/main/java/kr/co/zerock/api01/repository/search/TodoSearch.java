package kr.co.zerock.api01.repository.search;

import kr.co.zerock.api01.dto.PageRequestDTO;
import kr.co.zerock.api01.dto.TodoDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
