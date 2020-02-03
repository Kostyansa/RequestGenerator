import java.util.Map;

public class Entity {

    public String tableName;
    public Map<String, Type> attributes;

    public Entity(String tableName, Map<String, Type> attributes) {
        this.tableName = tableName;
        this.attributes = attributes;
    }
}
