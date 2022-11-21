package com.example.homework.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basket")
    private List<BasketProduct> basketProducts;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "basket_products",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Basket basket = (Basket) o;
        return id != null && Objects.equals(id, basket.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
