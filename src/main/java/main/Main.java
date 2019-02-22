package main;

import model.*;

import java.time.LocalDateTime;

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


        auctionService.bid(auction,new Customer("Anna Kowalik"),20);
        notifier.notifiedObservers();
        auctionService.bid(auction,new Customer("Krzysztof Adamowicz"),25);
        notifier.notifiedObservers();
        auctionService.bid(auction,new Customer("Krzysztof Adamowicz"),35);
        notifier.notifiedObservers();
        System.out.println("Auction with id: " + auction.getId()+ " finished. Highest bid: " + auction.getHighestBid() + " PLN.");
    }
}
