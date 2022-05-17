package ru.navat.utils.windy.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.navat.utils.windy.model.OfferViews;
import ru.navat.utils.windy.repository.OfferStatisticsRepository;


@Service
public class AddRecordOfferViews {

    private static final Logger logger = LoggerFactory.getLogger(AddRecordOfferViews.class);


    @Autowired
    private OfferStatisticsRepository offerStatisticsRepository;

    public AddRecordOfferViews(OfferStatisticsRepository offerStatisticsRepository) {
        this.offerStatisticsRepository = offerStatisticsRepository;
    }

    @Async
    public void insertRecord(Long offerId, String userID, Double ulat, Double ulon, Long spotId) {
        OfferViews offerViews = new OfferViews();
        offerViews.setOfferId(offerId);
        offerViews.setUserID(userID);
        offerViews.setUlat(ulat);
        offerViews.setUlon(ulon);
        offerViews.setSpotId(spotId);
        offerStatisticsRepository.saveAndFlush(offerViews);

    }
}
