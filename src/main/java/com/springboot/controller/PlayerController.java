package com.springboot.controller;

import com.springboot.model.Player;
import com.springboot.model.Team;
import com.springboot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {


    private final PlayerService service;

    public PlayerController(PlayerService playerService){
        this.service = playerService;
    }


    @QueryMapping
    public List<Player> findAll(){
        return this.service.getPlayers();
    }


    @QueryMapping
    public Optional<Player> getPlayer(@Argument  Integer id){
        return this.service.getPlayer(id);
    }

    @MutationMapping
    public Player create(@Argument String name, @Argument Team team){
        return this.service.create(name,team);
    }

    @MutationMapping
    public Player update(@Argument Integer id, @Argument String name, @Argument Team team)throws IllegalAccessException{
        return this.service.update(id, name, team);
    }

    @MutationMapping
    public Player delete(@Argument Integer id){
        return this.service.delete(id);
    }

}
