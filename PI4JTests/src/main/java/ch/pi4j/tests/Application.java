package ch.pi4j.tests;

import java.time.Duration;

import com.pi4j.context.Context;

/**
 * This interface should be implemented by each CrowPi example / application
 */
public interface Application {
    /**
     * Represents the main application entrypoint called by the launcher.
     * This should execute whatever the application is supposed to do.
     *
     * @param pi4j Pi4J context
     */
    void execute(Context pi4j);

    /**
     * Utility function to sleep for the specified amount of milliseconds.
     * An {@link InterruptedException} will be catched and ignored while setting the interrupt flag again.
     *
     * @param duration Time to sleep
     */
    default void delay(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}