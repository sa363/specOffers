package ru.navat.utils.windy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.navat.utils.windy.enums.BusinessSportEnum;
import ru.navat.utils.windy.enums.BusinessTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Cacheable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created", "updated", "isVerified"}, allowGetters = true)
public class SpecialOffers implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long offerId;
  private String firebaseOfferId;

  @Column(nullable = false, updatable = false)
  @NotBlank
  private String userId;

  @ElementCollection
  private List<String> activities;

  @ElementCollection
  private List<String> imageUrls;

  @Column(columnDefinition = "TEXT")
  private String offerDetails;

  @Column(nullable = false)
  private Long discount;

  @Column(nullable = false)
  private Long discount_pro;
  private Long viewsCount;

  @Column(nullable = false)
  @NotNull
  private Boolean isActive;

  private Boolean isGift;

//  @Column(nullable = false, columnDefinition = "boolean not null default 1")

  @JsonIgnore
  @JsonProperty(access = Access.READ_ONLY)
  @Column(nullable = false, updatable = false, columnDefinition="bit(1) not null default false")
  private Boolean isVerified = false;

  @Column(nullable = false)
  private String businessName;
  private String businessId;
  private String businessPhone;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<BusinessTypeEnum> businessType;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<BusinessSportEnum> businessSport;

  private String businessPublicMail;
  private String businessWorkMail;
  private String businessUrl;
  private Double businessLat;
  private Double businessLon;
  private Long spotId;
  private String spotName;
  private Double spotLat;
  private Double spotLon;

  @JsonIgnore
  private String excelhash;

  @Column(updatable = false)
  private Integer excelNumber;

  private String country;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date created;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updated;

  @Digits(integer = 1, fraction = 1)
  @Column(columnDefinition = "decimal(1,1) default 0")
  private BigDecimal rating = BigDecimal.ZERO;

  private String facebook;
  private String instagram;
}
