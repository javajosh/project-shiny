import com.javajosh.shiny.Logic
import org.junit.Test

import static org.junit.Assert.assertTrue


public class LogicUnitTest {

  @Test
  public void testAnd() {
    assertTrue(Logic.and(true, true))
    assertTrue(Logic.not(false))
    assertTrue(Logic.or(true, false))
  }
}
