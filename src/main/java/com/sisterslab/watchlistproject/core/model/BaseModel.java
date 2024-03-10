package com.sisterslab.watchlistproject.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@EqualsAndHashCode
@ToString
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="createdDate")
    private Date createdDate;
    @Column(name="updatedDate")

    private Date updatedDate;

    @PrePersist
    public void onCreate(){
        this.createdDate = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedDate = new Date();
    }
}
