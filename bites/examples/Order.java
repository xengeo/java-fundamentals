package bites.examples;

public class Order {

//    variable type declaration
    Integer total;

//    Constructor - constructs the instance fields (i.e. instance variables)
    public Order() {
        this.total = 0;
    }

//    Instance method:
    public void addAmount(Integer num) {
        this.total += num;
    }

//    Instance method:
    public void addDiscount(Integer discount) {
        this.total -= discount;
    }

//    Instance method:
    public Integer getTotal() {
        return this.total;
    }

//    Instance method
    public String friendlyTotal() {
        return String.format("Thanks! The total value of your order is £%d", this.getTotal());
    }

//    Main method (automatically executed when file is run)
    public static void main(String[] args) {
        Order myOrder = new Order();
        myOrder.addAmount(25);
        myOrder.addDiscount(8);
        System.out.println(myOrder.friendlyTotal());
    }

}
