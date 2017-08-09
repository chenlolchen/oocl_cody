import com.oocl.service.WorkService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkService workService = (WorkService) context.getBean("ws");
        workService.work("chen");
    }
}
