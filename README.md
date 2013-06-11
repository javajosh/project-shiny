# Project Shiny

This is an adaptation of the vertx gradle template using groovy as the primary language.

Starting with the original template, [these are the steps that I took to get the project in this state](https://github.com/javajosh/vertx-gradle-template/commits/master) :

1. Clone
2. Remove unwanted files
3. Rename package directories (this is more easily done outside of IDEA, alas)
4. Add a groovy source directory and a groovy source file.
5. Modify mod.json
6. Run `gradle idea` to generate IDEA files - note that you must do this after you add groovy stuff.

##Open questions

1. Java source attaches nicely in IDEA - why isn't groovy source attaching?
2. How do you spin up multiple verticles?
3. Where is mod.json documented?
4. Where is the vertx version set?
5. How do I add other dependencies to the build?
6. How can I run an class that has a main() in it with gradle?
7. Where do logs go?
8. Why does RecordParser seem to want to throw an exception?

##Closed questions

1. How do you run a compiled groovy verticle? *Add `groovy:` to the mod.json*

###Apology

Some of these questions are not vertx dependant - in fact many of them are gradle dependant, a build system with which I have a few hours of experience.

