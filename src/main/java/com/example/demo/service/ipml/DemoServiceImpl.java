package com.example.demo.service.ipml;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Computer;
import com.example.demo.entity.ComputerExposed;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final ComputerRepository computerRepository;

    private final BranchRepository branchRepository;

    private final InventoryRepository inventoryRepository;

    @Override
    public List<ComputerExposed> find() {
        return computerRepository.find();
    }

    @Override
    @Transactional
    public void save(List<ComputerExposed> computerExposeds) {
        if (CollectionUtils.isEmpty(computerExposeds)) {
            throw new RuntimeException("");
        }
        List<Inventory> inventories = new ArrayList<>();
        for (ComputerExposed item: computerExposeds) {
            Branch branch = branchRepository.getBranchByIdAndName(item.getBranchId(), item.getBranchName());
            if (branch == null) throw new RuntimeException("Branch is not exist");
            Computer computer = adjustComputer(item);
            inventories.add(Inventory.builder()
                            .id((Optional.ofNullable(item.getId()).orElse(0L) != 0) ?item.getId() : null)
                            .quantity(item.getQuantity())
                            .branch(branch)
                            .computer(computer)
                            .build());
        }
        inventoryRepository.saveAll(inventories);
    }

    private Computer adjustComputer(ComputerExposed item) {
        Computer computer = Computer.builder()
                .price(item.getPrice())
                .warrantyDuration(item.getWarrantyDuration())
                .name(item.getComputerName())
                .build();
        if(item.getComputerId() == null || item.getComputerId().equals(0L)) {
            return computer;
        }
        if (computerRepository.getComputerById(item.getComputerId()) == null) {
            throw new RuntimeException("Computer id : " + item.getComputerId() + " not exists");
        }
        computer.setId(item.getComputerId());
        return computer;
    }
}
