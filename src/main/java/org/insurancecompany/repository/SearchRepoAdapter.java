package org.insurancecompany.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.insurancecompany.repository.model.BikeDocument;
import org.insurancecompany.repository.model.EventDocument;
import org.insurancecompany.repository.model.HelmetDocument;
import org.insurancecompany.repository.model.WetsuitDocument;

import java.util.List;

/**
 * Clase encargada de gestionar los servicios de búsquedas en la base de datos Mongo
 */
@Service
public class SearchRepoAdapter implements SearchRepoPort {
  private static final Logger LOG = LoggerFactory.getLogger(SearchRepoAdapter.class);
  private final MongoTemplate mongoTemplate;

  public SearchRepoAdapter(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  // EVENTS

  /**
   * Save the document in MongoDB
   *
   * @param eventDocument Búsqueda a guardar
   */
  @Override
  public void save(EventDocument eventDocument) {
    LOG.info("Init save search");
    mongoTemplate.save(eventDocument);
  }

  /**
   * Create query to search
   *
   * @param eventDocument Filter to search
   * @return Query
   */
  private Query findBySearch(EventDocument eventDocument) {
    LOG.debug("Init findBySearch search:[{}]", eventDocument);
    Query query = new Query();
    if (eventDocument.getSearchId() != null)
      query.addCriteria(Criteria.where("searchId").is(eventDocument.getSearchId()));
    if (eventDocument.getName() != null)
      query.addCriteria(Criteria.where("name").is(eventDocument.getName()));
    return query;
  }

  private EventDocument createSearch(EventDocument eventDocument) {
    LOG.debug("Init createSearch");
    EventDocument searchDbModel = new EventDocument();
    searchDbModel.setSearchId(eventDocument.getSearchId());
    searchDbModel.setName(eventDocument.getName());
    return searchDbModel;
  }

  @Override
  public List<EventDocument> documentEvent() {
    return mongoTemplate.findAll(EventDocument.class);
  }

  @Override
  public List<EventDocument> documentEventByCriteria(String name, String id) {
    EventDocument document = new EventDocument();
    document.setName(name);
    document.setSearchId(id);
    return mongoTemplate.find(findBySearch(document), EventDocument.class);
  }


  // WETSUIT

  /**
   * Save the document in MongoDB
   *
   * @param wetsuitDocument Búsqueda a guardar
   */
  @Override
  public void save(WetsuitDocument wetsuitDocument) {
    LOG.info("Init save search");
    mongoTemplate.save(wetsuitDocument);
  }

  /**
   * Create query to search
   *
   * @param wetsuitDocument Filter to search
   * @return Query
   */
  private Query findBySearch(WetsuitDocument wetsuitDocument) {
    LOG.debug("Init findBySearch search:[{}]", wetsuitDocument);
    Query query = new Query();
    if (wetsuitDocument.getSearchId() != null)
      query.addCriteria(Criteria.where("searchId").is(wetsuitDocument.getSearchId()));
    if (wetsuitDocument.getBrand() != null)
      query.addCriteria(Criteria.where("brand").is(wetsuitDocument.getBrand()));
    if (wetsuitDocument.getModel() != null)
      query.addCriteria(Criteria.where("model").is(wetsuitDocument.getModel()));
    return query;
  }

  private WetsuitDocument createSearch(WetsuitDocument wetsuitDocument) {
    LOG.debug("Init createSearch");
    WetsuitDocument searchDbModel = new WetsuitDocument();
    searchDbModel.setId(wetsuitDocument.getId());
    searchDbModel.setBrand(wetsuitDocument.getBrand());
    searchDbModel.setModel(wetsuitDocument.getModel());
    searchDbModel.setYear(wetsuitDocument.getYear());
    return searchDbModel;
  }

  @Override
  public List<WetsuitDocument> documentWetsuit() {
    return mongoTemplate.findAll(WetsuitDocument.class);
  }

  @Override
  public List<WetsuitDocument> documentWetsuitByCriteria(String brand, String model, String id) {
    WetsuitDocument document = new WetsuitDocument();
    document.setBrand(brand);
    document.setModel(model);
    document.setSearchId(id);
    return mongoTemplate.find(findBySearch(document), WetsuitDocument.class);
  }

  // BIKE

  /**
   * Save the document in MongoDB
   *
   * @param bikeDocument Búsqueda a guardar
   */
  @Override
  public void save(BikeDocument bikeDocument) {
    LOG.info("Init save search");
    mongoTemplate.save(bikeDocument);
  }

  /**
   * Create query to search
   *
   * @param bikeDocument Filter to search
   * @return Query
   */
  private Query findBySearch(BikeDocument bikeDocument) {
    LOG.debug("Init findBySearch search:[{}]", bikeDocument);
    Query query = new Query();
    if (bikeDocument.getSearchId() != null)
      query.addCriteria(Criteria.where("searchId").is(bikeDocument.getSearchId()));
    if (bikeDocument.getBrand() != null)
      query.addCriteria(Criteria.where("brand").is(bikeDocument.getBrand()));
    if (bikeDocument.getModel() != null)
      query.addCriteria(Criteria.where("model").is(bikeDocument.getModel()));
    return query;
  }

  private BikeDocument createSearch(BikeDocument bikeDocument) {
    LOG.debug("Init createSearch");
    BikeDocument searchDbModel = new BikeDocument();
    searchDbModel.setId(bikeDocument.getId());
    searchDbModel.setBrand(bikeDocument.getBrand());
    searchDbModel.setModel(bikeDocument.getModel());
    searchDbModel.setYear(bikeDocument.getYear());
    return searchDbModel;
  }

  @Override
  public List<BikeDocument> documentBike() {
    return mongoTemplate.findAll(BikeDocument.class);
  }

  @Override
  public List<BikeDocument> documentBikeByCriteria(String brand, String model, String id) {
    BikeDocument document = new BikeDocument();
    document.setBrand(brand);
    document.setModel(model);
    document.setSearchId(id);
    return mongoTemplate.find(findBySearch(document), BikeDocument.class);
  }

  // HELMET

  /**
   * Save the document in MongoDB
   *
   * @param helmetDocument Búsqueda a guardar
   */
  @Override
  public void save(HelmetDocument helmetDocument) {
    LOG.info("Init save search");
    mongoTemplate.save(helmetDocument);
  }

  /**
   * Create query to search
   *
   * @param helmetDocument Filter to search
   * @return Query
   */
  private Query findBySearch(HelmetDocument helmetDocument) {
    LOG.debug("Init findBySearch search:[{}]", helmetDocument);
    Query query = new Query();
    if (helmetDocument.getSearchId() != null)
      query.addCriteria(Criteria.where("searchId").is(helmetDocument.getSearchId()));
    if (helmetDocument.getBrand() != null)
      query.addCriteria(Criteria.where("brand").is(helmetDocument.getBrand()));
    if (helmetDocument.getModel() != null)
      query.addCriteria(Criteria.where("model").is(helmetDocument.getModel()));
    return query;
  }

  private HelmetDocument createSearch(HelmetDocument helmetDocument) {
    LOG.debug("Init createSearch");
    HelmetDocument searchDbModel = new HelmetDocument();
    searchDbModel.setId(helmetDocument.getId());
    searchDbModel.setBrand(helmetDocument.getBrand());
    searchDbModel.setModel(helmetDocument.getModel());
    return searchDbModel;
  }

  @Override
  public List<HelmetDocument> documentHelmet() {
    return mongoTemplate.findAll(HelmetDocument.class);
  }

  @Override
  public List<HelmetDocument> documentHelmetByCriteria(String brand, String model, String id) {
    HelmetDocument document = new HelmetDocument();
    document.setBrand(brand);
    document.setModel(model);
    document.setSearchId(id);
    return mongoTemplate.find(findBySearch(document), HelmetDocument.class);
  }
}
