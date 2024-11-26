package main.ch.IP12.prototype.utils;

public class IntUtils {
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean isRangeInRange(int valueMin, int valueMax, int min, int max) {
        for (int i = valueMin; i <= valueMax; i++) {
            if (isInRange(i, min, max)) {
                return true;
            }
        }
        return false;
    }
}
