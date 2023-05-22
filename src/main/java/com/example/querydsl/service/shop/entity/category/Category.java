package com.example.querydsl.service.shop.entity.category;

import com.example.querydsl.service.shop.entity.product.Product;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public static Category from(long id, String name) {
        return Category.builder()
                .id(id)
                .name(name)
                .registerTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();
    }
}
