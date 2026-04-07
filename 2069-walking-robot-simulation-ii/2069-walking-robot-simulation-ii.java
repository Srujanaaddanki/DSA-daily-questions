class Robot {
    private int w, h, perimeter;
    private int pos = 0;
    private boolean moved = false;

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        // Total unique positions along the boundary
        this.perimeter = 2 * (w - 1) + 2 * (h - 1);
    }

    public void step(int num) {
        moved = true;
        pos = (pos + num) % perimeter;
    }

    public int[] getPos() {
        // Bottom edge: (0,0) to (w-1, 0)
        if (pos < w) {
            return new int[]{pos, 0};
        }
        // Right edge: (w-1, 1) to (w-1, h-1)
        if (pos < w + h - 1) {
            return new int[]{w - 1, pos - (w - 1)};
        }
        // Top edge: (w-2, h-1) to (0, h-1)
        if (pos < 2 * w + h - 2) {
            return new int[]{w - 1 - (pos - (w + h - 2)), h - 1};
        }
        // Left edge: (0, h-2) to (0, 1)
        return new int[]{0, h - 1 - (pos - (2 * w + h - 3))};
    }

    public String getDir() {
        // Special case: Robot moved and looped back to origin
        if (moved && pos == 0) return "South";
        
        if (pos > 0 && pos < w) return "East";
        if (pos >= w && pos < w + h - 1) return "North";
        if (pos >= w + h - 1 && pos < 2 * w + h - 2) return "West";
        if (pos >= 2 * w + h - 2 || (pos == 0 && moved)) return "South";
        
        return "East"; // Initial state
    }
}