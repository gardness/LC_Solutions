package Test;

import java.util.*;

public class HashMapTest {
    static class Product {
        private String name;
        private String description;
        private List<String> tags;

        Product(String name, String description) {
            this(name, description, null);
        }

        Product(String name, String description, List<String> tags) {
            this.name = name;
            this.description = description;
            this.tags = new LinkedList<>(tags);
        }

        public String getName() {
            return name;
        }

        public List<String> getTags() {
            return tags;
        }

        public Product addTagsOfOtherProduct(Product product) {
            this.tags.addAll(product.getTags());
            return this;
        }
    }

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road Bike", "A bike for competition");

        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);

        Product nextPurchase = productsByName.get("E-Bike");

        Product defaultProduct = new Product("Chocolate", "At least buy chocolcate");

        productsByName.put(null, defaultProduct);
        productsByName.put(null, null);
        productsByName.remove("E-Bike");
        productsByName.containsKey("E-Bike");
        productsByName.containsValue(eBike);

        for (Map.Entry<String, Product> entry : productsByName.entrySet()) {
            Product product = entry.getValue();
            String key = entry.getKey();
        }

    }
}
