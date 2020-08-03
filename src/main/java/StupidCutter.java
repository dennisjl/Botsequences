import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

//this is the working one
public class StupidCutter {

    private Robot robot;
    private int clickDelay = 59*1000;
    private int numberOfClicks = 200000;

    public StupidCutter() throws Exception {
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
            robot.delay(151);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay( 153);

            robot.keyPress(KeyEvent.VK_8);
            robot.delay(604);
            robot.keyRelease(KeyEvent.VK_8);
            robot.delay(159);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.delay(606);
            robot.keyRelease(KeyEvent.VK_SPACE);



            robot.delay(5034);

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            // adds static delayp
            robot.delay(157);
            //release mousepress
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            //robot.delay(delay);                    static delay
            robot.delay(randomRange(20019,clickDelay));  //random delay between clicks, starting from 5
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void start() {
        System.out.println("AC start in 2 seconds");

        try {
            Thread.sleep(    2002);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.numberOfClicks; i++){
            this.bundleCut();
        }
        System.out.println("AC FIN");
    }

    public static void main(String[] args) throws Exception {
        StupidCutter stupidCutter = new StupidCutter();
        stupidCutter.start();

    }

}
