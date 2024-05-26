package LeiLao;

public class Main {
    public static void main(String[] args) {
        AuctionHouse auctionHouse = new AuctionHouse();
        Observer manager = new Manager("Jorge", auctionHouse);
        auctionHouse.setManager(manager);

        Product product1 = new Product("Produto 0", 10);
        Product product2 = new Product("Produto 1", 4);
        Product product3 = new Product("Produto 2", 50);
        Product product4 = new Product("Produto 3", 30);
        Product product5 = new Product("Produto 4", 20);

        auctionHouse.addProduct(product1);
        auctionHouse.addProduct(product2);
        auctionHouse.addProduct(product3);
        auctionHouse.addProduct(product4);
        auctionHouse.addProduct(product5);

        Client client1 = new Client("Cliente 1");
        Client client2 = new Client("Cliente 2");
        Client client3 = new Client("Cliente 3");
        Client client4 = new Client("Cliente 4");
        Client client5 = new Client("Cliente 5");

        auctionHouse.pushAuction(0, 5);
        client1.bid(product1, 11);
        client2.bid(product1, 13);
        client1.bid(product1, 15);
        client4.bid(product1, 25);
  
        auctionHouse.pushAuction(1, 5);

        auctionHouse.pushAuction(2, 5);
        client3.bid(product3, 20);
        client2.bid(product3, 50);
        client1.bid(product3, 54);
        client4.bid(product3, 60);
        client5.bid(product3, 62);
        auctionHouse.pushAuction(3, 5);
        client1.bid(product4, 31);
        client2.bid(product4, 33);
        client1.bid(product4, 35);
        client4.bid(product4, 45);
        auctionHouse.pushAuction(4, 5);
    }
}
