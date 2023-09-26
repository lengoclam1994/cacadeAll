package com.example.demo.repository;

import com.example.demo.entity.Computer;
import com.example.demo.entity.ComputerExposed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    @Query("Select new com.example.demo.entity.ComputerExposed(i.id, c.name, c.warrantyDuration, c.price, i.quantity, b.name, b.id, c.id) " +
            "from Computer c inner join c.inventory i inner join i.branch b")
    List<ComputerExposed> find();

    Computer findByName(String name);

    @Query("select new Computer(c.id, c.name) from Computer c where c.id = ?1")
    Computer getComputerById(Long computerId);
}
