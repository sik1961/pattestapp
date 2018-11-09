package com.sik.pattest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="pattest", name="testresults", catalog="")
public class TestResult {

    private static final Integer CLASS_1 = 1;
    private static final Integer CLASS_2 = 2;

    @Id
    @Column(unique=true, nullable=false)
    private String id;

    @Column(name="date", nullable=false)
    private Date testDate;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="assetid", nullable=false)
    private String assetid;

    @Column(name="site", nullable=false)
    private String site;

    @Column(name="assetclass", nullable=false)
    private Integer assetClass;

    @Column(name="visualpass", nullable=false)
    private String visualPass;

    @Column(name="fuserating", nullable=false)
    private Integer fuseRating;

    @Column(name="earthbondohms")
    private Double earthBondOhms;

    @Column(name="insulationmohms")
    private Double insulationMegaOhms;

    @Column(name="leakagemilliamps")
    private Double leakageMilliAmps;

    @Column(name="polaritypass")
    private String polarityPass;

    @Column(name="overallPass", nullable=false)
    private String overallPass;

    @Column
    private String remarks;

    @Column(name="customerid")
    public String customerId;

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
        private String visualPass;
        private Integer fuseRating;
        private Double earthBondOhms;
        private Double insulationMegaOhms;
        private Double leakageMilliAmps;
        private String polarityPass;
        private String overallPass;
        private String remarks;
        private String customerId;

        public Builder() {
            this.id = UUID.randomUUID().toString();
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
        public Builder visualPass(String visualPass){
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
        public Builder polarityPass(String polarityPass){
            this.polarityPass = polarityPass;
            return this;
        }
        public Builder overallPass(String overallPass){
            this.overallPass = overallPass;
            return this;
        }
        public Builder remarks(String remarks){
            this.remarks = remarks;
            return this;
        }
        public Builder customerId(String customerId){
            this.customerId = customerId;
            return this;
        }
        public TestResult build(){
            TestResult testResult = new TestResult();
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
            testResult.customerId = this.customerId;
            return this.ifValid(testResult);
        }
        private TestResult ifValid(TestResult testResult) {
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
            if (testResult.customerId == null) {
                throw new IllegalArgumentException("Class 1: Customer Id may not be null");
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
            return testResult;
        }
    }
}
