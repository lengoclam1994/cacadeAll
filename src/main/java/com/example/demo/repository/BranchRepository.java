package com.example.demo.repository;

import com.example.demo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("select new Branch(b.id, b.name) from Branch b where b.id = ?1 and b.name = ?2")
    Branch getBranchByIdAndName(Long branchId, String name);
}
