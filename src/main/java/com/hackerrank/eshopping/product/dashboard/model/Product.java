package com.hackerrank.eshopping.product.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Comparator;

@Entity
public class Product implements Comparable<Product> {

    @Id
    private Long id;
    private String name;
    private String category;
    private Double retail_price;
    private Double discounted_price;
    private Boolean availability;

    public Product() {
    }

    public Product(Long id, String name, String category, Double retail_price, Double discounted_price, Boolean availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.retail_price = retail_price;
        this.discounted_price = discounted_price;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(Double retail_price) {
        this.retail_price = retail_price;
    }

    public Double getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(Double discounted_price) {
        this.discounted_price = discounted_price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public int compareTo(Product p) {
        if (this.getId() > p.getId()) {
            return 1;
        } else if (this.getId() < p.getId()) {
            return -1;
        }
        return 0;
    }

    public static Comparator<Product> SortAscByAvailabilityDiscountAndId = (p1, p2) ->  {

            if (p1.getAvailability() && p1.getAvailability()) {

                if (p1.getDiscounted_price() == p2.getDiscounted_price()) {
                    return p1.compareTo(p2);
                } else if (p1.getDiscounted_price() > p2.getDiscounted_price()) {
                    return 1;
                } else {
                    return -1;
                }

            } else if (p1.getAvailability()) {
                return -1;
            } else {
                return 1;
            }
    };
}
