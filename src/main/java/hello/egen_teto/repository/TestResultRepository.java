package hello.egen_teto.repository;

import hello.egen_teto.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<Result, Long> {
}
