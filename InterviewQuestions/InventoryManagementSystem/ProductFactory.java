package InterviewQuestions.InventoryManagementSystem;

import InterviewQuestions.InventoryManagementSystem.Product.ProductBuilder;

public class ProductFactory {
    public static Product createProduct(String productId, String name, String description)
    {
        return new ProductBuilder(productId).withName(name).withDescription(description).build();
    }
    
}
