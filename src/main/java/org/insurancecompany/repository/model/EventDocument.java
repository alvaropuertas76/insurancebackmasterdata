package org.insurancecompany.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "event")
public class EventDocument {
  private String id;
  private String searchId;
  private String name;
  private String brand;
  private String city;
  private String location;
  private String URLImage;
  private String date;
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSearchId() {
    return searchId;
  }

  public void setSearchId(String searchId) {
    this.searchId = searchId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getURLImage() {
    return URLImage;
  }

  public void setURLImage(String URLImage) {
    this.URLImage = URLImage;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}