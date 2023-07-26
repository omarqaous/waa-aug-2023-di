
import java.util.HashMap;
import java.util.Map;

class Container {
    private Map<Class<?>, Object> entities;

    public Container() {
        entities = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            entities.put(clazz, instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getDependency(Class<?> clazz) {
        return entities.get(clazz);
    }
}