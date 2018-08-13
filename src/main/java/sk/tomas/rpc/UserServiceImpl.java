package sk.tomas.rpc;

public class UserServiceImpl implements UserService {

    private Database database;

    public UserServiceImpl() {
        database = new Database();
    }

    @Override
    public User createUser(String userName, String firstName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setPassword(password);
        database.saveUser(user);
        return user;
    }

    @Override
    public User createUser(String userName, String password) {
        return this.createUser(userName, null, password);
    }

    @Override
    public User findUserByUserName(String userName) {
        return database.findUserByUserName(userName);
    }

    @Override
    public int getUserCount() {
        return database.getUserCount();
    }
}
