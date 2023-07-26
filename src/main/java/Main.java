
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        Container container = new Container();
        container.registerDependency(UserRepository.class);

        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        userService.registerUser("Omar Quaos");
    }
}