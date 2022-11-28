package game;

public enum Rotation {
    CLOCKWISE {
        @Override
        public Rotation getOpposite() {return Rotation.COUNTERCLOCKWISE;}
        @Override
        public String getText() {return "clockwise";}
    },
    COUNTERCLOCKWISE {
        @Override
        public Rotation getOpposite() {return Rotation.CLOCKWISE;}
        @Override
        public String getText() {return "counterclockwise";}
    };
    abstract public Rotation getOpposite();
    abstract public String getText();
}
