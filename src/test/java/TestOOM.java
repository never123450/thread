import java.util.ArrayList;
import java.util.List;

public class TestOOM {
    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("OutOfMemoryError soon");
        }
    }
}