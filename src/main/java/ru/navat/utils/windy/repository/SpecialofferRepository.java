package ru.navat.utils.windy.repository;


import org.hibernate.annotations.Filters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import ru.navat.utils.windy.enums.BusinessSportEnum;
import ru.navat.utils.windy.enums.BusinessTypeEnum;
import ru.navat.utils.windy.model.Count;
import ru.navat.utils.windy.model.SpecialOffers;
import ru.navat.utils.windy.model.SpecialOffers_businessSport;
import ru.navat.utils.windy.model.SpecialOffers_businessType;

import java.util.*;

@RepositoryRestResource(collectionResourceRel = "offer", path = "offer")
@Repository
public interface SpecialofferRepository extends JpaRepository<SpecialOffers, Long> {

    @RestResource(exported = false)
    SpecialOffers findByExcelNumber(@Param("number") Integer excelNumber);


    @RestResource(exported = false)
    Collection<SpecialOffers> getByUserId(@Param("userId") String userId);

    @RestResource(exported = false)
    Collection<SpecialOffers> getByBusinessId(@Param("businessId") String businessId);

    @RestResource(exported = false)
    Collection<SpecialOffers> getByBusinessIdOrUserId(@Param("businessId") String businessId, @Param("userId") String userId);

    @RestResource(exported = false)
    Page<SpecialOffers> getByBusinessIdOrUserId(@Param("businessId") String businessId, @Param("userId") String userId, Pageable pageable);


    @RestResource(exported = false)
    @Query("select t " +
            "from SpecialOffers t " +
            "where t.isActive = TRUE AND t.isVerified = TRUE AND " +
            "(6378.137 * ACOS((SIN((asin(1)*2) *   :lat/180)" +
            "* SIN((asin(1)*2) * t.businessLat/180))" +
            "+ (COS((asin(1)*2) *  :lat/180)" +
            "* COS((asin(1)*2) * t.businessLat/180)" +
            "* COS((asin(1)*2) * t.businessLon/180 - (asin(1)*2) * :lon/180)))) <= :radius " +
            "AND (CONCAT(:businessSports) is null " +
            "or (t.offerId in (SELECT DISTINCT bt.specialoffers_offerid from SpecialOffers_businessSport bt where bt.businesssport in (:businessSports))))" +
            "AND (CONCAT(:businessTypes) is null " +
            "or (t.offerId in (SELECT DISTINCT bs.specialoffers_offerid from SpecialOffers_businessType bs where bs.businesstype in (:businessTypes)))) " +
            "ORDER BY (cost+coalesce(t.discount,0)) DESC, coalesce(t.discount_pro,0) DESC, coalesce(t.discount,0) DESC, rating DESC, (6378.137 * ACOS((SIN((asin(1)*2) *   :lat/180)" +
            "* SIN((asin(1)*2) * t.businessLat/180))" +
            "+ (COS((asin(1)*2) *  :lat/180)" +
            "* COS((asin(1)*2) * t.businessLat/180)" +
            "* COS((asin(1)*2) * t.businessLon/180 - (asin(1)*2) * :lon/180)))) ASC")
    Page<SpecialOffers> q(
            @Param("lat") Double lat,
            @Param("lon") Double lon,
            @Param("radius") Double radius,
            @Param("businessSports") List<BusinessSportEnum> businessSports,
            @Param("businessTypes") List<BusinessTypeEnum> businessTypes, Pageable pageable);

    @RestResource(exported = false)
    @Query("select new ru.navat.utils.windy.model.Count(count(t.id)) " +
            "from SpecialOffers t " +
            "where  t.isActive = TRUE AND t.isVerified = TRUE AND " +
            "(6378.137 * ACOS((SIN((asin(1)*2) *   :lat/180)" +
            "* SIN((asin(1)*2) * t.businessLat/180))" +
            "+ (COS((asin(1)*2) *  :lat/180)" +
            "* COS((asin(1)*2) * t.businessLat/180)" +
            "* COS((asin(1)*2) * t.businessLon/180 - (asin(1)*2) * :lon/180)))) <= :radius ")
    Count count(
            @Param("lat") Double lat,
            @Param("lon") Double lon,
            @Param("radius") Double radius);


}
