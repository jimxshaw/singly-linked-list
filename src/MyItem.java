import java.util.List;
import java.util.stream.Collectors;

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
        // Iterate through the int list to form a space-separated string.
        // E.g. "475 1238 9742"
        String desc = itemDescription.stream()
                                     .map(String::valueOf)
                                     .collect(Collectors.joining(" "));

        // Result should be the following string:
        // id=37, price="47", description="475 1238 9742"
        var result = new StringBuilder()
                .append("id=").append(itemID)
                .append(", price=\"").append(itemPrice).append("\"")
                .append(", description=\"").append(desc).append("\"");

        return result.toString();
    }


}
