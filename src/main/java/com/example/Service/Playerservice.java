package com.example.Service;

import com.example.DAO.PlayerDao;
import com.example.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Playerservice {


    @Autowired
    private PlayerDao playerDao;

    public String addPlayer(Player player) {
        return playerDao.addPlayer(player);
    }
}
