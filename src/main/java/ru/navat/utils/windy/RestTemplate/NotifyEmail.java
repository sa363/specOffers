package ru.navat.utils.windy.RestTemplate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class NotifyEmail {
	private Long offerId;
	private List<String> imageUrls;
	private String offerDetails;
	private Long discount;
	private Long discount_pro;
	private String businessName;
	private String businessId;
	private String businessPhone;
	private String businessPublicMail;
	private String businessWorkMail;
	private String businessUrl;
}
