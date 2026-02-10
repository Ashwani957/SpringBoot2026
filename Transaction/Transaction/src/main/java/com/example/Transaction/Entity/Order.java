package com.example.Transaction.Entity;



import com.fasterxml.jackson.annotation.JsonProperty;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name="order_details")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Order {

        @Id
        private int id ;
        private int productId;
        private int quantity;


        private double totalPrice;

    }
