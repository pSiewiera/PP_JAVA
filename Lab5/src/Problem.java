import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem {
        private final int numberOfItems;
        private final long seed;
        private final int LowerBound;
        private final int UpperBound;
        private final List<Item> items;

        public Problem(int numberOfItems, long seed, int lowerBound, int upperBound) {
            this.numberOfItems = numberOfItems;
            this.seed = seed;
            LowerBound = lowerBound;
            UpperBound = upperBound;
            this.items = new ArrayList<>();

            generateItems();
        }
        private void generateItems() {
            Random random = new Random(seed);
            for (int i = 0; i < numberOfItems; i++) {
                int range = UpperBound - LowerBound + 1;
                int weight = random.nextInt(range) + LowerBound;
                int value = random.nextInt(range) + LowerBound;

                items.add(new Item(i, weight, value));
            }
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PRoblem plecakowy");
            sb.append("\nLiczba przedmiotów: ").append(numberOfItems).append("\n");
            sb.append("seed ").append(seed).append("\n");
            sb.append("LowerBound ").append(LowerBound).append("\n");
            sb.append("UpperBound ").append(UpperBound).append("\n");
            sb.append("Przedmioty:\n");
            for (Item item : items) {
                sb.append(item).append("\n");
            }
            return sb.toString();
        }
        public Result solve(int capacity) {
            List<Item> sortedItems = new ArrayList<>(this.items);
            Collections.sort(sortedItems,(item1, item2) -> {
                double ratio1 = (double) item1.getValue() / item1.getWeight();
                double ratio2 = (double) item2.getValue() / item2.getWeight();
                return Double.compare(ratio2, ratio1);
            });
            List<Item> resultItems = new ArrayList<>();
            List<Integer> quantity = new ArrayList<>();
            int currentWeight = 0;
            int currentValue = 0;
            int remainingCapacity = capacity;

            for(Item item : sortedItems) {
                if (remainingCapacity <= 0) {
                    break;
                }
                int maxQuantity = remainingCapacity / item.getWeight();
                if (maxQuantity > 0) {
                    resultItems.add(item);
                    quantity.add(maxQuantity);
                    currentWeight += maxQuantity * item.getWeight();
                    currentValue += maxQuantity * item.getValue();
                    remainingCapacity -= maxQuantity * item.getWeight();
                }
            }
            return new Result(resultItems, quantity, currentWeight, currentValue);
        }
}
