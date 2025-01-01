package com.example.DAO;

import com.example.Entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class PlayerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public String addPlayer(Player player) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(player);
        session.beginTransaction().commit();
        return "Player added successfully";
    }
}
