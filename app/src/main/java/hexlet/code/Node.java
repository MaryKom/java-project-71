package hexlet.code;

public class Node {
    private final String typeOfChange;
    private final String key;
    private final Object oldValue;
    private final Object newValue;

    public Node(String type, String thisKey, Object newValue, Object oldValue) {
        this.typeOfChange = type;
        this.key = thisKey;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public final String getTypeOfChange() {
        return typeOfChange;
    }

    public final String getKey() {
        return key;
    }

    public final Object getOldValue() {
        return oldValue;
    }

    public final Object getNewValue() {
        return newValue;
    }
}
