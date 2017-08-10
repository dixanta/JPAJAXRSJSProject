/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cmj.core.dao;

import java.util.List;

/**
 *
 * @author USER
 */
public interface GenericDAO<T> {
    void insert(T c);
    void update(T c);
    void delete(int id);
    T getById(int id);
    List<T> getAll();
}
