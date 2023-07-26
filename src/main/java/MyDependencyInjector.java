import java.lang.reflect.Field;

class MyDependencyInjector implements IDependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyInjector.class)) {
                Object dependency = container.getDependency(field.getType());
                if (dependency != null) {
                    try {
                        field.setAccessible(true);
                        field.set(target, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}