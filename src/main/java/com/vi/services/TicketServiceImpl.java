package com.vi.services;

import com.vi.dao.TicketDAOImpl;
import com.vi.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketDAOImpl ticketDao;

    public void add(Ticket ticket) {
       ticketDao.save(ticket);
    }

    public void update(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Ticket get(String id) {
        return ticketDao.get(id);
    }

    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    public void remove(String id) {
        ticketDao.remove(id);
    }
}

