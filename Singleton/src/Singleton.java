class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(instance == null){
            // not thread safe
            instance = new LazySingleton();
        }
        return instance;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}

    // it acquires a lock on the class object. Other threads must wait until the method is executed.
    // substantial overhead and reduce performance, which can be a bottleneck if called frequently
    public static synchronized ThreadSafeSingleton getInstance(){
        if (instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

class DoubleCheckedSingleton{
    private static volatile DoubleCheckedSingleton instance;
    private DoubleCheckedSingleton(){}

    public static DoubleCheckedSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckedSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

class EagerInitialization{
    // it could potentially waste resources if the singleton instance is never used by the client application.
    private static final EagerInitialization instance = new EagerInitialization();
    private EagerInitialization(){}
    public static EagerInitialization getInstance(){
        return instance;
    }
}

class BillPughSingleton{
    private BillPughSingleton(){}

    // When the getInstance() method is called for the first time, it triggers the loading of the SingletonHelper class
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}


