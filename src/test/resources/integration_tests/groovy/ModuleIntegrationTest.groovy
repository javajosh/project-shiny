import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser

import static org.vertx.testtools.VertxAssert.*
import org.vertx.groovy.testtools.VertxTests;

/**
 * Just try to connect to the module and say "hello from test".
 */
def testConnect() {
  container.logger.info("in testConnect()") //TODO: replace container.logger with @Slf4J annotation
  vertx.createNetClient().connect(12345, "localhost"){asyncResult ->
    if (asyncResult.succeeded) {
      NetSocket socket = asyncResult.result
      socket << "hello from the test\n"
      socket.close()
      testComplete()
    } else {
      fail("Unable to connect to verticle.")
    }
  }
}

//DON'T EDIT THESE LINES
VertxTests.initialize(this)
container.deployModule(System.getProperty("vertx.modulename"), { asyncResult ->
  assertTrue(asyncResult.succeeded())
  assertNotNull("deploymentID should not be null", asyncResult.result())
  VertxTests.startTests(this)
})



