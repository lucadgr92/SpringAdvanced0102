package com.develhope.SpringAdvanced0102.repositories;

import com.develhope.SpringAdvanced0102.entities.MonthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<MonthEntity, Long> {
    @Query(value = "SELECT * FROM months AS m WHERE m.month_number = :monthnumber", nativeQuery = true)
    MonthEntity findByNumber (@Param("monthnumber") Integer monthNumber);
}
