package lab01;

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
    }
}
