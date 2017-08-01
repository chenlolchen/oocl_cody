package service;

/**
 * Created by CHENCO7 on 8/1/2017.
 */
public class AreaManagerFactory {
    private static AreaManager manager;

    public static AreaManager getInstance(){
        if (manager == null){
            manager = new AreaManagerImpl();
        }
        return manager;
    }
}
