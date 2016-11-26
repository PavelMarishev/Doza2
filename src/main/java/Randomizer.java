/**
 * Created by Scynet on 25.11.2016.
 */
import java.util.Random;
public class Randomizer {
    char[] chars;
    Random rand;
    public Randomizer(){
        chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
    }
    public String generate(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public int randInt(int min, int max) {
            int randomNum = rand.nextInt((max - min) + 1) + min;
            return randomNum;

    }
}