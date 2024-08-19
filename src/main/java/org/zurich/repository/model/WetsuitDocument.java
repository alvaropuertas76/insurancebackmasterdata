package org.zurich.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document (collection = "wetsuit")
public class WetsuitDocument {
  private String Id;
  private String searchId;
  private String brand;
  private String model;
  private String year;
  private Double marketValue;
  private String currency;
  private String description;
  private String URLImage;

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getSearchId() {
    return searchId;
  }

  public void setSearchId(String searchId) {
    this.searchId = searchId;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public Double getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(Double marketValue) {
    this.marketValue = marketValue;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getURLImage() {
    return URLImage;
  }

  public void setURLImage(String URLImage) {
    this.URLImage = URLImage;
  }
}