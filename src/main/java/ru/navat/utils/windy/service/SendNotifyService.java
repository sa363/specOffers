package ru.navat.utils.windy.service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.navat.utils.windy.RestTemplate.NotifyEmail;
import ru.navat.utils.windy.model.SpecialOffers;

@Service
public class SendNotifyService {
	private static final Logger logger = LoggerFactory.getLogger(SendNotifyService.class);
	
	private final RestTemplate restTemplate;

	@Value("${notify.server.url}")
	private String url;

	public SendNotifyService(RestTemplateBuilder  restTemplateBuilder ) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Async
	public void sendNotify(SpecialOffers offer) {
		HttpEntity<SpecialOffers> requestBody = new HttpEntity<>(offer);
		logger.info("Send notify email: " + offer.toString());
		String result = restTemplate.postForObject(url, requestBody, String.class);
		if (result != null) {
			logger.info("Result: " + result);
		}

	}
	
	
}
