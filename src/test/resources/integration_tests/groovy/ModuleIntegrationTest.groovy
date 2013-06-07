
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser

import static org.vertx.testtools.VertxAssert.*
import org.vertx.groovy.testtools.VertxTests;

/**
 * Just try to connect to the module.
 */
def testConnect() {
  container.logger.info("in testPing()")
  println "vertx is ${vertx.getClass().getName()}"
  vertx.createNetClient().connect(12345, "localhost"){NetSocket socket ->
    def parser = RecordParser.newDelimited("\n") { line ->
      println "$line"
    }
    socket << "hello from the test"
  }
}

VertxTests.initialize(this)
container.deployModule(System.getProperty("vertx.modulename"), { asyncResult ->
  assertTrue(asyncResult.succeeded())
  assertNotNull("deploymentID should not be null", asyncResult.result())
  VertxTests.startTests(this)
})



