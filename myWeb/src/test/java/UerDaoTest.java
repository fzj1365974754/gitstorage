import com.daoiml.UserDaoIml;
import com.serviceIml.UserServiceIml;
import com.domain.Users;
import org.junit.jupiter.api.Test;

import java.util.List;


public class
UerDaoTest {
    @Test
    public void testLogin(){

        UserDaoIml udi = new UserDaoIml();
        Users users = new Users();
        users.setUsername("apple");
        users.setUserid(4);
        users.setPassword("123");
        users.setEmail("123456");
        System.out.println(users);
        udi.update(users);
    }
}
