package com.example.prodanog.repositories;

import com.example.prodanog.entity.Igra;
import com.example.prodanog.entity.Player;
import com.example.prodanog.entity.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.PublicKey;
import java.util.ArrayList;

@Component
public class PlayerRepozitore {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createPlayer(Player player){
        jdbcTemplate.update("insert into \"Player\" (\"id\") values(?)", player.getId());
        jdbcTemplate.update("insert into \"Player\" (\"stavka\") values(?)", player.getStavka());
        jdbcTemplate.update("insert into \"Player\" (\"balance\") values(?)", player.getBalance());
        jdbcTemplate.update("insert into \"Player\" (\"nedcol\") values(?)", player.getNedcol());
        jdbcTemplate.update("insert into \"Player\" (\"moncol\") values(?)", player.getMoncol());
        return jdbcTemplate.update("insert into \"Player\" (\"name\") values(?)", player.getName());
    }
    public Player getPlayer(int id ){
        return (Player) jdbcTemplate.query("select * from \"Player\" where \"id\" = ?", new PlayerMapper(), id);
    }

    public Integer ubdateStavka(int id, int stavka){
        return jdbcTemplate.update("update \"Player\" set \"nedCol\" = ? where \"id\" = ?", stavka, id);
    }

    public Integer addNedCol(ArrayList<Integer> input,Integer id){
        return jdbcTemplate.update("update \"Player\" set \"nedCol\" = ? where \"id\" = ?", input, id);
    }
    public Integer addMonCol(ArrayList<Integer> input,Integer id){
        return jdbcTemplate.update("update \"Player\" set \"monCol\" = ? where \"id\" = ?", input, id);
    }
    public Integer addNedCard(Integer id, Integer card){
        Player a= (Player) jdbcTemplate.query("select * from \"Player\" where \"id\" = ?", new PlayerMapper(), id);
        ArrayList<Integer> s =a.getNedcol();
        s.add(card);
        return jdbcTemplate.update("update \"Player\" set (\"nedCol\") = ? where \"id\" = ?", s, id);
    }

}
