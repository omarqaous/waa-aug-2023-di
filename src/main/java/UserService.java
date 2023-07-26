public class UserService {
    @MyInjector
    private UserRepository userRepository;

    public void registerUser(String name) {
        userRepository.persistUser(name);
    }
}