package com.sapient.dtcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.dtcspring.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

}
