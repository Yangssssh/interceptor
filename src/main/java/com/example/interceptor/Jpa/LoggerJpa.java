package com.example.interceptor.Jpa;

import com.example.interceptor.Entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJpa extends JpaRepository<LoggerEntity,Long> {
}
