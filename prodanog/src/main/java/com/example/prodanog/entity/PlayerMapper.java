package com.example.prodanog.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setBalance(rs.getInt("balance"));
        player.setStavka(rs.getInt("stavka"));
        player.setName(rs.getString("name"));
        player.setMaxPlayer(rs.getInt("maxPlayer"));
        player.setMoncol((ArrayList<Integer>) rs.getObject("moncol"));
        player.setNedcol((ArrayList<Integer>) rs.getObject("nedcol"));
        return player;
    }
}
