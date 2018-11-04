package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.repository.ShowRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.TicketShowRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/shows")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShowRepository repository = new ShowRepository();
        List<Show> all = repository.findAll();


        req.setAttribute("shows", all);
        req.getRequestDispatcher("/shows.jsp").forward(req, resp);

    }
}
