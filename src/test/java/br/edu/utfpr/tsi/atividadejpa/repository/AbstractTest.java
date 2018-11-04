package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.repository.JPA.JPAUtils;
import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

public class AbstractTest {
    protected static EntityManager em;

    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = JPAUtils.entityManager("test");

        Session session = em.unwrap(Session.class);
        session.doWork(connection -> {
            try {
                File createUsers = new File(UserRepositoryTest.class.getResource("/user.sql").getFile());
                File createEvents = new File(UserRepositoryTest.class.getResource("/events.sql").getFile());
                File createShow = new File(UserRepositoryTest.class.getResource("/shows.sql").getFile());
                File createTicket = new File(UserRepositoryTest.class.getResource("/tickets.sql").getFile());

                RunScript.execute(connection, new FileReader(createUsers));
                RunScript.execute(connection, new FileReader(createEvents));
                RunScript.execute(connection, new FileReader(createShow));
                RunScript.execute(connection, new FileReader(createTicket));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        });
    }


    @AfterClass
    public static void tearDown(){
//        em.clear();
//        em.close();
//        JPAUtils.closeEntityFactory();
    }
}
