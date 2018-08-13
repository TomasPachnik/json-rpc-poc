package sk.tomas.rpc;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<String, User> map;

    public Database() {
        map = new HashMap<>();
    }

    void saveUser(User user) {
        map.put(user.getUserName(), user);
    }

    User findUserByUserName(String userName) {
        return map.get(userName);
    }

    int getUserCount() {
        return map.size();
    }

}
