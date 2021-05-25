import com.dao.UseDao;
import com.service.UseService;
import com.service.UserService;
import com.utlis.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SpringTest {
    @Test
    public void test1(){
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //对应XML的ID
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UseService UseService =(UseService)app.getBean("useService");
        System.out.println(UseService);
        UseService.save();
    }
}
