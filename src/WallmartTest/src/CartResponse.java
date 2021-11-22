import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CartResponse {
    public static HashMap<String, ArrayList<Item>> returnResponse(ArrayList<Item> items){

        HashMap<String, ArrayList<Item>> map = new HashMap<>();
        for(Item i : items){
            ArrayList<Item> newList = new ArrayList<>();
            if(map.containsKey(i.category)){
                newList = map.get(i.category);
                newList.add(i);
                map.put(i.category,newList);
            } else{
                newList.add(i);
                map.put(i.category,newList);
            }
        }

        return map;
    }

    public static void main(String[] args){
        Item i1 = new Item();
        i1.setCategory("Fresh and Frozen");
        i1.setItemId(1);
        i1.setName("Milk");
        i1.setPrice("2");
        i1.setQuantity(1);


        Item i2 = new Item();
        i2.setCategory("Fresh and Frozen");
        i2.setItemId(2);
        i2.setName("Egg");
        i2.setPrice("2");
        i2.setQuantity(1);


        Item i3 = new Item();
        i3.setCategory("Clothing");
        i3.setItemId(3);
        i3.setName("ClothingShirt");
        i3.setPrice("2");
        i3.setQuantity(1);

        ArrayList<Item> items = new ArrayList<>(3);
        items.add(i1);
        items.add(i2);
        items.add(i3);

        HashMap<String, ArrayList<Item>> map = returnResponse(items);

    }

}

class Item{
    int itemId;
    String name;
    String category;
    String price;
    int quantity;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
