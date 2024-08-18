package org.zurich.controller;

import org.zurich.api.TriatlhonPolicyProductApi;
import org.zurich.model.Bike;
import org.zurich.model.Event;
import org.zurich.model.Helmet;
import org.zurich.model.Wetsuit;
import org.zurich.repository.model.BikeDocument;
import org.zurich.repository.model.EventDocument;
import org.zurich.repository.model.HelmetDocument;
import org.zurich.repository.model.WetsuitDocument;
import org.zurich.service.SearchServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TriathlonPolicyProductController implements TriatlhonPolicyProductApi {

    private final SearchServiceI searchService;

    public TriathlonPolicyProductController(SearchServiceI searchService) {
        this.searchService = searchService;
    }

    @Override
    public ResponseEntity<List<Bike>> getBike(String brand, String model, String id) {
        List<BikeDocument> list;
        if (brand !=null || model !=null || id != null) {
            list = searchService.documentBikeByCriteria(brand, model, id);
        } else
            list = searchService.documentBike();

        // Convertir BikeDocument a Bike
        List<Bike> bikes = list.stream()
                .map(this::convertToBike)
                .collect(Collectors.toList());

        return ResponseEntity.ok(bikes);
    }

    @Override
    public ResponseEntity<List<Event>> getEvent(String name, String id) {

        List<EventDocument> list;
        if (name !=null || id != null) {
            list = searchService.documentEventByCriteria(name, id);
        } else
            list = searchService.documentEvent();

        // Convertir EventDocument a Event
        List<Event> events = list.stream()
                .map(this::convertToEvent)
                .collect(Collectors.toList());

        return ResponseEntity.ok(events);
    }

    @Override
    public ResponseEntity<List<Helmet>> getHelmet(String brand, String model, String id) {
        List<HelmetDocument> list;
        if (brand !=null || model !=null || id != null) {
            list = searchService.documentHelmetByCriteria(brand, model, id);
        } else
            list = searchService.documentHelmet();

        // Convertir BikeDocument a Bike
        List<Helmet> helmets = list.stream()
                .map(this::convertToHelmet)
                .collect(Collectors.toList());

        return ResponseEntity.ok(helmets);
    }

    @Override
    public ResponseEntity<List<Wetsuit>> getWetsuit(String brand, String model, String id) {

        List<WetsuitDocument> list;
        if (brand !=null || model !=null || id != null) {
            list = searchService.documentWetsuitByCriteria(brand, model, id);
        } else
            list = searchService.documentWetsuit();

        // Convertir WetsuitDocument a Wetsuit
        List<Wetsuit> wetsuits = list.stream()
                .map(this::convertToWetsuit)
                .collect(Collectors.toList());

        return ResponseEntity.ok(wetsuits);
    }

    // Private methods to convert XXXDocuments to a model of the API

    // Method to convert one EventDocument to an Event
    private Event convertToEvent(EventDocument eventDocument) {
        Event event = new Event();
        event.setId(eventDocument.getSearchId());
        event.setName(eventDocument.getName());
        event.setDate(eventDocument.getDate());
        event.setLocation(eventDocument.getLocation());
        event.setUrLImage(eventDocument.getURLImage());
        event.setDescription(eventDocument.getDescription());
        event.setBrand(eventDocument.getBrand());
        event.setCity(eventDocument.getCity());
        return event;
    }

    // Method to convert one WetsuitDocument to a Wetsuit
    private Wetsuit convertToWetsuit(WetsuitDocument wetsuitDocument) {
        Wetsuit wetsuit = new Wetsuit();
        wetsuit.setId(wetsuitDocument.getSearchId());
        wetsuit.setUrLImage(wetsuitDocument.getURLImage());
        wetsuit.setDescription(wetsuitDocument.getDescription());
        wetsuit.setBrand(wetsuitDocument.getBrand());
        wetsuit.setModel(wetsuitDocument.getModel());
        wetsuit.setYear(wetsuitDocument.getYear());
        wetsuit.setMarketValue(wetsuitDocument.getMarket_value());
        wetsuit.setCurrency(wetsuitDocument.getCurrency());
        return wetsuit;
    }

    // Method to convert one BikeDocument to a Bike
    private Bike convertToBike(BikeDocument bikeDocument) {
        Bike bike = new Bike();
        bike.setId(bikeDocument.getSearchId());
        bike.setUrLImage(bikeDocument.getURLImage());
        bike.setDescription(bikeDocument.getDescription());
        bike.setBrand(bikeDocument.getBrand());
        bike.setModel(bikeDocument.getModel());
        bike.setYear(bikeDocument.getYear());
        bike.setMarketValue(bikeDocument.getMarketValue());
        bike.setCurrency(bikeDocument.getCurrency());
        return bike;
    }

    // Method to convert one HelmetDocument to a Helmet
    private Helmet convertToHelmet(HelmetDocument helmetDocument) {
        Helmet helmet = new Helmet();
        helmet.setId(helmetDocument.getSearchId());
        helmet.setUrLImage(helmetDocument.getURLImage());
        helmet.setDescription(helmetDocument.getDescription());
        helmet.setBrand(helmetDocument.getBrand());
        helmet.setModel(helmetDocument.getModel());
        helmet.setYear(helmetDocument.getYear());
        helmet.setMarketValue(helmetDocument.getMarketValue());
        helmet.setCurrency(helmetDocument.getCurrency());
        return helmet;
    }
}