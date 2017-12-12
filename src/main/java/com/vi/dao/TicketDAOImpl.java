package com.vi.dao;

import com.vi.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TicketDAOImpl implements TicketDAO{

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Ticket ticket) {
        mongoOperations.save(ticket);
    }

    public Ticket get(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Ticket.class);
    }

    public List<Ticket> getAll() {
        return mongoOperations.findAll(Ticket.class);
    }

    public void remove(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Ticket.class);
    }
}

