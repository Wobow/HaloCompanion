package com.wilyra.halocompanion.home;

/**
 * Created by wilyr on 11/25/2015.
 */
public interface DisplayInterface {
    enum DisplayStateEnum {
        DISPLAY_BOTH,
        DISPLAY_ARENA,
        DISPLAY_WARZONE
    };
    void displayArenaStats();
    void displayWarzoneStats();
    void displayBothStats();
    void displayCurrent(DisplayStateEnum state);
}
