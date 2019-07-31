package com.startech.restapi.Service;

import com.startech.restapi.Persistence.Event;
import com.startech.restapi.Persistence.EventPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class EventService {

    @Autowired
    private EventPersistence persistence;

    public List<Event> getAllEvents() {
        return persistence.findAll();
    }

    public void save(Event ev) {
        persistence.save(ev);
    }

    public List<Event> getEventsForDay(String month, String day) {
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                        .withMatcher("month", contains().ignoreCase())
                        .withMatcher("day", contains().ignoreCase());

        Event ex = new Event(null,null,null,month,day,null,null);
        Example<Event> example = Example.of(ex,matcher);

        return persistence.findAll(example);
    }

    public List<Event> getUsersEventsForDay(Long userID, String month, String day){
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                        .withMatcher("userID",contains())
                        .withMatcher("month", contains().ignoreCase())
                        .withMatcher("day", contains().ignoreCase());

        Event ex = new Event(userID, null,null,month,day,null,null);
        Example<Event> example = Example.of(ex,matcher);

        return persistence.findAll(example);
    }

    public void deleteUsersEventForDay(Event ev) {
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                        .withMatcher("userID",contains())
                        .withMatcher("title", contains().ignoreCase())
                        .withMatcher("location", contains().ignoreCase())
                        .withMatcher("month",contains())
                        .withMatcher("day", contains().ignoreCase())
                        .withMatcher("startTime", contains().ignoreCase())
                        .withMatcher("endTime", contains().ignoreCase());

        Example<Event> example = Example.of(ev,matcher);

        List <Event> excellent = persistence.findAll(example);

        Event objectToDelete = excellent.get(0);

        persistence.delete(objectToDelete);
    }
}
