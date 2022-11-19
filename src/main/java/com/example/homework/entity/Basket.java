package com.example.homework.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @ToString.Exclude
    private List<BasketProduct> basketProducts = new ArrayList<>();

    @OneToOne
    private User user;

    // @ManyToMany
//    @JoinTable(name = "baskets_products",
//    joinColumns = @JoinColumn(name = "basket_id"),
//    inverseJoinColumns = @JoinColumn(name = "product_id"))
    // List<Intermediate> something;
}
