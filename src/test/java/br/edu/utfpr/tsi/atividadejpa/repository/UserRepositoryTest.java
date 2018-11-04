package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.model.TicketShow;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest extends AbstractTest {
    private static int totalRows = 30;

    @Test
    public void deve_salvar_usuario_com_sucesso() {
        Repository<User> userRepository = new UserRepository();

        User user = new User();
        user.setName("Marcus");
        user.setAge(35);

        Optional<User> save = userRepository.save(user);


        assertThat(save.get().getName(), CoreMatchers.is(user.getName()));
        assertThat(save.get().getId(), CoreMatchers.not(0));
    }

    @Test
    public void deve_apresentar_todos_usuarios_cadastrados() {
        Repository<User> userRepository = new UserRepository();
        List<User> users = userRepository.findAll();
        assertThat(users.size(), CoreMatchers.is(totalRows));
    }

    @Test
    public void deve_apresentar_usuarios_que_compraram_um_ingresso_para_um_dado_show() {
        UserRepository userRepository = new UserRepository();
        ShowRepository showRepository = new ShowRepository();


        long id = new Random().nextInt( 42 - 1) + 1;
        Show show = showRepository.findById(id).get();

        List<User> collect = show.getTicketShows().stream()
                .map(TicketShow::getUser)
                .collect(Collectors.toList());


        Set<User> users = userRepository.findByShow(show);

        assertThat(users, CoreMatchers.hasItem(collect.get(1)));
    }

    @Test
    public void deve_apresentar_usuario_que_doou_o_maior_valor_em_um_pedido() {
        UserRepository userRepository = new UserRepository();
        ShowRepository showRepository = new ShowRepository();

        long id = new Random().nextInt( 42 - 1) + 1;
        Show show = showRepository.findById(id).get();

        User majorUser = show.getTicketShows().stream()
                .max(Comparator.comparing(TicketShow::getAmount))
                .get()
                .getUser();

        User user = userRepository.findByMajorPrice();
    }
}