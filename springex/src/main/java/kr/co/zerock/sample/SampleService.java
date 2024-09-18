package kr.co.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.ToString;

@Service
@ToString
public class SampleService {
	@Autowired
	private SampleDAO sampleDAO;
}
