package ru.navat.utils.windy.model;

import ru.navat.utils.windy.enums.BusinessSportEnum;
import ru.navat.utils.windy.enums.BusinessTypeEnum;

import javax.persistence.*;

@Entity
public class SpecialOffers_businessType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long specialoffers_offerid;

  @Enumerated(EnumType.STRING)
  private BusinessTypeEnum businesstype;

  public Long getSpecialoffers_offerid() {
    return specialoffers_offerid;
  }

  public void setSpecialoffers_offerid(Long specialoffers_offerid) {
    this.specialoffers_offerid = specialoffers_offerid;
  }

  public BusinessTypeEnum getBusinesssport() {
    return businesstype;
  }

  public void setBusinesssport(BusinessTypeEnum businesssport) {
    this.businesstype = businesssport;
  }
}
