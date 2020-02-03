public class xxTest {

    public int randomRange(int lowerTimeBound, int upperTimeBound){
        int range = (upperTimeBound-lowerTimeBound) + 1;
        return (int)(Math.random() * range) + lowerTimeBound;
    }


    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println((int)(Math.random()*5));
    }

}
