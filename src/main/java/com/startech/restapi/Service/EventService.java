package com.startech.restapi.Service;

import com.startech.restapi.Persistence.Event;
import com.startech.restapi.Persistence.EventPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

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

    public void deleteUsersEventForDay(Long userId,String month,String day, int eventIndex) {
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                        .withMatcher("userId",exact())
                        .withMatcher("location", contains().ignoreCase())
                        .withMatcher("month",exact().ignoreCase())
                        .withMatcher("day", exact())
                        .withMatcher("startTime", contains().ignoreCase())
                        .withMatcher("endTime", contains().ignoreCase());

        Event ex = new Event(userId, null,null,month,day,null,null);
        Example<Event> example = Example.of(ex,matcher);

        List <Event> events = persistence.findAll(example);

        Event objectToDelete = events.get(eventIndex-1);

        persistence.delete(objectToDelete);
    }

    public Event getEventFromIndex(Long userID, String month, String day,int eventIndex){
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                        .withMatcher("userID",contains())
                        .withMatcher("month", contains().ignoreCase())
                        .withMatcher("day", contains().ignoreCase());

        Event ex = new Event(userID, null,null,month,day,null,null);
        Example<Event> example = Example.of(ex,matcher);

        return persistence.findAll(example).get(eventIndex+1);
    }

    public List<Event> getEventsForDay(Long userID, String month, String day){
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                    .withMatcher("userID",exact())
                    .withMatcher("month", exact().ignoreCase())
                    .withMatcher("day",exact());

        Event ex = new Event(userID, null,null,month,day,null,null);
        Example<Event> example = Example.of(ex,matcher);

        return persistence.findAll(example);
    }
    public List<Event> getUsersEventsForDay(final Long userID, final String month, final String from, final String to) {
        //checking for invalid inputs
        try {
            Integer.valueOf(from);
            Integer.valueOf(to);
        } catch (Exception e) {
            throw new NumberFormatException("make sure to put numbers on the to and from parameters");
        }
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                        .withMatcher("userID",exact())
                        .withMatcher("month", exact().ignoreCase());
        Event ex = new Event(userID, null,null,month,null,null,null);
        Example<Event> example = Example.of(ex,matcher);

        final List<Event> allEvents = persistence.findAll(example);
        return allEvents;
        //converting string dates to integer and comparing them
        //compareTo works as if the first > second return 1
        //if first < second return -1
        //if equal returns 0
//        final Comparator<Event> dateComparator = (o1, o2) -> {
//            Integer firstDate = Integer.valueOf(o1.getDay());
//            Integer secondDate = Integer.valueOf(o2.getDay());
//            return firstDate.compareTo(secondDate);
//        };
//        //converting start time to double and comparing
//        final Comparator<Event> startTimeComparator = Comparator.comparing(o -> Double.valueOf(o.getStartTime()));
//        return allEvents.stream()
//                //filtering bey user id
//                .filter(event -> event.getUserID().equals(userID))
//                .filter(event -> event.getMonth().equalsIgnoreCase(month))
//                .filter(event -> Integer.valueOf(event.getDay()) >= Integer.valueOf(from))
//                .filter(event -> Integer.valueOf(event.getDay()) <= Integer.valueOf(to))
//                //using the comparators that are declare above
//                .sorted(dateComparator.thenComparing(startTimeComparator))
//                //collecting all values to list and return the function
//                .collect(Collectors.toList());
    }


}
