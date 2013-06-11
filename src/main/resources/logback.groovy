//This file defines mod-shiny's logging behavior. Right now, it poops stuff out to the console and to a file called log/mod-shiny.log relative to the project root.

//see http://logback.qos.ch/manual/groovy.html for docs on this file's format
//all this stuff gets imported by default:
//import ch.qos.logback.core.*;
//import ch.qos.logback.core.encoder.*;
//import ch.qos.logback.core.read.*;
//import ch.qos.logback.core.rolling.*;
//import ch.qos.logback.core.status.*;
//import ch.qos.logback.classic.net.*;
//import ch.qos.logback.classic.encoder.PatternLayoutEncoder;


appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  }
}

appender("FILE", FileAppender) {
  file = "log/mod-shiny.log"
  append = true
  encoder(PatternLayoutEncoder) {
    pattern = "%level %logger - %msg%n"
  }
}

root(DEBUG, ["FILE", "CONSOLE"])
