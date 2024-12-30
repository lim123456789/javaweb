package hello.helllo_spring.repository;

import hello.helllo_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository  extends JpaRepository<Member, Long>, MemberRepository {

    Optional<Member> findByName(String name);
}
