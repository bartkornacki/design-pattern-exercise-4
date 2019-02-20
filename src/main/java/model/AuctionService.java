package model;

public class AuctionService {
    private static AuctionService instance;

    public AuctionService(Auction auction, Customer buyer, double amount) {
        bid(auction, buyer, amount);
    }

    public AuctionService() {
    }

    private boolean bid(Auction auction, Customer buyer, double amount) {
        if (auction.getHighestBid()<amount) {
            auction.setHighestBid(amount);
            auction.setBuyer(buyer);
            return true;
        }
        return false;
    }

    public static AuctionService getInstance(Auction auction, Customer buyer, double amount){
        if (instance == null){
            synchronized (AuctionService.class){
                if (instance == null){
                    instance = new AuctionService(auction, buyer, amount);
                }
            }
        }
        return instance;
    }
}
