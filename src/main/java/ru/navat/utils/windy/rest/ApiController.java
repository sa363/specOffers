package ru.navat.utils.windy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.navat.utils.windy.enums.BusinessSportEnum;
import ru.navat.utils.windy.enums.BusinessTypeEnum;
import ru.navat.utils.windy.exceptions.ResourceNotFoundException;
import ru.navat.utils.windy.model.Count;
import ru.navat.utils.windy.model.SpecialOffers;
import ru.navat.utils.windy.repository.SpecialofferRepository;
import ru.navat.utils.windy.service.AddRecordOfferViews;
import ru.navat.utils.windy.service.AddRecordStatistic;
import ru.navat.utils.windy.service.SpecialOfferService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Copyright © LLC NAVAT, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sergey Anisimov <sa@navat.ru>, 22 Январь 2018
 **/

@RestController
@RequestMapping("/api/offer")
public class ApiController {

    @Autowired
    private final SpecialofferRepository specialofferRepository;

    @Autowired
    private AddRecordStatistic addRecordStatistic;

    @Autowired
    private AddRecordOfferViews addRecordOfferViews;

    @Autowired
    private SpecialOfferService service;


    public ApiController(SpecialofferRepository specialofferRepository) {
        this.specialofferRepository = specialofferRepository;
    }


//    @GetMapping(value = "/")
//    Iterable<SpecialOffers> getOffers() {
//        return this.specialofferRepository.findAll();
//    }

    @GetMapping(value = "/{id}")
    public SpecialOffers getOffers(@PathVariable Long id) {
        return specialofferRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Offer [offerId="+id+"] can't be found"));
    }

    @GetMapping(value = "/user/{userId}")
    public Iterable<SpecialOffers> getOffers(@PathVariable String userId) {
        return this.specialofferRepository.getByBusinessIdOrUserId(userId, userId);
    }
    @GetMapping(value = "/user")
    public Iterable<SpecialOffers> getByUserId(@RequestParam("id") String userId) {
        Integer page=0;
        Integer size=100;
        Pageable topTen = new PageRequest(page, size);
        return this.specialofferRepository.getByBusinessIdOrUserId(userId, userId, topTen);
    }

    @GetMapping(value = "/q")
    public Iterable<SpecialOffers> getOffers(@RequestParam("lon") Double lon,
                                             @RequestParam("lat") Double lat,
                                             @RequestParam("radius") Double radius,
                                             @RequestParam(value = "businessSports", required = false)List<BusinessSportEnum> businessSports,
                                             @RequestParam(value = "businessTypes", required = false)List<BusinessTypeEnum> businessTypes,
                                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                             @RequestParam(value = "userID", required = false) String userID,
                                             @RequestParam(value = "ulat", required = false) Double ulat,
                                             @RequestParam(value = "ulon", required = false) Double ulon,
                                             HttpServletRequest request){

        Pageable topTen = new PageRequest(page, size);
        addRecordStatistic.addRecord(lat, lon, radius, request.getRemoteAddr().toUpperCase(), request.getHeader("User-Agent"), userID, ulat, ulon);
        return this.specialofferRepository.q(lat,lon,radius,businessSports, businessTypes, topTen);
    }

    @GetMapping(value = "/count")
    public Count countOffers(@RequestParam("lon") Double lon,
                             @RequestParam("lat") Double lat,
                             @RequestParam("radius") Double radius){
        return this.specialofferRepository.count(lat,lon,radius);
    }

    @PostMapping(value = "/updateCount/{id}")
    public ResponseEntity<SpecialOffers> updateViewsCount(@PathVariable Long id,
                                                          @RequestParam(value = "userID", required = false) String userID,
                                                          @RequestParam(value = "ulat", required = false) Double ulat,
                                                          @RequestParam(value = "spotId", required = false) Long spotId,
                                                          @RequestParam(value = "ulon", required = false) Double ulon) {
        service.updateCount(id, userID, ulat, ulon, spotId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/updateCount")
    public ResponseEntity<SpecialOffers> updateCount(@PathVariable Long id,
                                                          @RequestParam(value = "userID", required = false) String userID,
                                                          @RequestParam(value = "ulat", required = false) Double ulat,
                                                          @RequestParam(value = "spotId", required = false) Long spotId,
                                                          @RequestParam(value = "ulon", required = false) Double ulon) {
        service.updateCount(id, userID, ulat, ulon, spotId);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    ResponseEntity<?> add(@Valid @RequestBody SpecialOffers input) {

        SpecialOffers result = this.specialofferRepository.saveAndFlush(input);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getOfferId()).toUri();
        return ResponseEntity.created(location).body(result);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<SpecialOffers> patchOffer(@RequestBody SpecialOffers Updateoffer, @PathVariable Long id) {
        return specialofferRepository.findById(id).map(offer -> {
            offer=Updateoffer;
            specialofferRepository.save(offer);
            return ResponseEntity.ok(offer);
                }
                ).orElseThrow(() -> new ResourceNotFoundException());
    }

}
