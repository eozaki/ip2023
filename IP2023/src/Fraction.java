class Fraction {
  int denominator, numerator;

  Fraction(int n) {
    this.denominator = n;
    this.numerator = 1;
  }

  Fraction(int numerator, int denominator) {
    this.denominator = denominator;
    this.numerator = numerator;
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  public double realNumber() {
    return numerator / denominator;
  }

  public Fraction times(Fraction other) {
    return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
  }

  public Fraction sum(Fraction other) {
    return new Fraction(this.numerator * other.denominator + other.numerator * this.denominator,
        this.denominator * other.denominator);
  }

  public boolean lessThan(Fraction other) {
    return this.realNumber() < other.realNumber();
  }

  public boolean greaterThan(Fraction other) {
    return this.realNumber() > other.realNumber();
  }

  public boolean equalsTo(Fraction other) {
    return this.realNumber() == other.realNumber();
  }

}