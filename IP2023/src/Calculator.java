class Calculator {
  int value;

  Calculator(int n) {
    this.value = n;
  }

  int getValue() {
    return this.value;
  }

  void plus(int n) {
    this.value = this.value + n;
  }

  void minus(int n) {
    this.value = this.value - n;
  }

  void reset() {
    this.value = 0;
  }

  void times(int n) {
    if (n == 1)
      return;

    int newValue = this.value;
    for (; n > 1; n--) {
      newValue = newValue + this.value;
    }

    this.value = newValue;
  }

  void powerOf(int n) {
    if (n == 1)
      return;

    int newValue = this.value;
    for (; n > 1; n--) {
      Calculator tmp = new Calculator(newValue);
      tmp.times(value);
      newValue = tmp.getValue();
    }
  }

  void divide(int n) {
    if (n == 0 || n == 1)
      return;

    int q = 0;
    while (this.value > n) {
      this.value = this.value - n;
      q++;
    }

    this.value = q;
  }

  void restOfDivisionBy(int n) {
    if (n == 0 || n == 1)
      return;

    int q = 0;
    while (this.value > n) {
      this.value = this.value - n;
      q++;
    }
  }
}