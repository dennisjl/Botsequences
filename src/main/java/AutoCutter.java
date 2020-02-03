
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AutoCutter {

    private Robot robot;
    private int timeBetweenClick;
    private int oneSecond = 1000;
    private int oneMinute = oneSecond*60;

    /**
     * leste verdier fra keylistener
     */
    private int location1X = 801;
    private int location1Y = 507;

    private int location2X = 948;
    private int location2Y = 614;


    public AutoCutter() throws AWTException {
        this.robot = new Robot();
    }

    public int randomRange(int lowerTimeBound, int upperTimeBound){
        int range = (upperTimeBound-lowerTimeBound) + 1;
        return (int)(Math.random() * range) + lowerTimeBound;
    }

    public int zeroOrOne(){
        int range= (1-0) +1;
        return ((int)(Math.random() * range));
    }

    /**
     * should chose 1 of the 2 given random locations
     */
    public void chooseRandomLocation(){
        int i = this.zeroOrOne();
        //int i = ((int) (Math.random()+0.5));
        System.out.println(i);
        if(i==0){
            robot.mouseMove(location1X, location1Y);
        }
        if(i==1){
            robot.mouseMove(location2X, location2Y);
        }

    }


    public void bundleCut(int button){
        /**
         * theese 4 is for bundling
         */
        robot.keyPress(KeyEvent.VK_T);
        robot.delay(oneSecond);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(oneSecond*12);

        /**
         * Move mouse to one of 2 posisions
         */
        /*robot.mouseMove(location1X, location1Y);
        robot.mouseMove(location2X, location2Y);*/
        chooseRandomLocation();

        /**
         * mouseclick once every 2-3 minutes
         */
        robot.mousePress(button);
        robot.mouseRelease(button);
        //robot.delay(oneMinute*3);
        robot.delay(randomRange((oneMinute/2), oneMinute));
    }

    public void start() throws InterruptedException {
        System.out.println("Program start in 1 seconds");
        Thread.sleep(oneSecond);

        for(int i = 0; i<100000; i++){
            this.bundleCut(InputEvent.BUTTON1_DOWN_MASK);
        }

    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        AutoCutter autoCutter = new AutoCutter();
        autoCutter.start();

    }

}
