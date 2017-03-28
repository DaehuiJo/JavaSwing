package Transh;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
 
public class mouseLoction {
    public mouseLoction() {
        for (int i = 0; i < 10; i++) {
            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            System.out.println("Mouse Position : " + pointerInfo.getLocation());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        new mouseLoction();
    }
}