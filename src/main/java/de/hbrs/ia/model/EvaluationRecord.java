package de.hbrs.ia.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.Document;

@JsonDeserialize
@JsonSerialize
public record EvaluationRecord(String goalId, String goalDescription, Integer targetValue, Integer actualValue, String salesmanId) {
    public Document toDocument() {
        Document document = new Document();
        document.append("goalId", this.goalId);
        document.append("goalDescription", this.goalDescription);
        document.append("targetValue", this.targetValue);
        document.append("actualValue", this.actualValue);
        document.append("salesmanId", this.salesmanId);
        return document;
    }

    public static EvaluationRecord fromDocument(Document document) {
        String goalId = (String) document.get("goalId");
        String goalDescription = (String) document.get("goalDescription");
        Integer targetValue = (Integer) document.get("targetValue");
        Integer actualValue = (Integer) document.get("actualValue");
        String salesmanId = (String) document.get("salesmanId");
        return new EvaluationRecord(goalId, goalDescription, targetValue, actualValue, salesmanId);
    }

    public EvaluationRecord withSalesmanId(String sid) {
        return new EvaluationRecord(this.goalId, this.goalDescription, this.targetValue, this.actualValue, sid);
    }

    public EvaluationRecord withGoalId(String goalId) {
        return new EvaluationRecord(goalId, this.goalDescription, this.targetValue, this.actualValue, this.salesmanId);
    }
}
