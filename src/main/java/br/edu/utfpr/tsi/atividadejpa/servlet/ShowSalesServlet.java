package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.dto.AmountSalesShowDTO;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.ShowRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/show_sales")
public class ShowSalesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShowRepository showRepository = new ShowRepository();
        List<AmountSalesShowDTO> amountSalesTickets = showRepository.getAmountSalesTickets();

        UserRepository userRepository = new UserRepository();
        User byMajorPrice = userRepository.findByMajorPrice();

        req.setAttribute("tickets", amountSalesTickets);
        req.setAttribute("user", byMajorPrice);
        req.getRequestDispatcher("/tickets.jsp").forward(req, resp);
    }
}
