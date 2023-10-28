public class Aula7 {
  static Color gray(int intensity) {
    intensity = IPHelper.constrain(intensity, 0, 255);
    return new Color(intensity, intensity, intensity);
  }

  static Color randomGray() {
    return gray(IPHelper.random(255));
  }

  static Color randomColor() {
    return new Color(IPHelper.random(255), IPHelper.random(255), IPHelper.random(255));
  }

  static Color[] randomColorArray(int length) {
    Color[] array = new Color[length];

    for (int i = 0; i < length; i++) {
      array[i] = randomColor();
    }

    return array;
  }

  static Color inverted(Color color) {
    return new Color(255 - color.getR(), 255 - color.getG(), 255 - color.getB());
  }

  static Color changeBrightness(Color color, int delta) {
    return new Color(IPHelper.constrain(color.getR() + delta, 0, 255), IPHelper.constrain(color.getR() + delta, 0, 255),
        IPHelper.constrain(color.getR() + delta, 0, 255));
  }

  static BinaryImage randomBinaryImage(int width, int height) {
    BinaryImage img = new BinaryImage(width, height);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        img.setWhite(j, i);
        if (IPHelper.booleanRandom())
          img.setBlack(j, i);
      }
    }

    return img;
  }

  static void drawSquare(BinaryImage img, int x, int y, int side) {
    x = IPHelper.constrain(x, 0, img.getWidth() - 1);
    y = IPHelper.constrain(y, 0, img.getHeight() - 1);

    for (int i = x; i < x + side; i++) {
      for (int j = y; j < y + side; j++) {
        img.setWhite(i, j);
      }
    }
  }

  static void invertImage(BinaryImage img) {
    for (int i = 0; i < img.getHeight(); i++) {
      for (int j = 0; j < img.getWidth(); j++) {
        if (img.isBlack(j, i)) {
          img.setWhite(j, i);
        } else {
          img.setBlack(j, i);
        }
      }
    }
  }

  static BinaryImage invertedImage(BinaryImage img) {
    BinaryImage imgCopy = new BinaryImage(img.getWidth(), img.getHeight());

    for (int i = 0; i < img.getHeight(); i++) {
      for (int j = 0; j < img.getWidth(); j++) {
        if (img.isBlack(j, i)) {
          imgCopy.setWhite(j, i);
        } else {
          imgCopy.setBlack(j, i);
        }
      }
    }

    return imgCopy;
  }

  static void testInvertedImage() {
    BinaryImage img = randomBinaryImage(200, 100);

    drawSquare(img, 50, 50, 30);

    BinaryImage secongImg = invertedImage(img);
  }

  static BinaryImage convert(boolean[][] data) {
    BinaryImage img = new BinaryImage(data.length, data[0].length);

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[0].length; j++) {
        if (img.isBlack(j, i))
          img.setBlack(j, i);
      }
    }

    return img;
  }
}
