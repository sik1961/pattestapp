package com.sik.thymeleaf.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(schema="pattest", name="customer", catalog="")
public class Customer {

    @Column(unique=true, nullable=false)
    private String id;

    @Column
    private String contact;

    @Column
    private String name;
}
