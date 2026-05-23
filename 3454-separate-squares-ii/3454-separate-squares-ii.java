import java.util.*;

class Solution {
    // A simplified, highly optimized primitive Segment Tree
    static class SegmentTree {
        int[] count;
        double[] totalLen;
        double[] coords;
        int n;

        public SegmentTree(double[] uniqueX) {
            this.coords = uniqueX;
            this.n = uniqueX.length;
            // 4 * N is a safe standard upper bound for array-based tree representations
            this.count = new int[4 * n];
            this.totalLen = new double[4 * n];
        }

        public void update(int node, int start, int end, int L, int R, int val) {
            if (L <= start && end <= R) {
                count[node] += val;
            } else {
                int mid = (start + end) / 2;
                if (L <= mid) {
                    update(2 * node, start, mid, L, R, val);
                }
                if (R > mid) {
                    update(2 * node + 1, mid + 1, end, L, R, val);
                }
            }

            // Push-up step: Calculate total active length spanning this node
            if (count[node] > 0) {
                totalLen[node] = coords[end + 1] - coords[start];
            } else {
                if (start == end) {
                    totalLen[node] = 0;
                } else {
                    totalLen[node] = totalLen[2 * node] + totalLen[2 * node + 1];
                }
            }
        }
    }

    // Event object tracking the horizontal sweeps along the Y axis
    static class Event implements Comparable<Event> {
        double y;
        int type; // 1 for entering a square base, -1 for leaving the top ceiling
        double x1, x2;

        public Event(double y, int type, double x1, double x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Event other) {
            return Double.compare(this.y, other.y);
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        List<Event> events = new ArrayList<>(2 * n);
        TreeSet<Integer> uniqueXSet = new TreeSet<>();

        for (int[] sq : squares) {
            double x1 = sq[0];
            double y1 = sq[1];
            double l = sq[2];
            double x2 = x1 + l;
            double y2 = y1 + l;

            uniqueXSet.add((int) x1);
            uniqueXSet.add((int) x2);

            events.add(new Event(y1, 1, x1, x2));
            events.add(new Event(y2, -1, x1, x2));
        }

        Collections.sort(events);

        // Convert the sorted unique X coordinates to a primitive double array for calculations
        double[] xCoords = new double[uniqueXSet.size()];
        Map<Integer, Integer> xMap = new HashMap<>();
        int idx = 0;
        for (int x : uniqueXSet) {
            xCoords[idx] = x;
            xMap.put(x, idx);
            idx++;
        }

        SegmentTree st = new SegmentTree(xCoords);
        int totalUniqueX = xCoords.length;

        // Stage arrays to log horizontal slices for the second analysis pass
        double[] stageYStart = new double[events.size()];
        double[] stageWidth = new double[events.size()];
        double[] stageYEnd = new double[events.size()];
        int stageCount = 0;

        double totalArea = 0.0;

        // Pass 1: Run the sweep line to calculate total union area
        for (int i = 0; i < events.size() - 1; i++) {
            Event curr = events.get(i);
            int L = xMap.get((int) curr.x1);
            int R = xMap.get((int) curr.x2) - 1;

            st.update(1, 0, totalUniqueX - 2, L, R, curr.type);

            double yNext = events.get(i + 1).y;
            double height = yNext - curr.y;
            double width = st.totalLen[1]; // Total active horizontal span at root

            totalArea += height * width;

            stageYStart[stageCount] = curr.y;
            stageWidth[stageCount] = width;
            stageYEnd[stageCount] = yNext;
            stageCount++;
        }

        // Apply final updates for the very last sweeping event
        Event lastEvent = events.get(events.size() - 1);
        int L = xMap.get((int) lastEvent.x1);
        int R = xMap.get((int) lastEvent.x2) - 1;
        st.update(1, 0, totalUniqueX - 2, L, R, lastEvent.type);

        // Pass 2: Pinpoint exactly where the cumulative split hits 50%
        double halfArea = totalArea / 2.0;
        double currentArea = 0.0;

        for (int i = 0; i < stageCount; i++) {
            double yStart = stageYStart[i];
            double width = stageWidth[i];
            double yEnd = stageYEnd[i];

            double stageArea = (yEnd - yStart) * width;
            if (currentArea + stageArea >= halfArea - 1e-9) {
                if (width == 0) {
                    return yStart;
                }
                // Linearly interpolate inside this horizontal bounding segment
                return yStart + (halfArea - currentArea) / width;
            }
            currentArea += stageArea;
        }

        return events.get(events.size() - 1).y;
    }
}