package de.hbrs.ia.code;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Code lines are commented for suppressing compile errors.
 */
public interface ManagePersonal {

    public SalesMan createSalesMan( SalesMan record );

    public EvaluationRecord addPerformanceReord(EvaluationRecord record , String sid );

    public SalesMan readSalesMan(String sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    public List<EvaluationRecord> readEvaluationRecords(String sid );

    public void deleteSalesMan(@PathVariable String sid);

    public void deleteEvaluationRecord(@PathVariable String sid, @PathVariable String rid);

    public SalesMan updateSalesMan(@RequestBody SalesMan record, @PathVariable String sid);

    public EvaluationRecord updateEvaluationRecord(@RequestBody EvaluationRecord record, @PathVariable String sid, @PathVariable String rid);

    public EvaluationRecord readSingleEvaluationRecords(String sid, String rid);

    public List<SalesMan> readAllSalesMan();
}
