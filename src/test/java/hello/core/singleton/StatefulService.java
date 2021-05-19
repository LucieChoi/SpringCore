package hello.core.singleton;

/**
 * 테스트 코드 만들 때 : ctrl+shift+T 이라는데 왜 난 안되는걸까
 * 그냥 alt+enter로 create test  했음
 */

public class StatefulService {

    private int price; //상태를 유지하는 필드

    //뭔가 주문과 관련된
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!
    }

    public int getPrice() {
        return price;
    }
}