package br.edu.utfpr.tsi.atividadejpa.servlet;

import br.edu.utfpr.tsi.atividadejpa.model.EventLocale;
import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.model.TicketShow;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.EventLocaleRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;
import br.edu.utfpr.tsi.atividadejpa.repository.ShowRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.TicketShowRepository;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@WebServlet(urlPatterns = "/initialize")
public class InitializeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createEventAndShow();
        createUser();
    }

    private void createUser() {
        int low = 16;
        int high = 40;

        Repository<User> userRepository = new UserRepository();

        for (int i = 0; i <= 10; i++) {
            User user = new User();
            user.setName("user - " + i);
            user.setAge(new Random().nextInt(high - low) + low);

            Optional<User> save = userRepository.save(user);
            createTicketsForUser(save.get());

            userRepository.save(save.get());
        }
    }

    private void createEventAndShow() {

        Repository<EventLocale> eventLocaleRepository = new EventLocaleRepository();
        Repository<Show> showRepository = new ShowRepository();

        for (int i = 0; i <= 4; i++) {
            EventLocale eventLocale = new EventLocale();
            eventLocale.setStart(LocalDate.now().plusWeeks(i));
            eventLocale.setEnd(eventLocale.getStart().plusDays(3));
            eventLocale.setCity("Guarapuava");

            Optional<EventLocale> save = eventLocaleRepository.save(eventLocale);

            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 5; k++) {
                    Show show = new Show();
                    show.setDate(eventLocale.getStart().plusDays(i));
                    show.setEventLocale(save.get());
                    show.setBanda("banda " + k);
                    showRepository.save(show);
                }
            }
        }
    }

    private void createTicketsForUser(User user) {
        TicketShowRepository ticketShowRepository = new TicketShowRepository();
        Repository<Show> showRepository = new ShowRepository();

        int low = 1;
        int high = 20;

        int rand = new Random().nextInt(high - low) + low;

        for (int i = 0; i < rand; i++) {
            long id = new Random().nextInt(15 - 1) + 1;
            TicketShow ticketShow = new TicketShow();
            Show show = showRepository.findById(id).get();
            ticketShow.setShow(show);
            ticketShow.setAmount(new Random().nextInt(10 - 1) + 10);
            ticketShow.setPrice(new Random().nextInt(1000 - 10) + 10);
            ticketShow.setUser(user);

            ticketShowRepository.save(ticketShow);
        }
    }
}
