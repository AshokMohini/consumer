package com.consumer.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "OrderHistory")
@Builder
@Data
@AllArgsConstructor
public class OrderHistory implements Serializable {

    public OrderHistory() {
    }

    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_id")
    @JsonProperty
    private String orderID;
    @Column(name = "order_name")
    @JsonProperty
    private String orderName;
    @Column(name = "customer_id")
    @JsonProperty
    private String customerID;
    @Column(name = "order_status")
    @JsonProperty
    private String orderStatus;
    @Column(name = "operation")
    @JsonProperty
    private String operation;
}
