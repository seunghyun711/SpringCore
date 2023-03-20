package hello.core.singleton;

public class StatefulService {
//    private int price; // 상태 유지하는 필드

//    // stateful 하게 설계된 코드
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
//    }

    // stateless 코드
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
