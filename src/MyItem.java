import java.util.List;

public class MyItem implements IDedObject {
    private final int itemID;
    private final int itemPrice;
    private final List<Integer> itemDescription;

    public MyItem(int id, int price, List<Integer> description) {
        itemID = id;
        itemPrice = price;
        itemDescription = description;
    }

    @Override
    public int getID() {
        return itemID;
    }

    @Override
    public String printID() {
        // TODO: Implement details formatting.
        return "";
    }


}
