package com.sik.pattest.service;

import com.sik.pattest.entity.Customer;
import com.sik.pattest.entity.TestResult;
import com.sik.pattest.repository.CustomerRepository;
import com.sik.pattest.repository.TestResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatDataService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private TestResultsRepository testResultRepo;

    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }

    public List<TestResult> getAllTestResults() {
        return this.testResultRepo.findAll();
    }

    public Customer getCustomerById(String id) {
        return this.customerRepo.getOne(id);
    }

    public TestResult getTestResultById(String id) {
        return this.testResultRepo.getOne(id);
    }

    public List<TestResult> getTestResultsByCustomerId(String customerId) {
        return this.testResultRepo.getTestResultsByCustomerId(customerId);
    }


}
