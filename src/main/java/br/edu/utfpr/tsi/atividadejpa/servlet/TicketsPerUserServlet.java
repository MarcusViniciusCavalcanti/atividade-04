package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.model.TicketShow;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.TicketShowRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/tickets_per_user")
public class TicketsPerUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");


        UserRepository userRepository = new UserRepository();
        Optional<User> byId = userRepository.findById(Long.valueOf(id));

        TicketShowRepository ticketShowRepository = new TicketShowRepository();
        List<TicketShow> ticketTo = ticketShowRepository.getTicketTo(byId.get());

        req.setAttribute("tickets", ticketTo);
        req.setAttribute("user", byId.get());
        req.getRequestDispatcher("/tickets.jsp").forward(req, resp);
    }
}
