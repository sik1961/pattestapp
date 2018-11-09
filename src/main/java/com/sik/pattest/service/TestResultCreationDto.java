package com.sik.pattest.service;

import com.sik.pattest.entity.TestResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestResultCreationDto {
    private List<TestResult> testResults;

    public void addBook(TestResult testResult) {
        this.testResults.add(testResult);
    }
}
