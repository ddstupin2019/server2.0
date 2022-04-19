package com.example.prodanog.controllers;

import com.example.prodanog.entity.Player;
import com.example.prodanog.repositories.IgraRepositore;
import com.example.prodanog.repositories.PlayerRepozitore;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("dfgh367327ghciutfu6734_ju")
public class Controler {
    @Autowired
    private IgraRepositore igraRepositore;
    @Autowired
    private PlayerRepozitore playerRepozitore;

    @RequestMapping(value = "/getStavka", method = RequestMethod.GET)
    public ArrayList<Integer> getStavka(@RequestParam("id") int id){
        return igraRepositore.getStavka(id);
    }

    @RequestMapping(value = "/getNedCol", method = RequestMethod.GET)
    public ArrayList<Integer> getNedCol(@RequestParam("id") int id){
        return igraRepositore.getNedcol(id);
    }

    @RequestMapping(value = "/getMoneyCol", method = RequestMethod.GET)
    public ArrayList<Integer> getMoneyCol(@RequestParam("id") int id){
        return igraRepositore.getMoneycol(id);
    }

    @RequestMapping(value = "/deleteIgra", method = RequestMethod.DELETE)
    public ArrayList<Integer> deleteIgra(@RequestParam("id") int id){
        return igraRepositore.deleteIgra(id);
    }

    @RequestMapping(value = "/getStatus", method = RequestMethod.GET)
    public Boolean getStatus(@RequestParam("id") int id){
        return igraRepositore.getStatus(id);
    }

    @RequestMapping(value = "/setStavka", method = RequestMethod.PUT)
    public Integer setStavka(@RequestBody String param){
        try {
            JSONObject jsonObject = new JSONObject(param);
            igraRepositore.numPlayer(jsonObject.getInt("id"));
            return playerRepozitore.ubdateStavka(jsonObject.getInt("id"), jsonObject.getInt("stavka"));

        } catch (JSONException e){
            e.getStackTrace();
            System.out.println("Не удалось распарсить тело запроса");
            return 0;
        }
    }

    @RequestMapping(value = "/createPlayer", method = RequestMethod.PUT,
            consumes = "text/plain")
    public ArrayList<Integer> createPlayer(@RequestBody String param){
        Player player = new Player();
        try {
            JSONObject jsonObject = new JSONObject(param);
            player.setMaxPlayer(jsonObject.getInt("MaxPlayer"));
            player.setName(jsonObject.getString("name"));

        } catch (JSONException e){
            e.getStackTrace();
            System.out.println("Не удалось распарсить тело запроса");
            return null;
        }
        playerRepozitore.createPlayer(player);
        return igraRepositore.addPlayer(player);
    }

    @RequestMapping(value = "/getNumPlayer", method = RequestMethod.GET)
    public Integer getSholdPlayer(@RequestParam("id") int id){
        return igraRepositore.getSholPlayer(id);
    }

    



}
