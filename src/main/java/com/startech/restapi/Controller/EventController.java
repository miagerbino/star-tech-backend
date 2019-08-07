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

    @GetMapping(path="events-for-user-day",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Event> listEventsForDay(@RequestParam(name="id")Long userID, @RequestParam(name="month")String month,@RequestParam(name="day")String day){
        return service.getEventsForDay(userID,month,day);
    }

    @DeleteMapping(path="delete-event")
    @ResponseBody
    public void deleteEventsForUsersDay(@RequestParam(name="id")Long userId,@RequestParam(name="month")String month,@RequestParam(name="day")String day,@RequestParam(name="eventIndex")int eventIndex){
        service.deleteUsersEventForDay(userId,month,day,eventIndex);
    }

    @GetMapping(path="event-from-day",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Event getEventFromDayAndIndex(@RequestParam(name="id")Long userID, @RequestParam(name="month")String month,@RequestParam(name="day")String day,@RequestParam(name="eventIndex")int eventIndex){
        return service.getEventFromIndex(userID,month,day,eventIndex);
    }

    @PutMapping(path="edit-event")
    @ResponseBody
    public void editEvent(){

    }

    @GetMapping(path="all-events-for-month",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Event> listEventsForDay(@RequestParam(name="id")Long userID, @RequestParam(name="month")String month, @RequestParam(name="from")String from, @RequestParam(name="to")String to){
        return service.getUsersEventsForDay(userID,month,from,to);
    }
}
