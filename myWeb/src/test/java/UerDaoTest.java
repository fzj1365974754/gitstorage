import com.dao.UsersDao;
import com.domain.Users;
import org.junit.jupiter.api.Test;


public class
UerDaoTest {
    @Test
    public void testLogin(){
        Users loginUser = new Users();
        loginUser.setUsername("lolichill");
        loginUser.setPassword("FzJ974754");
        UsersDao dao = new UsersDao();
        Users user = dao.login(loginUser);
        System.out.println(user);
    }
}
