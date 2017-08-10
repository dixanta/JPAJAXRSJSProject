/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cmj.core.dao.impl;

import com.leapfrog.cmj.core.dao.GenericDAO;
import com.leapfrog.cmj.core.entity.User;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author USER
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    private EntityTransaction trans;
    private Class<T> paramClass;
    public GenericDAOImpl() {
        emf = Persistence.createEntityManagerFactory("JPU");
        em = emf.createEntityManager();
        paramClass=(Class<T>)((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public void insert(T c) {
        trans = em.getTransaction();
        trans.begin();
        em.persist(c);
        em.flush();
        trans.commit();
    }

    @Override
    public void update(T c) {
        trans = em.getTransaction();
        trans.begin();
        em.merge(c);
        trans.commit();
    }

    @Override
    public void delete(int id) {
        trans = em.getTransaction();
        trans.begin();
        em.remove(em.find(paramClass, id));
        trans.commit();
    }

    @Override
    public T getById(int id) {
        return em.find(paramClass, id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder criteria=em.getCriteriaBuilder();
        CriteriaQuery<T> query=criteria.createQuery(paramClass);
        return em.createQuery(query).getResultList();
    }

    

}
