public class InventoryItem {
    private final Item item;
    private int count;
    private final int row;
    private  final int col;


    public InventoryItem(Item item, int row,int count, int col) {
        this.item = item;
        this.row = row;
        this.col = col;
        this.count=count;
    }
    public Item getItem() {
        return item;
    }
    public int getCount() {
        return count;
    }
    public void decrementCount() {
        if (count > 0) {
            count--;
        }
    }

}
