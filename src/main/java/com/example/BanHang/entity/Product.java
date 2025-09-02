package com.example.BanHang.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;
    private String image;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    private  String status;

    @Column(nullable = false)
    private Integer stock;


    //
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    //

//    @Column(name = "created_at", columnDefinition = "DATETIME2 DEFAULT SYSDATETIME()")
    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

//    @Column(name = "updated_at", columnDefinition = "DATETIME2 DEFAULT SYSDATETIME()")
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
}
