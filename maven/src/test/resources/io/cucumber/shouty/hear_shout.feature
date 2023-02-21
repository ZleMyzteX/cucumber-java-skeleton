Feature: Hear shout
  Scenario: Listener is within range
    Given Lucy is located 15 metres from Sean
    When Sean shouts "free bagels at Sean's"
    Then Lucy hears Sean's message

  Scenario: Listener can hear a different message
    Given Lucy is located 15 metres from Sean
    When Sean shouts "free coffee!"
    Then Lucy hears Sean's message

  Scenario: Listener can't hear a message if too far away
    Given Lucy is located 20 metres from Sean
    When Sean shouts "free coffee!"
    Then Lucy didn't hear shouted message