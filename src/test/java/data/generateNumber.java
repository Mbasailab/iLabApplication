package data;
import java.util.Random;

public class generateNumber
{
    public String PhoneNo ()
    {
        Random rand = new Random();
        int firstNum = 0;
        int[] carrId = {6, 7, 8};
        int afterCarrierId = rand.nextInt(10);
        int randomIndexForCarrierId = rand.nextInt(carrId.length);
        String first3 = firstNum + "" + carrId[randomIndexForCarrierId] + "" + afterCarrierId;
        int rangeForSecondSet = 1000;
        int second3 = rand.nextInt(rangeForSecondSet);
        int rangeForlastSet = 10000;
        int last4 = rand.nextInt(rangeForlastSet);

        String phoneNum = first3 + " " + second3 + " " + last4;
        return phoneNum;

    }
}
