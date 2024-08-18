package org.zurich.service;

import org.zurich.repository.SearchRepoPort;
import org.zurich.repository.model.BikeDocument;
import org.zurich.repository.model.EventDocument;
import org.zurich.repository.model.HelmetDocument;
import org.zurich.repository.model.WetsuitDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase encargada de gestionar procesar el servicio para almacenar las búsquedas y su conteo
 */
@Service
public class SearchService implements SearchServiceI {
  private static final Logger LOG = LoggerFactory.getLogger(SearchService.class);
  private final SearchRepoPort searchRepo;

  public SearchService(SearchRepoPort searchRepo) {
    this.searchRepo = searchRepo;
  }

  @Override
  public List<WetsuitDocument> documentWetsuit() {
    return searchRepo.documentWetsuit();
  }

  @Override
  public List<WetsuitDocument> documentWetsuitByCriteria(String brand, String model, String id) {
    return searchRepo.documentWetsuitByCriteria(brand, model, id);
  }

  @Override
  public List<EventDocument> documentEvent() {
    return searchRepo.documentEvent();
  }

  @Override
  public List<EventDocument> documentEventByCriteria(String name, String id) {
    return searchRepo.documentEventByCriteria(name, id);
  }

  @Override
  public List<BikeDocument> documentBike() {
    return searchRepo.documentBike();
  }

  @Override
  public List<BikeDocument> documentBikeByCriteria(String brand, String model, String id) {
    return searchRepo.documentBikeByCriteria(brand, model, id);
  }

  @Override
  public List<HelmetDocument> documentHelmet() {
    return searchRepo.documentHelmet();
  }

  @Override
  public List<HelmetDocument> documentHelmetByCriteria(String brand, String model, String id) {
    return searchRepo.documentHelmetByCriteria(brand, model, id);
  }

  @Override
  public void save(WetsuitDocument wetsuitDocument) {
    searchRepo.save(wetsuitDocument);
  }
}