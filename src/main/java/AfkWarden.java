import java.awt.*;
import java.awt.event.InputEvent;

public class AfkWarden {

    private Robot robot;
    private int clickDelay = 59*1000;
    //private int numberOfClicks = 200000;
    private int numberOfClicks = 1000; // 1000 clicks med ish 5 sec mellomrom er ish en time

    public AfkWarden() throws Exception {
        this.robot = new Robot();
    }

    public int randomRange(int lowerTimeBound, int upperTimeBound){
        int range = (upperTimeBound-lowerTimeBound) + 1;
        return (int)(Math.random() * range) + lowerTimeBound;
    }

    public void leftClick(){
        // this method only press the button, does not ret lease
        try {

            robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
            robot.delay(149);
            robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            robot.delay(152);

            robot.delay(5013);

            robot.delay(randomRange(20000,clickDelay));  //random delay between clicks, starting from 5
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void start() {
        System.out.println("Warden start in 2 seconds");

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
        AfkWarden afkWarden = new AfkWarden();
        afkWarden.start();

    }

}
