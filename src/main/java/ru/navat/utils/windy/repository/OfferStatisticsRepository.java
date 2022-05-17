package ru.navat.utils.windy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.navat.utils.windy.model.OfferViews;


@Repository
public interface OfferStatisticsRepository extends JpaRepository<OfferViews, Long> {
}
