package com.javajosh.shiny

import groovy.util.logging.Slf4j
import org.vertx.groovy.core.buffer.Buffer
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser
import org.vertx.groovy.platform.Verticle

//see http://www.canoo.com/blog/2010/09/20/log-groovys-new-and-extensible-logging-conveniences/
@Slf4j
class GroovyVerticle extends Verticle{
  public static int PORT = 12345

  @Override
  Object start(){
    RecordParser parser = RecordParser.newDelimited("\n"){Buffer buffer ->
      String payload = buffer.toString().trim()
      log.info("GroovyVerticle recieved delimited $payload")
    }

    vertx.createNetServer().connectHandler {NetSocket socket ->
      log.info("socket connection ${socket.writeHandlerID}")
      socket.dataHandler (parser.toClosure())
      socket.closeHandler {
        log.info("socket closed")
      }
    }.listen(12345)
    log.info("Start complete; listening on port 12345")
  }
}
