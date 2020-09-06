package com.sapient.dtcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.dtcspring.model.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

}
