package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/user_details")
public class UserDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserRepository userRepository = new UserRepository();
        Optional<User> byId = userRepository.findById(Long.valueOf(id));
        req.setAttribute("user", byId);
        req.getRequestDispatcher("detailsUser").forward(req, resp);

    }
}
