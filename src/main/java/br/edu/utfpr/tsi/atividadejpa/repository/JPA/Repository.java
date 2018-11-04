package br.edu.utfpr.tsi.atividadejpa.repository.JPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Repository<T> {
    @PersistenceContext
    protected EntityManager entityManager = JPAUtils.entityManager("atividade");
    private Class<T> entityClass;

    public Repository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Optional<T> save(T entity) {

        try {
            T merge = null;
            if (entityManager.getTransaction().isActive()) {
                entityManager.persist(entity);
                merge = entity;
            } else {
                entityManager.getTransaction().begin();
                merge = entityManager.merge(entity);
                entityManager.getTransaction().commit();
            }
            return Optional.of(merge);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> rootEntry = criteriaQuery.from(entityClass);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> list = entityManager.createQuery(all);

        return Collections.unmodifiableList(list.getResultList());
    }

    public Optional<T> findById(long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

}
