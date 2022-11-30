package game;

public enum Rotation {
    CLOCKWISE {
        @Override
        public Rotation getOpposite() {return Rotation.COUNTERCLOCKWISE;}
        @Override
        public String getText() {return "clockwise";}
        @Override
        public int getDR() {return 1;}
    },
    COUNTERCLOCKWISE {
        @Override
        public Rotation getOpposite() {return Rotation.CLOCKWISE;}
        @Override
        public String getText() {return "counterclockwise";}
        @Override
        public int getDR() {return -1;}
    };
    abstract public Rotation getOpposite();
    abstract public String getText();
    abstract public int getDR();
}
