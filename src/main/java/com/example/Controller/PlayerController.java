package com.example.Controller;

import com.example.Entity.Player;
import com.example.Service.Playerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private Playerservice playerservice;

    @PostMapping("/add")
    public String addPlayer(@RequestBody Player player){
        return playerservice.addPlayer(player);
    }
}
