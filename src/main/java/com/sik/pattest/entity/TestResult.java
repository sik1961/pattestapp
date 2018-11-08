package com.sik.pattest.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(schema="pattest", name="testresults", catalog="")
public class TestResult {

    private static final Integer CLASS_1 = 1;
    private static final Integer CLASS_2 = 2;

    @Column(unique=true, nullable=false)
    private String id;

    @Column(name="date", nullable=false)
    private Date testDate;

    @Column(name="assetid", nullable=false)
    private String assetid;

    @Column(name="site", nullable=false)
    private String site;

    @Column(name="assetclass", nullable=false)
    private Integer assetClass;

    @Column(name="visualpass", nullable=false)
    private PassFail visualPass;

    @Column(name="fuserating", nullable=false)
    private Integer fuseRating;

    @Column(name="earthbondohms")
    private Double earthBondOhms;

    @Column(name="insulationmohms")
    private Double insulationMegaOhms;

    @Column(name="leakagemilliamps")
    private Double leakageMilliAmps;

    @Column(name="polaritypass")
    private PassFail polarityPass;

    @Column(name="overallPass", nullable=false)
    private PassFail overallPass;

    @Column
    private String remarks;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="customerid")
    public Customer customer;

    public TestResult(String id) {
        this.id = id;
    }

    /**
     * Custom builder to incorporate object validation
     */
    public static class Builder {
        private String id;
        private Date testDate;
        private String assetid;
        private String site;
        private Integer assetClass;
        private PassFail visualPass;
        private Integer fuseRating;
        private Double earthBondOhms;
        private Double insulationMegaOhms;
        private Double leakageMilliAmps;
        private PassFail polarityPass;
        private PassFail overallPass;
        private String remarks;
        private Customer customer;
        public Builder(String id) {
            this.id = id;
        }
        public Builder testDate(Date testDate){
            this.testDate = testDate;
            return this;
        }
        public Builder assetId(String assetId){
            this.assetid = assetId;
            return this;
        }
        public Builder site(String site){
            this.site = site;
            return this;
        }
        public Builder assetClass(Integer assetClass){
            this.assetClass = assetClass;
            return this;
        }
        public Builder visualPass(PassFail visualPass){
            this.visualPass = visualPass;
            return this;
        }
        public Builder fuseRating(Integer fuseRating){
            this.fuseRating = fuseRating;
            return this;
        }
        public Builder earthBondOhms(Double earthBondOhms){
            this.earthBondOhms = earthBondOhms;
            return this;
        }
        public Builder insulationMegaOhms(Double insulationMegaOhms){
            this.insulationMegaOhms = insulationMegaOhms;
            return this;
        }
        public Builder leakageMilliAmps(Double leakageMilliAmps){
            this.leakageMilliAmps = leakageMilliAmps;
            return this;
        }
        public Builder polarityPass(PassFail polarityPass){
            this.polarityPass = polarityPass;
            return this;
        }
        public Builder overallPass(PassFail overallPass){
            this.overallPass = overallPass;
            return this;
        }
        public Builder remarks(String remarks){
            this.remarks = remarks;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }
        public TestResult build(){
            TestResult testResult = new TestResult(this.id);
            testResult.testDate = this.testDate;
            testResult.assetid = this.assetid;
            testResult.site = this.site;
            testResult.assetClass = this.assetClass;
            testResult.visualPass = this.visualPass;
            testResult.fuseRating = this.fuseRating;
            testResult.earthBondOhms = this.earthBondOhms;
            testResult.insulationMegaOhms = this.insulationMegaOhms;
            testResult.leakageMilliAmps = this.leakageMilliAmps;
            testResult.polarityPass = this.polarityPass;
            testResult.overallPass = this.overallPass;
            testResult.remarks = this.remarks;
            testResult.customer = this.customer;
            return this.isValid(testResult) ? testResult : null;
        }
        private boolean isValid(TestResult testResult) {
            if (testResult.testDate == null) {
                throw new IllegalArgumentException("Class 1: Test Date may not be null");
            }
            if (testResult.assetid == null) {
                throw new IllegalArgumentException("Class 1: Asset Id may not be null");
            }
            if (testResult.assetClass == null) {
                throw new IllegalArgumentException("Class 1: Asset Class may not be null");
            }
            if (testResult.visualPass == null) {
                throw new IllegalArgumentException("Class 1: Visual Pass may not be null");
            }
            if (testResult.fuseRating == null) {
                throw new IllegalArgumentException("Class 1: Fuse Rating may not be null");
            }
            if (testResult.customer == null) {
                throw new IllegalArgumentException("Class 1: Customer may not be null");
            }
            if (testResult.overallPass == null) {
                throw new IllegalArgumentException("Class 1: Overall Pass may not be null");
            }
            if (testResult.assetClass == CLASS_1) {
                if (testResult.earthBondOhms == null) {
                    throw new IllegalArgumentException("Class 1: Earth Bond Ohms may not be null");
                }
                if (testResult.leakageMilliAmps == null) {
                    throw new IllegalArgumentException("Class 1: Leakage mA may not be null");
                }
            } else if (testResult.assetClass == CLASS_2) {
                if (testResult.insulationMegaOhms == null) {
                    throw new IllegalArgumentException("Class 2: Insulation MOhms may not be null");
                }
            }
            return true;
        }
    }
}
