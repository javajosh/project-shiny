import com.javajosh.shiny.GroovyVerticle
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser

import static org.vertx.testtools.VertxAssert.*
import org.vertx.groovy.testtools.VertxTests;

/**
 * Just try to connect to the module and say "hello from test".
 */
def testConnect() {
   //TODO: replace container.logger with @Slf4J annotation
  vertx.createNetClient().connect(GroovyVerticle.PORT, "localhost"){asyncResult ->
    if (asyncResult.succeeded) {
      //container.logger.info("testConnect() succeeded in connecting to ${System.getProperty("vertx.modulename")} on port ${GroovyVerticle.PORT}")
      NetSocket socket = asyncResult.result
      //We can attach a listener to the socket hear to see if it responds with anything.
      socket << ("hello from the test" + GroovyVerticle.DELIMITER)
      socket << ("goodbye from the test" + GroovyVerticle.DELIMITER)
      socket.close()
      //container.logger.info("testConnect() disconnected from socket")
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



