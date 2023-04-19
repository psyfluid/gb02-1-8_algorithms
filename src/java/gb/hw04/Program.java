package gb.hw04;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            myTree.add(random.nextInt(100));
        }
        System.out.println(myTree);
    }
}
