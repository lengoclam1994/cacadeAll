package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComputerExposed {

    private Long id;

    private String computerName;

    private Integer warrantyDuration;

    private Long price;

    private Integer quantity;

    private String branchName;

    private Long branchId;

    private Long computerId;

    public ComputerExposed(Long id, String computerName, Integer warrantyDuration, Long price, Integer quantity, String branchName, Long branchId, Long computerId) {
        this.id = id;
        this.computerName = computerName;
        this.warrantyDuration = warrantyDuration;
        this.price = price;
        this.quantity = quantity;
        this.branchName = branchName;
        this.branchId = branchId;
        this.computerId = computerId;
    }
}
