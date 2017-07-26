package easymock;

import org.easymock.EasyMock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */

public class BaseTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list = EasyMock.mock(List.class);
//        System.out.println(list.getClass().getName());
        EasyMock.expect(list.add("abc")).andReturn(true);
        EasyMock.expect(list.add("lol")).andReturn(true);
        EasyMock.replay(list);

        System.out.println(list.add("abc"));
        System.out.println(list.add("abc"));
        System.out.println(list.add("lol"));
//        System.out.println(list.add("1"));
    }
}
