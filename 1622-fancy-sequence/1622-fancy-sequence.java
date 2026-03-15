class Fancy {
    private List<Long> seq;
    private long m;    // Global multiplier
    private long c;    // Global adder
    private final long MOD = 1_000_000_007;

    public Fancy() {
        seq = new ArrayList<>();
        m = 1;
        c = 0;
    }
    
    public void append(int val) {
        // We need to reverse the current formula: x = (val - c) / m
        // Since it's modulo math, division by 'm' is multiplying by modInverse(m)
        
        long diff = (val - c) % MOD;
        if (diff < 0) diff += MOD; // Fix negative modulo in Java
        
        long reversedVal = (diff * modInverse(m)) % MOD;
        seq.add(reversedVal);
    }
    
    public void addAll(int inc) {
        // Update the global adder
        c = (c + inc) % MOD;
    }
    
    public void multAll(int mul) {
        // Update both the multiplier and the adder
        m = (m * mul) % MOD;
        c = (c * mul) % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx >= seq.size()) {
            return -1;
        }
        
        // Grab the "fake" reversed number we stored
        long x = seq.get(idx);
        
        // Apply the current global formula: (x * m + c)
        long realVal = (x * m + c) % MOD;
        
        return (int) realVal;
    }
    
    // --- Helper Math Functions for Modulo Division ---
    
    // Fermat's Little Theorem: m^(-1) mod MOD = m^(MOD - 2) mod MOD
    private long modInverse(long base) {
        return modPow(base, MOD - 2);
    }
    
    // Fast Exponentiation to calculate base^exp % MOD
    private long modPow(long base, long exp) {
        long res = 1;
        base = base % MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}