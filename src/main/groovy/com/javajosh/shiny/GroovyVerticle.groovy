package com.javajosh.shiny

import groovy.util.logging.Slf4j
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser
import org.vertx.groovy.platform.Verticle

//see http://www.canoo.com/blog/2010/09/20/log-groovys-new-and-extensible-logging-conveniences/
@Slf4j
class GroovyVerticle extends Verticle{
  Object start(){
    vertx.createNetServer().connectHandler {NetSocket socket ->
//      RecordParser parser = RecordParser.newDelimited("\n"){String payload ->
//        log.info("Verticle recieved $payload")
//        println "Verticle recieved $payload"
//      }
      socket.dataHandler{data ->
        log.info("$data")
        println "$data"
      }
    }.listen(12345)
    log.info("Start complete; listening on port 12345")
  }
}
