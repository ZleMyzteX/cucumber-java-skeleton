# Implementation of the Cucumber-Java Skeleton featured in the BDD with Java course

Course link: https://school.cucumber.io/

Some cucumber tests and basic logic behind it.

## Overriding options

The Cucumber runtime uses configuration parameters to know what features to run,
where the glue code lives, what plugins to use etc. When using JUnit, these
configuration parameters are provided through the `@ConfigurationParameter`
annotation on your test.

For available parameters see: `io.cucumber.junit.platform.engine.Constants`

### Run a subset of Features or Scenarios

Specify a particular scenario by *line*

    @SelectClasspathResource(value = "io/cucumber/skeleton/belly.feature", line = 3)

In case you have multiple feature files or scenarios to run against repeat the
annotation.

You can also specify what to run by *tag*:

    @IncludeTags("zucchini")
