package InterviewQuestions.InventoryManagementSystem;
import java.util.*;
import java.util.concurrent.*;

//first we will need to maintain this inventory manager as singleton
//then we can have other things
//it needs to have the list of products it manages
//and the list of warehouses it manages
//we can have a hashMap for both

//Now what are the operation we need to support via this



class InventoryManager {
    private static final InventoryManager INSTANCE = new InventoryManager();
    private final Map<String, Product> products;
    private final Map<Integer, Warehouse> warehouses;

    private InventoryManager() {
        this.products = new ConcurrentHashMap<>();
        this.warehouses = new ConcurrentHashMap<>();
    }

    public static InventoryManager getInstance() {
        return INSTANCE;
    }

    public Warehouse addWarehouse(int warehouseId, String location) {
        Warehouse warehouse = new Warehouse(warehouseId, location);
        warehouses.put(warehouseId, warehouse);
        return warehouse;
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void addProductToWarehouse(String productId, int warehouseId, int initialQuantity, int threshold) {
        Warehouse warehouse = warehouses.get(warehouseId);
        Product product = products.get(productId);

        if (warehouse == null || product == null) {
            System.err.println("Warehouse or product not found");
        }

        StockItem stockItem = new StockItem(product, initialQuantity, threshold, warehouseId);
        stockItem.addObserver(new LowStockAlertObserver()); // Register the observer
        warehouse.addProductStock(stockItem);

    }

    private void updateStock(int warehouseId, String productId, int quantityChange) {
        Warehouse warehouse = warehouses.get(warehouseId);

        if (warehouse == null) {
            System.err.println("Error: Warehouse " + warehouseId + " not found.");
            return;
        }

        boolean success = warehouse.updateStock(productId, quantityChange);

    }

    public void addStock(int warehouseId, String productId, int quantity) {
        updateStock(warehouseId, productId, quantity);
    }

    public void removeStock(int warehouseId, String productId, int quantity) {
        updateStock(warehouseId, productId, -quantity);
    }

    public void viewInventory(int warehouseId) {
        Warehouse warehouse = warehouses.get(warehouseId);
        if (warehouse != null) {
            warehouse.printInventory();
        } else {
            System.err.println("Warehouse with ID " + warehouseId + " not found.");
        }
    }

}
