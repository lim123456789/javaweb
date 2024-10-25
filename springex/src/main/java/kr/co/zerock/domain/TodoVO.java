package kr.co.zerock.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TodoVO {
	private long tno;
	private String title;
	private LocalDate dueDate;
	private String writer;
	private boolean finished;
}
