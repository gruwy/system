package com.suprapartimport.system.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Data Access Interface
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.name = ?1")
    // SELECT * FROM item WHERE name = ?
    Optional<Item> findItemByName(String name);
}
