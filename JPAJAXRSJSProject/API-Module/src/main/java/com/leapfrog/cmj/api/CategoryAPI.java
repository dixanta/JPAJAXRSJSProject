/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cmj.api;

import com.leapfrog.cmj.core.dao.CategoryDAO;
import com.leapfrog.cmj.core.dao.impl.CategoryDAOImpl;
import com.leapfrog.cmj.core.entity.Category;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author USER
 */
@Path(value = "/category")
public class CategoryAPI{
    private CategoryDAO categoryDAO=new CategoryDAOImpl();
    @GET
    @Produces(value = MediaType.TEXT_PLAIN)
    public String index(){
        return "<h1>API works</h1>";
    }
    
    @Path("/all")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Category> all(){
        return categoryDAO.getAll();
    }
    
    @Path("/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Category id(@PathParam("id")int id){
        return categoryDAO.getById(id);
    }
    
    @Path("/save")
    @POST
    @Produces(value = MediaType.TEXT_PLAIN)
    @Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
    public String save(@FormParam("name")String name,@FormParam("desc")String desc,@FormParam("status")boolean status){
        Category c=new Category();
        c.setName(name);
        c.setDescription(desc);
        c.setStatus(status);
        categoryDAO.insert(c);
        return "success";
    }
}
