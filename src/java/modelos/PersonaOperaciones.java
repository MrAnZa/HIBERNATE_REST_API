/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EliteBook
 */
public class PersonaOperaciones {

    public ArrayList<Persona> getPersonas() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Query q = session.createQuery("from Persona");
        List<Persona> lista = q.list();
        Iterator<Persona> iterator = lista.iterator();
        tx.commit();
        session.close();
        while (iterator.hasNext()) {
            Persona per = (Persona) iterator.next();
            personas.add(per);
        }
        return personas;
    }

    public void addPersona(Persona persona) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(persona);
        tx.commit();
        session.close();
    }

    public Persona findPersona(byte id) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Persona persona = (Persona) session.get(Persona.class, id);
        tx.commit();
        session.close();
        return persona;
    }

    public void updatePersona(Persona persona) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.update(persona);
        tx.commit();
        session.close();
    }

    public void deletePersona(byte id) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Persona persona = (Persona) session.get(Persona.class, id);
        session.delete(persona);
        tx.commit();
        session.close();
    }
}
