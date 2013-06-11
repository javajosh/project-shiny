# Project Shiny

Goal: create a working Vert.x projec using compiled Groovy verticles, Logback-based logging, and working unit and integration tests.

Starting with the original template, [these are (roughly) the steps that I took to get the project in this state](https://github.com/javajosh/vertx-gradle-template/commits/master) :

1. Clone
2. Remove unwanted files
3. Rename package directories (this is more easily done outside of IDEA, alas)
4. Add a groovy source directory and a groovy source file.
5. Modify mod.json
6. Run `gradle idea` to generate IDEA files - note that you must do this after you add groovy stuff.

##Open questions

1. Java source attaches nicely in IDEA - why isn't groovy source attaching?
2. How do you spin up multiple verticles?
3. <s>Where is mod.json documented?<s>  https://github.com/vert-x/vert.x/blob/docs_2.0.0/core_manual_groovy.md
4. <s>Where is the vertx version set?<s> gradle.properties#vertxVersion. Valid strings can be inferred from https://github.com/vert-x/vert.x/tags, and what you get with those tags in the google group. It's pretty informal at this point.
5. <s>How do I add other dependencies to the build?</s> Add a line to build.gradle like `compile group: 'ch.qos.logback', name: 'logback-classic', version: '1.0.13'`. Values can be inferred from maven repository values such as [this mvnrepository.com entry for logback](http://mvnrepository.com/artifact/ch.qos.logback/logback-classic/1.0.13)
6. How can I run an class that has a main() in it with gradle?
7. Where do logs go?
8. <s>Why does RecordParser seem to want to throw an exception?</s> Compiled groovy verticles need to have special strings in mod.json.

##Closed questions

1. How do you run a compiled groovy verticle? *Add `groovy:` to the mod.json*

###Apology

Some of these questions are not vertx dependant - in fact many of them are gradle dependant, a build system with which I have a few hours of experience.

