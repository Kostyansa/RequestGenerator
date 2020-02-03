import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();

    private int userCounter = 0;

    private int itemCounter = 0;

    public String generate(Type type){
        switch (type) {
            case CUSTOMER_NAME:
                int number = random.nextInt(CONSTANT.customerNames.length);
                return "'" + "TestUser" + ++userCounter + "'";
            case PRICE:
                return Type.PRICE.getNext();
            case STRING:
            case PASSWORD:
                return Type.STRING.getNext();
            case ITEM_NAME:
                return "'" + "TestItem" + ++itemCounter + "'";
            default:
                return "EMPTY_STRING";
        }
    }
}
