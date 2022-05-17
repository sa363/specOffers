package ru.navat.utils.windy.model;

import ru.navat.utils.windy.enums.BusinessSportEnum;
import javax.persistence.*;

@Entity
public class SpecialOffers_businessSport {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long specialoffers_offerid;

  @Enumerated(EnumType.STRING)
  private BusinessSportEnum businesssport;

  public Long getSpecialoffers_offerid() {
    return specialoffers_offerid;
  }

  public void setSpecialoffers_offerid(Long specialoffers_offerid) {
    this.specialoffers_offerid = specialoffers_offerid;
  }

  public BusinessSportEnum getBusinesssport() {
    return businesssport;
  }

  public void setBusinesssport(BusinessSportEnum businesssport) {
    this.businesssport = businesssport;
  }
}
