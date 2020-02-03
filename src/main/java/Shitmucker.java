import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Shitmucker {

    private Robot robot;
    private int clickDelay = 30*1000;
    private int numberOfClicks = 200000;

    private int mousepress = 91;
    private int mouserelease = 253;

    public Shitmucker() throws Exception {
        this.robot = new Robot();
    }

    public int randomRange(int lowerTimeBound, int upperTimeBound){
        int range = (upperTimeBound-lowerTimeBound) + 1;
        return (int)(Math.random() * range) + lowerTimeBound;
    }

    public int mousePressRange(){
        int range = (mouserelease-mousepress) +1;
        return (int)(Math.random() * range) + mousepress;
    }


    public void clickShit(){
        try{
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(mousePressRange());
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(randomRange(500, clickDelay));

            /**se på denne senere. noe bugga**/
            /**
            robot.mousePress(KeyEvent.VK_NUMPAD7);
            robot.delay(104);
            robot.mouseRelease(KeyEvent.VK_NUMPAD7);

            robot.mousePress(KeyEvent.VK_NUMPAD3);
            robot.delay(104);
            robot.mouseRelease(KeyEvent.VK_NUMPAD3);
            **/


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void start() {
        System.out.println("SHitmucker starts in 2 seconds");

        try {
            Thread.sleep(2002);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.numberOfClicks; i++){
            this.clickShit();
        }
        System.out.println("shitmucker killed");
    }

    public static void main(String[] args) throws Exception {
        StupidCutter stupidCutter = new StupidCutter();

        Shitmucker shitmucker = new Shitmucker();
        shitmucker.start();

    }

}
