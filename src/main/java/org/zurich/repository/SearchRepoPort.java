package org.zurich.repository;

import org.zurich.repository.model.BikeDocument;
import org.zurich.repository.model.EventDocument;
import org.zurich.repository.model.HelmetDocument;
import org.zurich.repository.model.WetsuitDocument;

import java.util.List;

public interface SearchRepoPort {

  void save(EventDocument eventDocument);

  List<EventDocument> documentEvent();

  List<EventDocument> documentEventByCriteria(String name, String id);

  void save(WetsuitDocument wetsuitDocument);

  List<WetsuitDocument> documentWetsuit ();

  List<WetsuitDocument> documentWetsuitByCriteria(String brand, String model, String id);

  void save(BikeDocument bikeDocument);

  List<BikeDocument> documentBike();

  List<BikeDocument> documentBikeByCriteria(String brand, String model, String id);

  void save(HelmetDocument helmetDocument);

  List<HelmetDocument> documentHelmet();

  List<HelmetDocument> documentHelmetByCriteria(String brand, String model, String id);
}
