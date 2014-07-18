package com.rom4.departments.controller;

import com.rom4.departments.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by rom4 on 18.07.14.
 * Creation time 16:34
 * Project name Departments
 */
public class SessionFilter implements Filter {
    SessionFactory sf;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Transaction tr = null;
        try {

            tr = sf.getCurrentSession().beginTransaction();
            chain.doFilter(req, resp);
            tr.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tr.isActive()) {
                tr.rollback();
            }

        }
    }

    public void init(FilterConfig config) throws ServletException {

        sf = HibernateUtil.getSessionFactory();
    }

}
