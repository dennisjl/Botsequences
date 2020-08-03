import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;


//metoden clicker en gang på 80-85 sekunder, denne kan justeres
//dette er definert i betweenTwoIntervals, men delayet
//      må multipliseres på 2, siden java.robot ikke tillater mer enn
//      60k ms i delay
public class OneAndHalfMinClick {

    private Robot robot;
    //private int numberOfClicks = 200000;
    private int numberOfClicks = 200; /*et klikk per 90 s, på 4,5 timer*/

    public OneAndHalfMinClick() throws Exception {
        this.robot = new Robot();
    }

    /*
    * returns a random number between two numbers*/

    public int betweenTwoIntervals(int interval1Min, int intervalMax){
        Random random = new Random();
        int randomNumber = random.nextInt((intervalMax-interval1Min) + 1) +interval1Min;
        //random number between 1000 and 1100
        Random random1000 = new Random();
        int timesThousandPlusThreshold = random1000.nextInt(515-500) +500;

        int timeinterval = randomNumber*timesThousandPlusThreshold;
        System.out.println("random number generated: " +"\t" + timeinterval*2);

        return timeinterval;
    }
    /*må fikse 2*40k ish, fordi java robot er fakka og vil ikke tillate mer enn 60k*/

    /*random mousehastighet*/
    public int mousePressRange(){
        int mousepress = 91;
        int mouserelease = 253;
        int range = (mouserelease-mousepress) +1;
        return (int)(Math.random() * range) + mousepress;
    }


    public void clickShit(){
        try{
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(mousePressRange());
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(mousePressRange());

            //må gjøre denne to ganger, siden det er delayed
            robot.delay(betweenTwoIntervals(80,85));
            robot.delay(betweenTwoIntervals(80,85));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void start() {
        System.out.println("\n90 s intervall to start in 2 seconds\n");

        try {
            Thread.sleep(2002);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.numberOfClicks; i++){
            this.clickShit();
        }
        System.out.println("process killed");
    }

    public static void main(String[] args) throws Exception {
        OneAndHalfMinClick oneAndHalfMinClick = new OneAndHalfMinClick();
        System.out.println("initial value: " +"\t\t\t\t" + oneAndHalfMinClick.betweenTwoIntervals(80,85)*2);
        oneAndHalfMinClick.start();



    }

}
