package game;

public enum Quadrants {
    Q1 {
        @Override
        public String getText() {return "top right";}
    },
    Q2 {
        @Override
        public String getText() {return "top left";}
    },
    Q3 {
        @Override
        public String getText() {return "bottom left";}
    },
    Q4 {
        @Override
        public String getText() {return "bottom right";}
    };
    abstract public String getText();
}
