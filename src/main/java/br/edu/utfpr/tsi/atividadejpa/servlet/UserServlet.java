package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository repository = new UserRepository();

        List<User> all = repository.findAll();

        req.setAttribute("allusers", all);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
