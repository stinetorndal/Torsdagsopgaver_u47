package flow;

public class DiscountedItems extends Item {
    private double price;
    private double discountPrice;


    public DiscountedItems(String id, String name, double price, double discountPrice) {
        super(id, name, null, 0, null);
        this.price = price;
        this.discountPrice = discountPrice;
    }

        @Override
        public double getPrice() {
            return price;
        }
    public double getNormalPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return price - discountPrice;
    }

    public String toString (){
            return super.toString() + " - " + discountPrice + " kr (normal: " + price + ")";
        }
    }


