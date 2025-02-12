package kr.co.zerock.api01.repository;

import kr.co.zerock.api01.domain.APIUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIUserRepository extends JpaRepository<APIUser, String> {

}
