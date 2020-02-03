import com.mifmif.common.regex.Generex;

import java.math.BigDecimal;
import java.util.function.Supplier;

public enum Type{

    STRING("['][a-zA-Z0-9]{1,8}[']"),
    CUSTOMER_NAME("EMPTY_STRING"),
    ITEM_NAME("EMPTY_STRING"),
    PASSWORD("[a-zA-Z]{1,8}"),
    PRICE("\\d" + "{1," + CONSTANT.maxPriceOrder + "}" + "[.]\\d{2}");

    private final Generex generex;

    private Type(String regex){
        generex = new Generex(regex);
    }

    public String getNext() {
        return generex.random();
    }
}
