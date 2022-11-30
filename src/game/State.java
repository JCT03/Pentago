package game;

import javafx.scene.paint.Color;

public enum State {
    NOWINNER {
        @Override
        public boolean playable() {return true;}
        @Override
        public Color getTitleColor() {
            return null;
        }
        @Override
        public String getTitle() {
            return null;
        }
    },
    REDWIN {
        @Override
        public boolean playable() {return false;}
        @Override
        public Color getTitleColor() {
            return Color.RED;
        }
        @Override
        public String getTitle() {
            return "Red wins!";
        }
    },
    BLACKWIN {
        @Override
        public boolean playable() {return false;}

        @Override
        public Color getTitleColor() {
            return Color.BLACK;
        }

        @Override
        public String getTitle() {
            return "Black wins!";
        }
    },
    DRAW{
        @Override
        public boolean playable() {return false;}

        @Override
        public Color getTitleColor() {
            return Color.BLUE;
        }

        @Override
        public String getTitle() {
            return "Draw!";
        }
    };
    abstract public boolean playable();
    abstract public Color getTitleColor();
    abstract public String getTitle();
}
