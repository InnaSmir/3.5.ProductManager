package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Smartphone extends Product {
    private String fabricator;

    public Smartphone(int id, String name, int price, String fabricator) {
        super(id, name, price);
        this.fabricator = fabricator;
    }
}
