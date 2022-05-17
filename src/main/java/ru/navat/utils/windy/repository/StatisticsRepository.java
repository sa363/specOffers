package ru.navat.utils.windy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.navat.utils.windy.model.statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<statistics, Long> {
}
