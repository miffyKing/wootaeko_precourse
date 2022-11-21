package bridge.model.ScreenGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CorrectCaseGenerator implements ScreenGenerator {

    private static final int SELECT_FIRST = 1;
    private static final int SELECT_SECOND = 0;

    private List<String> secondRowAnswer;
    private List<String> firstRowAnswer;

    @Override
    public void generatedTable(List<String> answer, int current) {
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current);
        rowAppender(bridgeEachRowGenerator);
    }

    private void rowAppender(BridgeEachRowGenerator bridgeEachRowGenerator) {
        firstRowAnswer = bridgeEachRowGenerator.generateRowInList(SELECT_FIRST);
        secondRowAnswer = bridgeEachRowGenerator.generateRowInList(SELECT_SECOND);
    }

    @Override
    public String toString() {
        return firstRowAnswer.stream().collect(Collectors.joining("|", "[", "]"))
                + "\n"+ secondRowAnswer.stream().collect(Collectors.joining("|", "[", "]"));
    }
}


