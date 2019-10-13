public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("You can't divide by zero");
        } else if (denominator < 0) {
            this.numerator = reverse(numerator);
            this.denominator = reverse(denominator);
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    //public methods
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return numerator / denominator;
    }

    public Fraction add(Fraction other) {
        Fraction add = new Fraction(
            (this.numerator * other.denominator) + (this.denominator * other.numerator),
            this.denominator * other.denominator);

        return add;
    }

    public Fraction subtract(Fraction other) {
        Fraction subtract = new Fraction(
            (this.numerator * other.denominator) - (this.denominator * other.numerator),
            this.denominator * other.denominator);

        return subtract;
    }

    public Fraction multiply(Fraction other) {
        Fraction multiply = new Fraction(
            this.numerator * other.numerator,
            this.denominator * other.denominator
        );

        return multiply;
    }

    public Fraction divide(Fraction other) {
        Fraction divide = new Fraction(
            this.numerator * other.denominator,
            this.denominator * other.numerator
        );

        return divide;
    }

    public boolean equals(Object other) {
        boolean equals;
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            equals = this.toDouble() == otherFraction.toDouble();
        } else {
            equals = false;
        }
        return equals;
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    // helper methods
    private static int reverse(int x) {
        int inverted = -x;
        return inverted;
    }

    private static int gcd(int num, int den) {
        while (num != 0 && den != 0) {
            int remainder = num % den;
            num = den;
            den = remainder;
        }

        return num;
    }
}
