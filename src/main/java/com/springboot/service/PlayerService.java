package com.springboot.service;

import com.springboot.model.Player;
import com.springboot.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {

    // working with only collection data

    List<Player> players = new ArrayList<>();


    AtomicInteger id = new AtomicInteger(0);


    public List<Player> getPlayers() {
        return players;
    }

    public Optional<Player> getPlayer(Integer id){
        return players.stream().filter(x -> x.id() == id).findFirst();
    }

    public Player create(String name, Team team){
        Player player = new Player(id.incrementAndGet(),name,team);
        players.add(player);
        return player;
    }


    public Player update(Integer id,String name,Team team) throws IllegalAccessException {
        Player updatePlayer = new Player(id, name, team);
        Optional<Player> optional =  players.stream().filter(x -> x.id() == id).findFirst();
        if (optional.isPresent()){
            Player player = optional.get();
            int index = players.indexOf(player);
            players.set(index,player);
        }else
            throw new IllegalAccessException("Invalid Player");

        return updatePlayer;
    }

    public Player delete(Integer id){
        Player player = players.stream().filter(x -> Objects.equals(x.id(), id))
                .findFirst().orElseThrow(IllegalArgumentException::new);
        players.remove(player);
        return player;
    }


    @PostConstruct
    private void init(){
        players.add(new Player(id.incrementAndGet(),"MS Dhoni",Team.CSK));
        players.add(new Player(id.incrementAndGet(),"Kohli",Team.RCB));
        players.add(new Player(id.incrementAndGet(),"Bhumra",Team.MI));
        players.add(new Player(id.incrementAndGet(),"Rohith",Team.MI));
        players.add(new Player(id.incrementAndGet(),"KL Rahul",Team.KKR));
        players.add(new Player(id.incrementAndGet(),"Jadeja",Team.CSK));
    }


}
