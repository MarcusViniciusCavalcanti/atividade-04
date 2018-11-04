package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.ShowRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@WebServlet(urlPatterns = "/user_show")
public class UserShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ShowRepository showRepository = new ShowRepository();
        Optional<Show> byId = showRepository.findById(Long.valueOf(id));


        UserRepository userRepository = new UserRepository();
        Set<User> byShow = userRepository.findByShow(byId.get());
        User byMajorPrice = userRepository.findByMajorPrice();

        req.setAttribute("users", byShow);
        req.setAttribute("major_price", byMajorPrice);
        req.setAttribute("show", byId.get());
        req.getRequestDispatcher("/user_show.jsp").forward(req, resp);

    }
}
