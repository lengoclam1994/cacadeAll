package com.example.demo;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Computer;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    private final BranchRepository branchRepository;

    @Override
    public void run(String... args) throws Exception {
//        Branch branch = Branch.builder().name("Apple").build();
//        Branch branch1 = Branch.builder().name("Dell").build();
//        Branch branch2 = Branch.builder().name("HP").build();
//        branchRepository.save(branch1);
//        branchRepository.save(branch2);
//        Computer computer = Computer.builder()
//                .name("Macbook M1 Pro 2022")
//                .price(25000000L)
//                .warrantyDuration(36)
//                .build();
//        Inventory inventory = Inventory.builder()
//                .computer(computer)
//                .branch(branch)
//                .quantity(10)
//                .build();
//        inventoryRepository.save(inventory);
    }
}
