class Rectangle {
  final int width;
  final int height;

  Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  int area() {
    return width * height;
  }

  int perimeter() {
    return 2 * width + 2 * height;
  }

  double diagonal() {
    return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
  }

  boolean isSquare() {
    return width == height;
  }

  Rectangle scale(int factor) {
    return new Rectangle(width * factor, height * factor);
  }

  Rectangle sum(int width, int height) {
    return new Rectangle(this.width + width, this.height + height);
  }

  Rectangle sum(Rectangle other) {
    return new Rectangle(this.width + other.width, this.height + other.height);
  }

  boolean fitsInside(Rectangle other) {
    return (this.width <= other.width && this.height <= other.height)
        || (this.width <= other.height && this.height <= other.width);
  }

  static Rectangle square(int size) {
    return new Rectangle(size, size);
  }
}