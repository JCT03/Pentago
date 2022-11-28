package game;

import javafx.scene.paint.Color;

public enum Players {
    EMPTY {
        @Override
        public Color getFill(){return Color.BURLYWOOD;}
        @Override
        public String getText() {return "";}
        @Override
        public Players getOpponent(){return Players.EMPTY;}
    },
    RED {
        @Override
        public Color getFill(){return Color.RED;}
        @Override
        public String getText() {return "Red Player";}
        @Override
        public Players getOpponent(){return Players.BLACK;}
    },
    BLACK {
        @Override
        public Color getFill(){return Color.BLACK;}
        @Override
        public String getText() {return "Black Player";}
        @Override
        public Players getOpponent(){return Players.RED;}
    };
    abstract public Color getFill();
    abstract public String getText();
    abstract public Players getOpponent();

}
