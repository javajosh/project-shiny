import com.javajosh.shiny.GroovyVerticle
import org.vertx.groovy.core.net.NetSocket

import static org.vertx.testtools.VertxAssert.*
import org.vertx.groovy.testtools.VertxTests;

/**
 * Connect to the module and say "hello from test".
 */
def testConnect() {
   //TODO: replace container.logger with @Slf4J annotation
  vertx.createNetClient().connect(GroovyVerticle.PORT, "localhost"){asyncResult ->
    if (asyncResult.succeeded) {
      NetSocket socket = asyncResult.result
      socket << ("hello from the test" + GroovyVerticle.DELIMITER)
      socket << ("goodbye from the test" + GroovyVerticle.DELIMITER)
      socket.close()
      testComplete()
    } else {
      fail("Unable to connect to verticle.")
    }
  }
}

//Actually launch the tests
VertxTests.initialize(this)
container.deployModule(System.getProperty("vertx.modulename"), { asyncResult ->
  assertTrue(asyncResult.succeeded())
  assertNotNull("deploymentID should not be null", asyncResult.result())
  VertxTests.startTests(this)
})



