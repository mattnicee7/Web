package com.github.mattnicee7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mattnicee7.entities.pk.OrderItemPK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;

    private Double price;

    public OrderItem(Order order, Product product, Integer quantity) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
