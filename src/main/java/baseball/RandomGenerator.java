package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomGenerator {

    public static final int CORRECT_INPUT_LENGTH = 3;

    public static RandomNumber generateRandom(StringBuilder sb, ArrayList<Integer> generateRandNum) {
        while (generateRandNum.size() < CORRECT_INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generateRandNum.contains(randomNumber)) {
                generateRandNum.add(randomNumber);
                sb.append(Integer.toString(randomNumber));
            }
        }
        return new RandomNumber(sb.toString());
    }
}
