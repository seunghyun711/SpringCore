package hello.core.singleton;

public class SingletonService {
    // static 으로 지정하여 클래스 레벨로 지정되어 1개만 존재하게 된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
