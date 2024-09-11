package kr.co.zerock.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	
	private String mid;
	private String mpw;
	private String mname;
}
