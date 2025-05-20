# Software Tests

## Unit Tests
We wrote extensive unit tests for every functional or non-functional feature except *Visuals* and the *Joystick*. 
Not those 2 because it doesn't make sense to write unit tests for visuals and to test the Joystick we would have had to mock the entire Joystick part of the Pi4j Library.
The results can be found [here](./UnitTestResults.txt). 

## Manual Tests
For the *Visuals* and the *Joystick* we wrote [manual tests](./VisualJoystickTests.md).
The results for these can be found [here](./VisualJoystickTestResults.md)