package com.vi.dao;

import com.vi.model.Ticket;
import java.util.List;

public interface TicketDAO {

    public void save(Ticket ticket);

    public Ticket get(String id);

    public List<Ticket> getAll();

    public void remove(String id) ;
}