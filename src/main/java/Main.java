import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Schema schema = new Schema("shop");
        Generator generator = new Generator(schema);

        Map<String, Type> customer = new HashMap<>();
        customer.put("fullName", Type.CUSTOMER_NAME);
        customer.put("password", Type.STRING);
        customer.put("login", Type.STRING);

        Entity customerEntity = new Entity("Customer", customer);

        System.out.println(generator.generateSelect(customerEntity));
        System.out.println(generator.generateUpdate(customerEntity));
        System.out.println(generator.generateDelete(customerEntity));

        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generateInsert(customerEntity));
        }

        Map<String, Type> item = new HashMap<>();
        item.put("name", Type.ITEM_NAME);
        item.put("description", Type.ITEM_NAME);
        item.put("price", Type.PRICE);

        Entity itemEntity = new Entity("Item", item);

        System.out.println(generator.generateSelect(itemEntity));
        System.out.println(generator.generateUpdate(itemEntity));
        System.out.println(generator.generateDelete(itemEntity));
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generateInsert(itemEntity));
        }

        Map<String, Type> bundle = new HashMap<>();
        bundle.put("name", Type.ITEM_NAME);
        bundle.put("description", Type.ITEM_NAME);
        bundle.put("price", Type.PRICE);

        Entity bundleEntity = new Entity("bundle", bundle);

        System.out.println(generator.generateSelect(bundleEntity));
        System.out.println(generator.generateUpdate(bundleEntity));
        System.out.println(generator.generateDelete(bundleEntity));
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generateInsert(bundleEntity));
        }
    }
}
