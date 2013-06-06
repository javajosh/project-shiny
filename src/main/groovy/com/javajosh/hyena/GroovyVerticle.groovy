package com.javajosh.hyena

import org.vertx.groovy.core.buffer.Buffer
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.core.parsetools.RecordParser
import org.vertx.groovy.platform.Verticle


class GroovyVerticle extends Verticle{
  Object start(){
    vertx.createNetServer().connectHandler {NetSocket socket ->
      RecordParser parser = RecordParser.newDelimited("\n"){String payload ->
        //println "$payload"
      }
      socket.dataHandler (parser.toClosure())
    }.listen(12345)
  }
}
