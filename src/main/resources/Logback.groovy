
//imported by default:
//import ch.qos.logback.core.*;
//import ch.qos.logback.core.encoder.*;
//import ch.qos.logback.core.read.*;
//import ch.qos.logback.core.rolling.*;
//import ch.qos.logback.core.status.*;
//import ch.qos.logback.classic.net.*;
//import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

//see http://logback.qos.ch/manual/groovy.html

appender("STDOUT", ConsoleAppender) {
  layout(PatternLayout) {
    pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  }
}
  logger("com.javajosh", TRACE)
root(DEBUG, ["STDOUT"])