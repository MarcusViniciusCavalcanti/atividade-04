package br.edu.utfpr.tsi.atividadejpa.repository.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager entityManager(String persistenceName) {

        if (entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityFactory() {
        entityManagerFactory.close();
    }
}
