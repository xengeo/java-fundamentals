package bites.examples;

public class Order {

    Integer total = 0;

    public void addAmount(Integer amount) {
        this.total += amount;
    }

    public void addDiscount(Integer amount) {
        this.total -= amount;
    }

    public Integer getTotal() {
        return this.total;
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.addAmount(10);
        order.addDiscount(1);
        String friendlyTotal = order.friendlyTotal();
        System.out.println(friendlyTotal);
    }

    private String friendlyTotal() {
        return String.format("Thanks! The total value of your order is £%d", this.total);
    }
}
