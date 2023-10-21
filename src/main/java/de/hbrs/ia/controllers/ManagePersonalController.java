package de.hbrs.ia.controllers;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.hbrs.ia.code.ManagePersonal;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/personal")
public class ManagePersonalController implements ManagePersonal {
    // get mongodb via dependency injection
    private MongoDatabase database;
    private final String personalCollection = "salesmen";
    private final String performanceCollection = "performance_records";

    public ManagePersonalController(@Autowired MongoDatabase database) {
        this.database = database;
    }

    @Override
    @GetMapping(value = "/")
    public List<SalesMan> readAllSalesMan() {
        // find all salesmen
        return database.getCollection(personalCollection)
                .find()
                .map(SalesMan::fromDocument)
                .into(new ArrayList<>());
    }

    @Override
    @PostMapping(value = "/")
    public SalesMan createSalesMan(SalesMan record) {
        record = new SalesMan(record.getFirstname(), record.getLastname(), new ObjectId().toString());
        // create a document from the record
        Document document = record.toDocument();
        // insert the document into the collection
        database.getCollection(personalCollection).insertOne(document);

        return record;
    }

    @PostMapping(value = "/{sid}/records")
    @Override
    public EvaluationRecord addPerformanceReord(@RequestBody EvaluationRecord record, @PathVariable String sid) {
        record = record.withSalesmanId(sid);
        record = record.withGoalId(new ObjectId().toString());
        // create a document from the record
        Document document = record.toDocument();
        // insert the document into the collection
        database.getCollection(performanceCollection).insertOne(document);

        return record;
    }

    @Override
    @GetMapping(value = "/{sid}")
    public SalesMan readSalesMan(@PathVariable String sid) {
        // find salesman by id
        return SalesMan.fromDocument(
                Objects.requireNonNull(
                        database.getCollection(personalCollection)
                                .find(new Document("id", sid))
                                .first()
                )
        );

    }

    @Override
    @GetMapping(value = "/query")
    public List<SalesMan> querySalesMan(@RequestParam("attribute") String attribute, @RequestParam("key") String key) {
        List<SalesMan> salesmen = database.getCollection(personalCollection)
                .find(new Document(attribute, key))
                .map(SalesMan::fromDocument)
                .into(new ArrayList<>());

        return salesmen;

    }

    @Override
    @GetMapping(value = "/{sid}/records/")
    public List<EvaluationRecord> readEvaluationRecords(String sid) {
        // find EvaluationRecord by Salesman id
        return database.getCollection(performanceCollection)
                .find(new Document("salesmanId", sid))
                .map(EvaluationRecord::fromDocument)
                .into(new ArrayList<>());
    }

    @Override
    @GetMapping(value = "/{sid}/records/{rid}")
    public EvaluationRecord readSingleEvaluationRecords(String sid, String rid) {
        // find EvaluationRecord by Salesman id
        return EvaluationRecord.fromDocument(
                Objects.requireNonNull(
                        database.getCollection(performanceCollection)
                                .find(new Document("goalId", rid))
                                .first()));
    }

    // added to fulfill CRUD for salesman and evaluationrecords
    @Override
    @DeleteMapping(value = "/{sid}")
    public void deleteSalesMan(@PathVariable String sid) {
        database.getCollection(personalCollection).deleteOne(new Document("id", sid));
    }

    @Override
    @DeleteMapping(value = "/{sid}/records/{rid}")
    public void deleteEvaluationRecord(@PathVariable String sid, @PathVariable String rid) {
        database.getCollection(performanceCollection).deleteOne(new Document("goalId", rid));
    }

    @Override
    @PutMapping(value = "/{sid}")
    public SalesMan updateSalesMan(@RequestBody SalesMan record, @PathVariable String sid) {
        record = new SalesMan(record.getFirstname(), record.getLastname(), sid);
        // create a document from the record
        Document document = record.toDocument();
        // insert the document into the collection
        database.getCollection(personalCollection).replaceOne(new Document("id", sid), document);

        return record;
    }

    @Override
    @PutMapping(value = "/{sid}/records/{rid}")
    public EvaluationRecord updateEvaluationRecord(@RequestBody EvaluationRecord record, @PathVariable String sid, @PathVariable String rid) {
        record = record.withSalesmanId(sid);
        record = record.withGoalId(rid);
        // create a document from the record
        Document document = record.toDocument();
        // insert the document into the collection
        database.getCollection(performanceCollection).replaceOne(new Document("goalId", rid), document);

        return record;
    }
}
