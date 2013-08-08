package com.javajosh.shiny

import groovy.util.logging.Slf4j
import org.vertx.groovy.core.buffer.Buffer
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser
import org.vertx.groovy.platform.Verticle

//see http://www.canoo.com/blog/2010/09/20/log-groovys-new-and-extensible-logging-conveniences/
@Slf4j
class GroovyVerticle extends Verticle{
  public static final int PORT = 12345
  public static final String DELIMITER = "\n"

  @Override
  Object start(){
    RecordParser parser = RecordParser.newDelimited(DELIMITER){Buffer buffer ->
      String payload = buffer.toString().trim()
      log.info("recieved delimited payload: $payload")
    }

    vertx.createNetServer().connectHandler {NetSocket socket ->
      log.info("socket open : ${socket.writeHandlerID}")

      socket.dataHandler parser.toClosure()
      socket.closeHandler { log.info("socket close: ${socket.writeHandlerID}")}
    }.listen(PORT)
    log.info("listening on port $PORT")
  }
}
