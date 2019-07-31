package com.startech.restapi.Controller;

import com.startech.restapi.Persistence.Event;
import com.startech.restapi.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="event/")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping(path="all-events",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Event> listEvents(){
        return service.getAllEvents();
    }

    @PostMapping(path="create",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void createUser(@RequestBody Event ev){
        service.save(ev);
    }

    @GetMapping(path="events-for-day",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Event> listEventsForDay(@RequestParam(name="month")String month,@RequestParam(name="day")String day){
        return service.getEventsForDay(month, day);
    }

    @GetMapping(path="events-for-user-day",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Event> listEventsForUsersDay(@RequestParam(name="id")Long userID, @RequestParam(name="month")String month,@RequestParam(name="day")String day){
        return service.getUsersEventsForDay(userID,month, day);
    }

//    @DeleteMapping(path="delete-event")
//    @ResponseBody
//    public void deleteEventsForUsersDay(@RequestParam(name="id")Long userID, @RequestParam(name="month")String month,@RequestParam(name="day")String day,@RequestParam(name="eventIndex")int eventIndex){
//        service.deleteUsersEventForDay(userID,month, day,eventIndex);
//    }

    @DeleteMapping(path="delete-event")
    @ResponseBody
    public void deleteEventsForUsersDay(@RequestParam Event ev){
        service.deleteUsersEventForDay(ev);
    }
}
