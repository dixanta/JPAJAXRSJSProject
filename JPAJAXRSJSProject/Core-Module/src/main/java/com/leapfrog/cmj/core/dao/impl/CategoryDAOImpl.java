/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cmj.core.dao.impl;

import com.leapfrog.cmj.core.dao.CategoryDAO;
import com.leapfrog.cmj.core.entity.Category;
import java.util.List;


/**
 *
 * @author USER
 */
public class CategoryDAOImpl extends GenericDAOImpl<Category> implements CategoryDAO{

    @Override
    public List<Category> getAll() {
        return em.createQuery("Select c from Category c").getResultList();
    }

    
    

    

}
