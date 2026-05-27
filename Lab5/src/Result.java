import java.util.List;
public class Result {
    private final List<Item> selectedItems;
    private final List<Integer> quantity;
    private final int totalWeight;
    private final int totalValue;

    public Result(List<Item> selectedItems, List<Integer> quantity, int totalWeight, int totalValue) {
        this.selectedItems = selectedItems;
        this.quantity = quantity;
        this.totalWeight = totalWeight;
        this.totalValue = totalValue;
    }

    public List<Item> getSelectedItems() {
        return selectedItems;
    }
    
    public List<Integer> getQuantity() {
        return quantity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sumowana waga: ").append(totalWeight).append("\n");
        sb.append("Sumowana wartość: ").append(totalValue).append("\n");
        sb.append("Wynik rpoblemu:\n");
        for (int i = 0; i < selectedItems.size(); i++) {
            Item item = selectedItems.get(i);
            int qty = quantity.get(i);
            sb.append("Item ID: ").append(item.getId())
              .append(", Weight: ").append(item.getWeight())
              .append(", Value: ").append(item.getValue())
              .append(", Quantity: ").append(qty)
              .append("\n");
        }
        return sb.toString();
    }
}
