package kr.co.zerock.sample;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;

@Repository
@Qualifier("event")
public class EvenSampleDAOImpl implements SampleDAO{

}
