package com.sparta.spartawebspringtest.repository;

import com.sparta.spartawebspringtest.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
