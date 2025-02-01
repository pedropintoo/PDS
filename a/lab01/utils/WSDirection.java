/*
 * Created on Mon Feb 26 2024
 *
 * Copyright (c) 2024 - Pedro Pinto (pmap@ua.pt) ; Guilherme Santos (gui.santos91@ua.pt)
 */
package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum WSDirection {
    UP {
        public String toString() {
            return "Up";
        }
    },
    RIGHT_UP{
        public String toString() {
            return "UpRight";
        }
    },
    RIGHT{
        public String toString() {
            return "Right";
        }
    },
    RIGHT_DOWN{
        public String toString() {
            return "DownRight";
        }
    },
    DOWN{
        public String toString() {
            return "Down";
        }
    },
    LEFT_DOWN{
        public String toString() {
            return "DownLeft";
        }
    },
    LEFT{
        public String toString() {
            return "Left";
        }
    },
    LEFT_UP{
        public String toString() {
            return "UpLeft";
        }
    };

    private static final List<WSDirection> DIRECTIONS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = DIRECTIONS.size();
    private static final Random RANDOM = new Random();

    public static WSDirection randomDirection() {
        return DIRECTIONS.get(RANDOM.nextInt(SIZE));
    }
}
