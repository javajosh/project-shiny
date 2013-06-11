import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser

import static org.vertx.testtools.VertxAssert.*
import org.vertx.groovy.testtools.VertxTests;

/**
 * Just try to connect to the module.
 */
def testConnect() {
  container.logger.info("in testPing()") //TODO: figure out how to get the @Slf4J annotation to work in here. Inconsistency is bad, mkay?
  println "vertx is ${vertx.getClass().getName()}"
  vertx.createNetClient().connect(12345, "localhost"){asyncResult ->
    if (asyncResult.succeeded) {
      NetSocket socket = asyncResult.result
      socket << "hello from the test"
      testComplete()
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



