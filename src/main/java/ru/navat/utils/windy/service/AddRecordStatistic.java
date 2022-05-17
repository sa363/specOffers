package ru.navat.utils.windy.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.navat.utils.windy.model.statistics;
import ru.navat.utils.windy.repository.StatisticsRepository;

@Slf4j
@Service
public class AddRecordStatistic {

    private static final Logger logger = LoggerFactory.getLogger(AddRecordStatistic.class);



    @Autowired
    private final StatisticsRepository statisticsRepository;

    public AddRecordStatistic(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Async
    public void addRecord(Double lat, Double lon, Double radius, String ip, String ua, String userID, Double ulat, Double ulon) {
        statistics st = new statistics();
        st.setLat(lat);
        st.setLon(lon);
        st.setRadius(radius);
        st.setIp(ip);
        st.setUa(ua);
        st.setUserID(userID);
        st.setUlat(ulat);
        st.setUlon(ulon);
        statisticsRepository.saveAndFlush(st);
        log.debug("Adding record: " + st.toString());
    }
}
