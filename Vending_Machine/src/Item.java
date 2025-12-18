import java.math.BigDecimal;

public class Item {
    private final int itemId;
    private final BigDecimal price;
    private final String name;

    public Item(int itemId, BigDecimal price, String name) {
        this.itemId = itemId;
        this.price = price;
        this.name = name;
    }
    public int getItemId(){
        return itemId;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
}
