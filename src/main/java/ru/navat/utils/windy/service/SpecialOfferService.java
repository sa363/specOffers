package ru.navat.utils.windy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.navat.utils.windy.exceptions.ResourceNotFoundException;
import ru.navat.utils.windy.model.SpecialOffers;
import ru.navat.utils.windy.repository.SpecialofferRepository;

@Service
public class SpecialOfferService {

    @Autowired
    private final SpecialofferRepository specialofferRepository;

    @Autowired
    private AddRecordOfferViews addRecordOfferViews;

    public SpecialOfferService(SpecialofferRepository specialofferRepository) {
        this.specialofferRepository = specialofferRepository;
    }

    @Async
    public void updateCount(Long offerId, String userID, Double ulat, Double ulon, Long spotId) {
        specialofferRepository.findById(offerId).map(offer -> {
            offer.setViewsCount(new Long(offer.getViewsCount() + 1));
            specialofferRepository.saveAndFlush(offer);
            addRecordOfferViews.insertRecord(offerId, userID, ulat, ulon, spotId);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException());
    }



}
