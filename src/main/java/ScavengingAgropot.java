import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ScavengingAgropot extends OneAndHalfMinClick{

    private Robot robot;
    private int numberOfClicks=1000;

    public ScavengingAgropot() throws Exception{
        this.robot = new Robot();
    }

    //bruk betweenTwoIntervals og mousePressRange

    public void preventLogOut(){
        try{
            //sip agropot:
            robot.keyPress(KeyEvent.VK_8);
            robot.delay(mousePressRange());
            robot.keyRelease(KeyEvent.VK_8);

            //delay i 264-279 sec => ish 4,4min - 4,65 min
            //husk at det er mult med 500 og ikke 1000, for å fikse delay issues
            robot.delay(betweenTwoIntervals(88,93));
            robot.delay(betweenTwoIntervals(88,93));
            robot.delay(betweenTwoIntervals(88,93));
            robot.delay(betweenTwoIntervals(88,93));
            robot.delay(betweenTwoIntervals(88,93));
            robot.delay(betweenTwoIntervals(88,93));

            //click mousebutton 2 to prevent logout:
            robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
            robot.delay(mousePressRange());
            robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            robot.delay(mousePressRange());

            //delay så i minst 96 s før agropot sippes på nytt/restartes:
            robot.delay(betweenTwoIntervals(96,100));
            robot.delay(betweenTwoIntervals(96,100));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("\n4 and a halv minute intervall + 1,5 start agropot to start in 2 seconds\n");

        try {
            Thread.sleep(2002);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.numberOfClicks; i++){
            this.preventLogOut();
        }
        System.out.println("process killed");
    }

    public static void main(String[] args) throws Exception {
        ScavengingAgropot scavengingAgropot = new ScavengingAgropot();
        System.out.println("initial value: " +"\t\t\t\t" + scavengingAgropot.betweenTwoIntervals(85,90)*3);
        scavengingAgropot.start();
    }
}
