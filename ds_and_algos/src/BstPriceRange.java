public class BstPriceRange {

    public static void main(String[] args) {
        BstPriceRange bstPriceRange = new BstPriceRange();
        BST bst = bstPriceRange.new BST();
        bst.insert(bstPriceRange.new Product("Apple", 100));
        bst.insert(bstPriceRange.new Product("Banana", 50));
        bst.insert(bstPriceRange.new Product("Orange", 150));
        bst.insert(bstPriceRange.new Product("Pineapple", 200));
        bst.insert(bstPriceRange.new Product("Kiwi", 75));
        bst.insert(bstPriceRange.new Product("Mango", 250));
        bst.insert(bstPriceRange.new Product("Peach", 125));
        bst.insert(bstPriceRange.new Product("Strawberry", 175));
        bst.insert(bstPriceRange.new Product("Watermelon", 300));
        bst.insert(bstPriceRange.new Product("Grapes", 25));
        bst.insert(bstPriceRange.new Product("Cherry", 225));
        bst.insert(bstPriceRange.new Product("Blueberry", 275));
        bst.insert(bstPriceRange.new Product("Pomegranate", 350));
        bst.insert(bstPriceRange.new Product("Guava", 150));
        bst.insert(bstPriceRange.new Product("Pear", 85));
        bst.insert(bstPriceRange.new Product("Plum", 125));
        bst.insert(bstPriceRange.new Product("Apricot", 200));
        bst.insert(bstPriceRange.new Product("Lemon", 55));
        bst.insert(bstPriceRange.new Product("Lime", 45));

        int low = 50, high = 150;
        System.out.println("Products within the price range of " + low + " and " + high + ":");
        bst.printPriceRange(low, high);
    }
    // Define product class to represent products with names and prices
    class Product {
        String name;
        int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    // Define the node class for the BST. Each node contains a `Product` object and references to its left and right children
    class ProductNode {
        Product product;
        ProductNode left;
        ProductNode right;

        public ProductNode(Product product) {
            this.product = product;
            this.left = null;
            this.right = null;
        }
    }

    class BST {
        ProductNode root;

        public BST() {
            this.root = null;
        }

        // Insert a new product into the BST
        public void insert(Product product) {
            this.root = insertRec(this.root, product);
        }

        // Recursive helper function to insert a new product into the BST
        private ProductNode insertRec(ProductNode root, Product product) {
            if (root == null) {
                root = new ProductNode(product);
                return root;
            }

            if (product.price < root.product.price) {
                root.left = insertRec(root.left, product);
            } else if (product.price > root.product.price) {
                root.right = insertRec(root.right, product);
            }

            return root;
        }

        // Print all products within a given price range
        public void printPriceRange(int low, int high) {
            printPriceRangeRec(this.root, low, high);
        }

        // Recursive helper function to print all products within a given price range
        private void printPriceRangeRec(ProductNode root, int low, int high) {
            if (root == null) {
                return;
            }

            if (root.product.price > low) {
                printPriceRangeRec(root.left, low, high);
            }

            if (root.product.price >= low && root.product.price <= high) {
                System.out.println(root.product.name + " - " + root.product.price);
            }

            if (root.product.price < high) {
                printPriceRangeRec(root.right, low, high);
            }
        }
    }
}