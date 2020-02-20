package RecursionAndDp;

public class PaintFill {
    enum Color { Black, Red, White, Yellow, Green }

    public boolean paintFill(Color[][] screen, int r, int c, Color ncolor) {
        if (screen[r][c] == ncolor) return false;

        return paintFill(screen, r, c, screen[r][c], ncolor);
    }

    public boolean paintFill(Color[][] screen, int r, int c, Color oColor, Color nColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }

        if (screen[r][c] == oColor) {
            screen[r][c] = nColor;
            paintFill(screen, r - 1, c, oColor, nColor);
            paintFill(screen, r + 1, c, oColor, nColor);
            paintFill(screen, r, c - 1, oColor, nColor);
            paintFill(screen, r, c + 1, oColor, nColor);
        }

        return true;
    }
}