import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AfkHerblore {

    private Robot robot;
    private int Min=16*1000;
    private int Max=18*1000;
    //private int Min=11*1000;
    //private int Max=12*1000;
    private int numberOfClicks = 200000;

    public AfkHerblore() throws Exception {
        this.robot = new Robot();
    }

    public void leftClick(){
        // this method only press the button, does not ret lease
        try {

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(149 + (int)(Math.random() * ((173 - 149) + 1)));
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(152 + (int)(Math.random() * ((177 - 152) + 1)));

            //robot.delay(1503);
            robot.delay(1503 + (int)(Math.random() * ((1599 - 1503) + 1)));

            robot.keyPress(KeyEvent.VK_F9);
            robot.delay(134 + (int)(Math.random() * ((193 - 134) + 1)));
            robot.keyRelease(KeyEvent.VK_F9);
            robot.delay(139 + (int)(Math.random() * ((169 - 139) + 1)));

            //robot.delay(1239);
            robot.delay(1239 + (int)(Math.random() * ((1269 - 1239) + 1)));

            robot.keyPress(KeyEvent.VK_9);
            robot.delay(144 + (int)(Math.random() * ((188 - 144) + 1)));
            robot.keyRelease(KeyEvent.VK_9);
            robot.delay(131 + (int)(Math.random() * ((178 - 131) + 1)));

            //robot.delay(1249);
            robot.delay(1249 + (int)(Math.random() * ((1299 - 1249) + 1)));

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.delay(124 + (int)(Math.random() * ((189 - 124) + 1)));
            robot.keyRelease(KeyEvent.VK_SPACE);
            //robot.delay(132);
            robot.delay(132 + (int)(Math.random() * ((169 - 132) + 1)));


            //robot.delay(5013);

            //robot.delay(randomRange(20000,clickDelay));  //random delay between clicks, starting from 5
            robot.delay(Min + (int)(Math.random() * ((Max - Min) + 1)));

        }


        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void start() {
        System.out.println("Herblore bot to start in 2 seconds");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.numberOfClicks; i++){
            this.leftClick();
        }
        System.out.println("AC FIN");
    }

    public static void main(String[] args) throws Exception {
        AfkHerblore afkHerblore = new AfkHerblore();
        afkHerblore.start();

    }

}
