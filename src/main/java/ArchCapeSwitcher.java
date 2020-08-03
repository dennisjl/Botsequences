import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

//Assign the archcapes, (hooded and unhooded) to J and K, then run this for permanent boost
//jj

public class ArchCapeSwitcher {

    private Robot robot;
    private int Min=1*1000;     //avstanden mellom clicks
    private int Max=1*1200;
    //private int Min=11*1000;
    //private int Max=12*1000;
    private int numberOfClicks = 200000;

    public ArchCapeSwitcher() throws Exception{
        this.robot = new Robot();
    }

    public void killSwitch(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }


    public void leftClick(){
        // this method only press the button, does not ret lease

        try {

            robot.keyPress(KeyEvent.VK_J);
            robot.delay(134 + (int)(Math.random() * ((193 - 134) + 1)));
            robot.keyRelease(KeyEvent.VK_J);
            robot.delay(139 + (int)(Math.random() * ((169 - 139) + 1)));

            //robot.delay(1239);
            robot.delay(Max + (int)(Math.random() * ((1269 - 1239) + 1)));

            robot.keyPress(KeyEvent.VK_K);
            robot.delay(144 + (int)(Math.random() * ((188 - 144) + 1)));
            robot.keyRelease(KeyEvent.VK_K);
            robot.delay(131 + (int)(Math.random() * ((178 - 131) + 1)));

            robot.delay(Max + (int)(Math.random() * ((1269 - 1239) + 1)));

        }


        catch (Exception e){
            e.printStackTrace();
        }
    }



    public void start() {
        System.out.println("Automatical capeswitcher to start in 2 seconds");

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
        ArchCapeSwitcher archCapeSwitcher = new ArchCapeSwitcher();
        archCapeSwitcher.start();

    }

}
