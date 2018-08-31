$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('cucumberTests\sample.feature');
formatter.feature({
  "line": 2,
  "name": "To test my cucumber test is running",
  "description": "I want to run a sample feature file.",
  "id": "to-test-my-cucumber-test-is-running",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "cucumber setup",
  "description": "",
  "id": "to-test-my-cucumber-test-is-running;cucumber-setup",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "sample feature file is ready",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I run the feature file",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "run should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.givenStatment()"
});
formatter.result({
  "duration": 548566613,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.whenStatement()"
});
formatter.result({
  "duration": 1107132,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.thenStatment()"
});
formatter.result({
  "duration": 360495,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Login scenario test for Gmail",
  "description": "",
  "id": "to-test-my-cucumber-test-is-running;login-scenario-test-for-gmail",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "navigate to Gmail page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "user logged in using username as “userA” and password as “password”",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "home page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.navigate()"
});
formatter.result({
  "duration": 90011746142,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "StepDefinition.verifySuccessful()"
});
formatter.result({
  "status": "skipped"
});
});