package com.vi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Ticket.COLLECTION_NAME)
public class Ticket {
    public static final String COLLECTION_NAME = "tickets";

    @Id
    private String id;
    private String name;
    private String description;
    private String status;

    public Ticket() {
    }

    public Ticket(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status; }

}
