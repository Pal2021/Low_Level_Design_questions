import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Integer,InventoryItem>itemLocation=new HashMap<>();
    public void addItem(InventoryItem inventoryItem){
       itemLocation.put(inventoryItem.getItem().getItemId(),inventoryItem);
    }
    public InventoryItem getItem(int itemId){
        return itemLocation.get(itemId);
    }
    public boolean isItemAvailable(int itemId) {
        InventoryItem item = itemLocation.get(itemId);
        return item != null && item.getCount() > 0;
    }

}
