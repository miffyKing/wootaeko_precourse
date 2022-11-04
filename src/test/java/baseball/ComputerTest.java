package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class ComputerTest {
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  @Order(1)
  void computerPrintStartGame() {
    //User.inputValueTestPlayingMode("123");
    Computer.testComputerPrint(1);
    Assertions.assertThat("숫자 야구 게임을 시작합니다.").isEqualTo(outContent.toString().trim());
  }

  @Test
  @Order(2)
  void computerPrintInputNumber() {
    //User.inputValueTestPlayingMode("123");
    Computer.testComputerPrint(2);
    Assertions.assertThat("숫자를 입력해주세요 : ").isEqualTo(outContent.toString());
  }

}