package com.vi.controller;

import com.vi.model.Ticket;
import com.vi.services.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


@Controller
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketServiceImpl;
    private String status;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password!");
        }
        modelAndView.addObject("tickets", ticketServiceImpl.getAll());
        modelAndView.setViewName("all");
        return modelAndView;
    }

    @RequestMapping(value = "/add*", method = RequestMethod.GET)
    public ModelAndView showAddForm(HttpServletRequest request) {
        status = request.getParameter("status");
        return new ModelAndView("addForm", "ticket", new Ticket());
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTicket(@ModelAttribute("ticket") Ticket ticket, HttpServletRequest request) {
         if(ticket.getId() == "") {
         ticketServiceImpl.add(new Ticket(ticket.getName(), ticket.getDescription(), status));
        }
        else {
            status = ticketServiceImpl.get(request.getParameter("id")).getStatus();
            ticket.setStatus(status);
            ticketServiceImpl.update(ticket);
        }
     return "redirect:/all";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) String id) {
        return new ModelAndView("addForm", "ticket", ticketServiceImpl.get(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteTicket(@RequestParam(required = true) String id) {
        ticketServiceImpl.remove(id);
        return "redirect:/all";
    }

    @RequestMapping(value = "/markAsToDo", method = RequestMethod.GET)
    public String markAsToDo(@RequestParam(required = true) String id) {
        Ticket ticket = ticketServiceImpl.get(id);
        ticket.setStatus("TO DO");
        ticketServiceImpl.update(ticket);
        return "redirect:/all";
    }

    @RequestMapping(value = "/markAsInProgress", method = RequestMethod.GET)
    public String markInProgress(@RequestParam(required = true) String id) {
        Ticket ticket = ticketServiceImpl.get(id);
        ticket.setStatus("In Progress");
        ticketServiceImpl.update(ticket);
        return "redirect:/all";
    }


    @RequestMapping(value = "/markAsDone", method = RequestMethod.GET)
    public String markAsDone(@RequestParam(required = true) String id) {
        Ticket ticket = ticketServiceImpl.get(id);
        ticket.setStatus("Done");
        ticketServiceImpl.update(ticket);
        return "redirect:/all";
    }
}
