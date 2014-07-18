package com.rom4.departments.services;

import org.hibernate.Session;

import javax.security.auth.callback.Callback;
import java.util.List;

/**
 * Created by rom4 on 18.07.14.
 * Creation time 13:29
 * Project name Departments
 */
public class  A {

    DAO dao = new DAO();

    public <T> List<T> getEntities (Session session) {
        List<T> entities = null;

        session.getTransaction().begin();

        dao.execute(new GetEntities(), "ddd");

        session.getTransaction().commit();
        return null;
    }

    class DAO<T> {
        <T> List<T> execute (Callback callback, T t)  {
            return callback.execute(t);

        }
    }
    interface Callback {
        <T> List<T> execute (T aa) ;
    }

    class GetEntities implements  Callback{

        @Override
        public <T> List<T> execute(T aa) {
            return null;
        }
    }

}


