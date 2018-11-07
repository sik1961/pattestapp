package com.sik.thymeleaf.repository;

import com.sik.thymeleaf.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultsRepository extends JpaRepository<TestResult, String> {
}
