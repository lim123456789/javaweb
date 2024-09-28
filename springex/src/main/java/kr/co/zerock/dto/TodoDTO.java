package kr.co.zerock.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
	private Long tno;
	
	private LocalDate dueDate;
	
	private boolean finished;
	
	private String writer;
}
