/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cmj.web.controller;

import com.leapfrog.cmj.core.dao.CategoryDAO;
import com.leapfrog.cmj.core.dao.impl.CategoryDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "default",urlPatterns = {"/"})
public class DefaultServlet extends HttpServlet{
    private CategoryDAO categoryDAO=new CategoryDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryDAO.getAll());
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
    
}
