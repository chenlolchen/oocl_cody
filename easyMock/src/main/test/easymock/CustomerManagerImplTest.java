package easymock;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
import static org.easymock.EasyMock.*;

public class CustomerManagerImplTest {
    private CustomerManagerImpl manager;
    private List<String> list;

    @Before
    public void setUp() throws Exception {
        list = strictMock(List.class);
        manager = new CustomerManagerImpl();
        manager.setList(list);
    }

    @Test
    public void addCustomer() throws Exception {
        expect(list.add("abc")).andReturn(true);
        expect(list.add("a")).andReturn(true);
        replay(list);

        boolean b = manager.addCustomer("abc", "a");
        verify(list);
        Assert.assertTrue(b);
    }

    @Test
    public void addCustomer1() throws Exception {
//        EasyMock.expect(list.add("abc")).andReturn(true);
//        EasyMock.expect(list.add("x")).andReturn(true);
//        EasyMock.replay(list);
        boolean b = manager.addCustomer("abc", "x");
        Assert.assertTrue(!b);
    }
}