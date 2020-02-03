public class Generator {

    private Schema schema;

    private RandomGenerator randomGenerator = new RandomGenerator();

    public Generator(Schema schema) {
        this.schema = schema;
    }

    public String generateInsert(Entity entity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ")
                .append(schema.database)
                .append(".")
                .append(entity.tableName).append("(");
        for (String attribute : entity.attributes.keySet()){
            stringBuilder.append(attribute).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                .deleteCharAt(stringBuilder.length() - 1)
                .append(") ")
                .append("values (");
        for (Type type: entity.attributes.values()){
            stringBuilder.append(randomGenerator.generate(type)).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                .deleteCharAt(stringBuilder.length() - 1)
                .append(");");
        return stringBuilder.toString();
    }

    public String generateSelect(Entity entity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select ");
        for (String attribute : entity.attributes.keySet()){
            stringBuilder.append(attribute).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2)
                .append("from ")
                .append(schema.database)
                .append(".")
                .append(entity.tableName);
        return stringBuilder.toString();
    }

    public String generateUpdate(Entity entity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update ")
                .append(schema.database)
                .append(".")
                .append(entity.tableName)
                .append(" set ");
        for (String attribute : entity.attributes.keySet()){
            stringBuilder.append(attribute).append(" = ")
                    .append("?")
                    .append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.append("where ")
                .append("id")
                .append(" = ");
        return stringBuilder.toString();
    }

    public String generateDelete(Entity entity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete ")
                .append("from ")
                .append(schema.database)
                .append(".")
                .append(entity.tableName)
                .append(" where ")
                .append("id")
                .append(" = ");;
        return stringBuilder.toString();
    }
}
