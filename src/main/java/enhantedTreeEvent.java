import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class enhantedTreeEvent {

    private Robot robot;
    private int clickDelay = 59*1000;
    private int numberOfClicks = 200000;

    public enhantedTreeEvent() throws Exception {
        this.robot = new Robot();
    }

    public int randomRange(int lowerTimeBound, int upperTimeBound){
        int range = (upperTimeBound-lowerTimeBound) + 1;
        return (int)(Math.random() * range) + lowerTimeBound;
    }

    public void bundleCut(){
        // this method only press the button, does not ret lease
        try {

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(150);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(150);

            robot.keyPress(KeyEvent.VK_1);
            robot.delay(600);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(150);

            robot.delay(5000);

            robot.keyPress(KeyEvent.VK_1);
            robot.delay(600);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(150);

            robot.delay(1000);

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            // adds static delayp
            robot.delay(150);
            //release mousepress
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            //robot.delay(delay);                    static delay

            robot.keyPress(KeyEvent.VK_1);
            robot.delay(600);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(150);

            robot.delay(1000);

            robot.keyPress(KeyEvent.VK_1);
            robot.delay(600);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(150);

            robot.delay(5000);

            robot.delay(randomRange(20000,clickDelay));  //random delay between clicks, starting from 5
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void start() {
        System.out.println("zzClicker starts in 2 seconds");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.numberOfClicks; i++){
            this.bundleCut();
        }
        System.out.println("AC FIN");
    }

    public static void main(String[] args) throws Exception {
        enhantedTreeEvent e1 = new enhantedTreeEvent();
        e1.start();

    }

}
