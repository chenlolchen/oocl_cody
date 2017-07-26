package easymock;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CustomerManagerImpl {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public boolean addCustomer(String s1, String s2){
        if(s1.startsWith(s2)){
            boolean b1 = list.add(s1);
            boolean b2 = list.add(s2);
//            boolean b3 = list.add(s2);
            return b1 && b2;
        }else {
            return false;
        }
    }
}
