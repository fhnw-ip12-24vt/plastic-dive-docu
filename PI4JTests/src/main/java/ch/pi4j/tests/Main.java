package ch.pi4j.tests;

import com.pi4j.Pi4J;

public class Main {

    public static void main(String[] args) {
        var pi4j = Pi4J.newAutoContext();

        JoystickAnalog_App joystickAnalogApp = new JoystickAnalog_App();
        joystickAnalogApp.execute(pi4j);

    }
}