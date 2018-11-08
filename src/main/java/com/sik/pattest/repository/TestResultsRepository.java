package com.sik.pattest.repository;

import com.sik.pattest.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface TestResultsRepository extends JpaRepository<TestResult, String> {
    @Query(value = "SELECT * FROM  pattest.testresults WHERE customerid=?0",
            nativeQuery = true)
    <T extends TestResult> List<T> getTestResultsByCustomerId(String customerId);
}
