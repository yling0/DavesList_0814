package me.yling.daveslist0814.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import me.yling.daveslist0814.models.Room;
import me.yling.daveslist0814.models.User;
import me.yling.daveslist0814.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class MainController
{
    @Autowired
    RoomRepo roomRepo;

    @GetMapping("/")
    public String showHome(Model model)
    {
        model.addAttribute("welcomemessage", "Welcome!");
        return "welcome";
    }

    @GetMapping("/index")
    public String loadList()
    {
        Iterable<Room> roomList;
        ArrayList<Room> roomAlist = new ArrayList<>();

        Room newRoom1 = new Room();
        newRoom1.set(1,"2 bedroom appartment", "no smoking", true,"basic", true, "available");

        Room newRoom2 = new Room();
        newRoom2.set(2, "1 bedroom in house","no smoking",true,"premium", false, "rented");

        roomAlist.add(newRoom1);
        roomAlist.add(newRoom2);

        roomList=roomAlist;
        roomRepo.save(roomList);
        return "index";
    }

    @GetMapping("/showlist")
    public String showList(Model model)
    {
        Iterable<Room> allrooms = roomRepo.findAll();
        model.addAttribute("allRooms", allrooms);
        return "showlist";
    }

    @GetMapping("/available")
    public String showAvailabel(Model model)
    {
        Iterable<Room> availablerooms = roomRepo.findAllByStatusIs("available");
        model.addAttribute("availableRooms",availablerooms);
        return "availableroom";
    }


    @GetMapping("/rented")
    public String showRented(Model model)
    {
        Iterable<Room> rentedrooms = roomRepo.findAllByStatusIs("rented");
        model.addAttribute("rentedRooms",rentedrooms);
        return "rentedroom";
    }



    @GetMapping("/login")
    public String showLogin(Model model)
    {
        model.addAttribute("newuser", new User());
        model.addAttribute("loginmessage", "Login here");
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("newuser") User user)
    {
        if (user.getName().equalsIgnoreCase("dave") && user.getPassword().equals("password"))
        {
            return "admin";

        } else {

            return "login";
        }

    }

    @GetMapping("/management")
    public String showManagement(Model model)
    {
        model.addAttribute("allRooms", roomRepo.findAll());
        return "davelist";
    }

    @GetMapping("/add")
    public String addRoom(Model model)
    {
        model.addAttribute("room", new Room());
        return "addroom";
    }

    @PostMapping("/process")
    public String processRoom(@Valid Room room, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "addroom";
        }
        roomRepo.save(room);
        return "redirect:/management";
    }

    @RequestMapping("/update/{id}")
    public String updateRoom(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("room", roomRepo.findOne(id));
        return "addroom";
    }

    @RequestMapping("/delete/{id}")
    public String delRoom(@PathVariable("id") long id)
    {
        roomRepo.delete(id);
        return "redirect:/management";
    }










}
