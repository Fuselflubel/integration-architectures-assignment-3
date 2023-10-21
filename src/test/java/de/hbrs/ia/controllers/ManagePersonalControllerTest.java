package de.hbrs.ia.controllers;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagePersonalControllerTest {
    private MongoDatabase database = MongoClients.create("mongodb://localhost:27017").getDatabase("salesman_test");
    private ManagePersonalController managePersonalController;

    public ManagePersonalControllerTest() {

    }

    @BeforeEach
    void setUp() {
        database.getCollection("salesmen").drop();
        database.getCollection("performance_records").drop();

        managePersonalController = new ManagePersonalController(database);
    }

    @Test
    @Order(1)
    public void salesman_roundTripTest() {
        // create a salesman
        SalesMan salesman = new SalesMan("Sascha", "Alda");

        // store the salesman
        salesman = managePersonalController.createSalesMan(salesman);

        // read all salesmen
        assertEquals(1, managePersonalController.readAllSalesMan().size());

        // read the salesman
        SalesMan readSalesman = managePersonalController.readSalesMan(salesman.getId());
        assertEquals(salesman, readSalesman);

        // update the salesman
        SalesMan updatedSalesman = new SalesMan("Luca", "Ringhausen", salesman.getId());
        updatedSalesman = managePersonalController.updateSalesMan(updatedSalesman, salesman.getId());
        assertEquals(updatedSalesman, managePersonalController.readSalesMan(salesman.getId()));

        // delete the salesman
        managePersonalController.deleteSalesMan(salesman.getId());
        // read all salesmen
        assertEquals(0, managePersonalController.readAllSalesMan().size());
    }

    @Test
    @Order(2)
    public void evaluationRecord_roundTripTest() {
        // create a salesman
        SalesMan salesman = new SalesMan("Sascha", "Alda");

        // store the salesman
        salesman = managePersonalController.createSalesMan(salesman);

        // create a evaluation record
        EvaluationRecord evaluationRecord = new EvaluationRecord(null, "Goal 1", 100, 50, salesman.getId());
        evaluationRecord = managePersonalController.addPerformanceReord(evaluationRecord, salesman.getId());

        // read all evaluation records
        assertEquals(1, managePersonalController.readEvaluationRecords(salesman.getId()).size());

        // read the evaluation record
        EvaluationRecord readEvaluationRecord = managePersonalController.readSingleEvaluationRecords(salesman.getId(), evaluationRecord.goalId());
        assertEquals(evaluationRecord, readEvaluationRecord);

        // update the evaluation record
        EvaluationRecord updatedEvaluationRecord = new EvaluationRecord(evaluationRecord.goalId(), "Goal 2", 200, 100, salesman.getId());
        updatedEvaluationRecord = managePersonalController.updateEvaluationRecord(updatedEvaluationRecord, salesman.getId(), evaluationRecord.goalId());
        assertEquals(updatedEvaluationRecord, managePersonalController.readSingleEvaluationRecords(salesman.getId(), evaluationRecord.goalId()));

        // delete the evaluation record
        managePersonalController.deleteEvaluationRecord(salesman.getId(), evaluationRecord.goalId());
        // read all evaluation records
        assertEquals(0, managePersonalController.readEvaluationRecords(salesman.getId()).size());

        // delete the salesman
        managePersonalController.deleteSalesMan(salesman.getId());

    }


}