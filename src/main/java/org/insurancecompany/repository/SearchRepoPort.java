package org.insurancecompany.repository;

import org.insurancecompany.repository.model.BikeDocument;
import org.insurancecompany.repository.model.EventDocument;
import org.insurancecompany.repository.model.HelmetDocument;
import org.insurancecompany.repository.model.WetsuitDocument;

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
