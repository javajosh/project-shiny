package com.javajosh.hyena

import org.vertx.groovy.core.buffer.Buffer
import org.vertx.groovy.core.net.NetSocket
import org.vertx.groovy.platform.Verticle


class GroovyVerticle extends Verticle{
  Object start(){
    vertx.createNetServer().connectHandler {NetSocket socket ->
      socket.dataHandler {Buffer data ->
        println "$data"
      }
    }.listen(1234)
  }
}
