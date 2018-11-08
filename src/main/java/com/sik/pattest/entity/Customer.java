package com.sik.pattest.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="pattest", name="customers", catalog="")
public class Customer {

    @Id
    @Column(unique=true, nullable=false)
    private String id;

    @Column
    private String contact;

    @Column
    private String name;
}
