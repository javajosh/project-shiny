package com.javajosh.shiny;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

public class JavaVerticle extends Verticle {

    public void start() {
        vertx.eventBus().registerHandler("ping-address", new Handler<Message<String>>() {
            @Override
            public void handle(Message<String> message) {
                message.reply("pong!");
                container.logger().info("Sent back pong");
            }
        });
        container.logger().info("PingVerticle started");
    }
}
