import com.javajosh.shiny.Logic
import org.junit.Test

import static org.junit.Assert.assertTrue

public class LogicUnitTest {
  @Test
  public void testAnd() {
    assertTrue(Logic.and(true, true))
  }

  @Test
  public void testNot() {
    assertTrue(Logic.not(false))
  }

  @Test
  public void testOr() {
    assertTrue(Logic.or(true, false))
  }
}
