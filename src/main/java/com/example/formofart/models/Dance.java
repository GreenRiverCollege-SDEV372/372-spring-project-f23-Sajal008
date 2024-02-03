package com.example.formofart.models;

public class Dance {
    private String style;
    private int difficultyLevel;
    private boolean popular;
    private String origin;

    public Dance(String style, int difficultyLevel, boolean popular, String origin) {
        this.style = style;
        this.difficultyLevel = difficultyLevel;
        this.popular = popular;
        this.origin = origin;
    }

    // Access methods (getters and setters)

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Dance{" +
                "style='" + style + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", popular=" + popular +
                ", origin='" + origin + '\'' +
                '}';
    }

    public int getId() {
        return 0;
    }

    public void setId(int i) {
    }
}
