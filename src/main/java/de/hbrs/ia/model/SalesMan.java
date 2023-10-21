package de.hbrs.ia.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;
import org.bson.Document;

@Value
@JsonDeserialize
@JsonSerialize
public class SalesMan {
    String firstname;
    String lastname;
    String id;

    public SalesMan(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = null;
    }

    public SalesMan(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("firstname" , this.firstname );
        document.append("lastname" , this.lastname );
        document.append("id" , this.id);
        return document;
    }

    public static SalesMan fromDocument(Document document) {
        String firstname = (String) document.get("firstname");
        String lastname = (String) document.get("lastname");
        String id = (String) document.get("id");
        return new SalesMan(firstname, lastname, id);
    }
}
