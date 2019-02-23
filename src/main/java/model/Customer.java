package model;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Observer {
    private String fullName;
    protected List<String> notifications;

    public String getFullName() {
        return fullName;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public Customer(String fullName) {
        this.fullName = fullName;
        this.notifications = new ArrayList<>();
    }

    public void printNotifications() {
        System.out.println(notifications);
    }


    @Override
    public void update() {
        System.out.println("Dear " + fullName + ", \nnew bid has been submitted. Please review the auction.");
    }
}