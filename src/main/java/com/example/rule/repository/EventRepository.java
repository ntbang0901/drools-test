package com.example.rule.repository;

import com.example.rule.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Object> {
}
