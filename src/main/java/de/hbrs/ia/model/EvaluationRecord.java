package de.hbrs.ia.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.Document;

@JsonDeserialize
@JsonSerialize
public record EvaluationRecord(String goalId, Integer leadershipTargetValue,Integer leadershipActualValue, Integer leadershipBonus , Integer opennessTargetValue, Integer opennessActualValue, Integer opennessBonus, Integer socialTargetValue, Integer socialActualValue, Integer socialBonus, Integer attitudeTargetValue, Integer attitudeActualValue, Integer attitudeBonus, Integer CommunicationTargetValue, Integer CommunicationActualValue, Integer CommunicationBonus, Integer IntegrityTargetValue, Integer IntegrityActualValue, Integer IntegrityBonus, Integer AverageTargetValue,Integer AverageActualValue,Integer totalBonus, String salesmanId) {
    public Document toDocument() {
        Document document = new Document();
        document.append("goalId", this.goalId);
        document.append("leadershipTargetValue", this.leadershipTargetValue);
        document.append("leadershipActualValue", this.leadershipActualValue);
        document.append("leadershipBonus", this.leadershipBonus);
        document.append("opennessTargetValue", this.opennessTargetValue);
        document.append("opennessActualValue", this.opennessActualValue);
        document.append("opennessBonus", this.opennessBonus);
        document.append("socialTargetValue", this.socialTargetValue);
        document.append("socialActualValue", this.socialActualValue);
        document.append("socialBonus", this.socialBonus);
        document.append("attitudeTargetValue", this.attitudeTargetValue);
        document.append("attitudeActualValue", this.attitudeActualValue);
        document.append("attitudeBonus", this.attitudeBonus);
        document.append("CommunicationTargetValue", this.CommunicationTargetValue);
        document.append("CommunicationActualValue", this.CommunicationActualValue);
        document.append("CommunicationBonus", this.CommunicationBonus);
        document.append("IntegrityTargetValue", this.IntegrityTargetValue);
        document.append("IntegrityActualValue", this.IntegrityActualValue);
        document.append("IntegrityBonus", this.IntegrityBonus);
        document.append("AverageTargetValue", this.AverageTargetValue);
        document.append("AverageActualValue", this.AverageActualValue);
        document.append("totalBonus", this.totalBonus);
        document.append("salesmanId", this.salesmanId);
        return document;
    }

    public static EvaluationRecord fromDocument(Document document) {
        String goalId = (String) document.get("goalId");
        Integer leadershipTargetValue = (Integer) document.get("leadershipTargetValue");
        Integer leadershipActualValue = (Integer) document.get("leadershipActualValue");
        Integer leadershipBonus = (Integer) document.get("leadershipBonus");
        Integer opennessTargetValue = (Integer) document.get("opennessTargetValue");
        Integer opennessActualValue = (Integer) document.get("opennessActualValue");
        Integer opennessBonus = (Integer) document.get("opennessBonus");
        Integer socialTargetValue = (Integer) document.get("socialTargetValue");
        Integer socialActualValue = (Integer) document.get("socialActualValue");
        Integer socialBonus = (Integer) document.get("socialBonus");
        Integer attitudeTargetValue = (Integer) document.get("attitudeTargetValue");
        Integer attitudeActualValue = (Integer) document.get("attitudeActualValue");
        Integer attitudeBonus = (Integer) document.get("attitudeBonus");
        Integer CommunicationTargetValue = (Integer) document.get("CommunicationTargetValue");
        Integer CommunicationActualValue = (Integer) document.get("CommunicationActualValue");
        Integer CommunicationBonus = (Integer) document.get("CommunicationBonus");
        Integer IntegrityTargetValue = (Integer) document.get("IntegrityTargetValue");
        Integer IntegrityActualValue = (Integer) document.get("IntegrityActualValue");
        Integer IntegrityBonus = (Integer) document.get("IntegrityBonus");
        Integer AverageTargetValue = (Integer) document.get("AverageTargetValue");
        Integer AverageActualValue = (Integer) document.get("AverageActualValue");
        Integer totalBonus = (Integer) document.get("totalBonus");
        String salesmanId = (String) document.get("salesmanId");
        return new EvaluationRecord(goalId, leadershipTargetValue,leadershipActualValue,leadershipBonus, opennessTargetValue, opennessActualValue, opennessBonus, socialTargetValue, socialActualValue, socialBonus, attitudeTargetValue, attitudeActualValue, attitudeBonus, CommunicationTargetValue, CommunicationActualValue, CommunicationBonus, IntegrityTargetValue, IntegrityActualValue, IntegrityBonus, AverageTargetValue, AverageActualValue, totalBonus, salesmanId);
    }

    public EvaluationRecord withSalesmanId(String sid) {
        return new EvaluationRecord(this.goalId, this.leadershipTargetValue,this.leadershipActualValue,this.leadershipBonus, this.opennessTargetValue, this.opennessActualValue, this.opennessBonus, this.socialTargetValue, this.socialActualValue, this.socialBonus, this.attitudeTargetValue, this.attitudeActualValue, this.attitudeBonus, this.CommunicationTargetValue, this.CommunicationActualValue, this.CommunicationBonus, this.IntegrityTargetValue, this.IntegrityActualValue, this.IntegrityBonus, this.AverageTargetValue, this.AverageActualValue, this.totalBonus, sid);
    }

    public EvaluationRecord withGoalId(String goalId) {
        return new EvaluationRecord(goalId, this.leadershipTargetValue,this.leadershipActualValue,this.leadershipBonus, this.opennessTargetValue, this.opennessActualValue, this.opennessBonus, this.socialTargetValue, this.socialActualValue, this.socialBonus, this.attitudeTargetValue, this.attitudeActualValue, this.attitudeBonus, this.CommunicationTargetValue, this.CommunicationActualValue, this.CommunicationBonus, this.IntegrityTargetValue, this.IntegrityActualValue, this.IntegrityBonus, this.AverageTargetValue, this.AverageActualValue, this.totalBonus, this.salesmanId);
    }
}
