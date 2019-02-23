package model;

public class AuctionService {
    private static AuctionService instance;


    private AuctionService() {
    }

    public boolean bid(Auction auction, Customer buyer, double amount) {
        if (auction.getHighestBid()<amount) {
            auction.setHighestBid(amount);
            auction.setBuyer(buyer);
            return true;
        }
        return false;
    }

    public static AuctionService getInstance(){
        if (instance == null){
            synchronized (AuctionService.class){
                if (instance == null){
                    instance = new AuctionService();
                }
            }
        }
        return instance;
    }
}