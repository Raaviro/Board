package com.vi.services;

import com.vi.model.Ticket;
import java.util.List;

public interface TicketService {

    public void add(Ticket ticket);

    public void update(Ticket ticket);

    public Ticket get(String id);

    public List<Ticket> getAll();

    public void remove(String id);
}
