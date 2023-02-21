package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static final List<Person> allPeople = new ArrayList<>();
    private String name;
    private final List<String> messagesHeard;
    private int position;

    public Person(String name) {
        this.name = name;
        this.messagesHeard = new ArrayList<>();
        this.position = 0;

        allPeople.add(this);
    }

    public void moveTo(Integer distance) {
        if (distance > 0 && this.position - distance > 0) {
            throw new IllegalArgumentException("Can't move under 0!");
        }
        this.position = distance;
    }

    public void shout(String message) {
        int distance;
        for (Person person : allPeople) {
            distance = getPositionDifference(person);

            if (distance <= 15) {
                person.addHeardMessage(message);
            }
        }
    }

    public int getPositionDifference(Person person) {
        int currentPosition = this.position;
        int personPosition = person.getPosition();

        if (currentPosition > personPosition) {
            return currentPosition - personPosition;
        } else {
            return personPosition - currentPosition;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public List<String> getMessagesHeard() {
        return this.messagesHeard;
    }

    public void addHeardMessage(String message) {
        this.messagesHeard.add(message);
    }
}
