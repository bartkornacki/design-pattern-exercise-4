package main;

import model.*;

public class Main {
    public static void main(String[] args) {
        Customer seller = new Customer("Jan Kowalski");
        Customer seller1 = new Customer("Jan Nowak");
        Auction auction = new Auction.AuctionBuilder()
                .withId(1)
                .withSeller(seller)
                .withDescription("Dupa")
                .build();

        AuctionService auctionService = AuctionService.getInstance();
        Notifier notifier = new NotifierImp();
        notifier.registerObserver(seller);

        Customer customer1 = new Customer("Anna Kowalik");
        Customer customer2 = new Customer("Krzysztof Adamowicz");
        Customer customer3 = new Customer("Krzysztof Adamowicz");

        notifier.registerObserver(customer1);
        notifier.registerObserver(customer2);
        notifier.registerObserver(customer3);

        auctionService.bid(auction, customer1,20);
        notifier.notifyObservers();
        auctionService.bid(auction, customer2,25);
        notifier.notifyObservers();
        auctionService.bid(auction, customer3,35);
        notifier.notifyObservers();
//        System.out.println("Auction with id: " + auction.getId()+ " finished. Highest bid: " + auction.getHighestBid() + " PLN.");
    }
}