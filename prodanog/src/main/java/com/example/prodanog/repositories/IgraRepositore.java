package com.example.prodanog.repositories;

import com.example.prodanog.entity.Igra;
import com.example.prodanog.entity.IgraMapper;
import com.example.prodanog.entity.Player;
import com.example.prodanog.entity.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class IgraRepositore {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Integer> addPlayer(Player player) {
        Igra igra = jdbcTemplate.queryForObject("select * from \"Igra\" where \"status\"=? and \"maxPlayer\"=?", new IgraMapper(), false, player.getMaxPlayer());
        if (igra == null) {
            igra.setMaxPlayer(player.getMaxPlayer());
            igra.setMoneycol(igra.coloda());
            igra.setNedcol(igra.coloda());
            igra.setPlay1(player.getId());
        }
        int num = igra.addPlayr(player.getId());
        if (num == 2) {
            jdbcTemplate.update("update \"Igra\" set \"player2\" = ? where \"id\" = ?", player.getId(), Igra.getId());
            ArrayList<Integer>a=new ArrayList<>();
            a.add(createIgra(igra));
            a.add(num);
            return a;
        }
        if (num == 3) {
            jdbcTemplate.update("update \"Igra\" set \"player3\" = ? where \"id\" = ?", player.getId(), Igra.getId());
            if (player.getMaxPlayer() == 3) {
                jdbcTemplate.update("update \"Igra\" set \"status\" = ? where \"id\" = ?", true, Igra.getId());
            }
            ArrayList<Integer>a=new ArrayList<>();
            a.add(createIgra(igra));
            a.add(num);
            return a;
        }
        if (num == 4) {
            if (player.getMaxPlayer() == 4) {
                jdbcTemplate.update("update \"Igra\" set \"status\" = ? where \"id\" = ?", true, Igra.getId());
            }
            jdbcTemplate.update("update \"Igra\" set \"player4\" = ? where \"id\" = ?", player.getId(), Igra.getId());
            ArrayList<Integer>a=new ArrayList<>();
            a.add(createIgra(igra));
            a.add(num);
            return a;
        }
        if (num == 5) {
            if (player.getMaxPlayer() == 5) {
                jdbcTemplate.update("update \"Igra\" set \"status\" = ? where \"id\" = ?", true, Igra.getId());
            }
            jdbcTemplate.update("update \"Igra\" set \"player4\" = ? where \"id\" = ?", player.getId(), Igra.getId());
            ArrayList<Integer>a=new ArrayList<>();
            a.add(createIgra(igra));
            a.add(num);
            return a;
        }
        if (num == 6) {
            if (player.getMaxPlayer() == 6) {
                jdbcTemplate.update("update \"Igra\" set \"status\" = ? where \"id\" = ?", true, Igra.getId());
            }
            jdbcTemplate.update("update \"Igra\" set \"player4\" = ? where \"id\" = ?", player.getId(), Igra.getId());
            ArrayList<Integer>a=new ArrayList<>();
            a.add(createIgra(igra));
            a.add(num);
            return a;
        }
        ArrayList<Integer>a=new ArrayList<>();
        a.add(createIgra(igra));
        a.add(0);
        return a;
    }
    public Boolean getStatus(Integer id){
        Igra igra = jdbcTemplate.queryForObject("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        return igra.getStatus();
    }


    public Integer createIgra(Igra igra) {
        jdbcTemplate.update("insert into \"Igra\" (\"id\") values(?)", igra.getId());
        jdbcTemplate.update("insert into \"Igra\" (\"play1\") values(?)", igra.getPlay1());
        jdbcTemplate.update("insert into \"Igra\" (\"play2\") values(?)", igra.getPlay2());
        jdbcTemplate.update("insert into \"Igra\" (\"play3\") values(?)", igra.getPlay3());
        jdbcTemplate.update("insert into \"Igra\" (\"play4\") values(?)", igra.getPlay4());
        jdbcTemplate.update("insert into \"Igra\" (\"play5\") values(?)", igra.getPlay5());
        jdbcTemplate.update("insert into \"Igra\" (\"play6\") values(?)", igra.getPlay6());
        jdbcTemplate.update("insert into \"Igra\" (\"nedcol\") values(?)", igra.getNedcol());
        jdbcTemplate.update("insert into \"Igra\" (\"moneycol\") values(?)", igra.getMoneycol());
        jdbcTemplate.update("insert into \"Igra\" (\"status\") values(?)", igra.getStatus());
        jdbcTemplate.update("insert into \"Igra\" (\"playerShod\") values(?)", igra.getPlayerShod());
        return igra.getId();
    }

    public ArrayList<Integer> getStavka(int id) {
        Igra igra = (Igra) jdbcTemplate.query("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        ArrayList<Integer> rez = new ArrayList<>();
        for (int i = 0; i < igra.getMaxPlayer(); i++) {
            if (i == 0) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay1());
                rez.add(player.getStavka());
            } else if (i == 1) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay2());
                rez.add(player.getStavka());
            } else if (i == 2) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay3());
                rez.add(player.getStavka());
            } else if (i == 3) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay4());
                rez.add(player.getStavka());
            } else if (i == 4) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay5());
                rez.add(player.getStavka());
            } else if (i == 5) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay6());
                rez.add(player.getStavka());
            }

        }
        return rez;
    }

    public ArrayList<Integer> getNedcol(int id) {
        Igra igra = jdbcTemplate.queryForObject("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        return igra.getNedcol();
    }

    public ArrayList<Integer> getMoneycol(int id) {
        Igra igra = jdbcTemplate.queryForObject("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        return igra.getMoneycol();
    }

    public ArrayList<Integer> deleteIgra(Integer id) {
        Igra igra = (Igra) jdbcTemplate.query("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        ArrayList<Integer> rez = new ArrayList<>();
        for (int i = 0; i < igra.getMaxPlayer(); i++) {
            if (i == 0) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay1());
                rez.add(player.getBalance() + player.getMon());
            }else if (i == 1) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay2());
                rez.add(player.getBalance() + player.getMon());
            }else if (i == 2) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay3());
                rez.add(player.getBalance() + player.getMon());
            }else if (i == 3) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay4());
                rez.add(player.getBalance() + player.getMon());
            }else if (i == 4) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay5());
                rez.add(player.getBalance() + player.getMon());
            }else if (i == 5) {
                Player player = (Player) jdbcTemplate.query("select * from \"Player\" where \"id\"=?", new IgraMapper(), igra.getPlay6());
                rez.add(player.getBalance() + player.getMon());
            }
        }
        return rez;
    }

    public void numPlayer(int id){
        Igra igra = (Igra) jdbcTemplate.query("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        if(igra.getMaxPlayer()-1==igra.getPlayerShod()){
            igra.setPlayerShod(0);
        }
        igra.setPlayerShod(igra.getPlayerShod()+1);
    }

    public Integer getSholPlayer(int id){
        Igra igra = (Igra) jdbcTemplate.query("select * from \"Igra\" where \"id\"=?", new IgraMapper(), id);
        return igra.getPlayerShod();
    }
}
