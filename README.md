# h2-training-simple

To use the api directly, go to http://localhost:8080/api

To start the web application via gradle/bootRun run the following command:
gradlew bootRun

IMPORTANT NOTE:
As of gradle 6, test dependencies can no longer be used in non-test configurations.
This means that the project must use gradle 5 which requires java versions 8-11 only, unfortunately.
This will hopefully be resolved soon.