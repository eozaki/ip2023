import java.awt.image.BufferedImage;

/**
 * Represents color images. Image data is represented as a matrix: - the number
 * of lines corresponds to the image height (data.length) - the length of the
 * lines corresponds to the image width (data[*].length) - pixel color is
 * encoded as integers (ARGB)
 */

class ColorImage {

  private int[][] data; // @colorimage

  // Construtors

  ColorImage(int width, int height) {
    data = new int[height][width];
  }

  ColorImage(String file) {
    this.data = ImageUtil.readColorImage(file);
  }

  ColorImage(int[][] data) {
    this.data = data;
  }

  ColorImage(int width, int height, Color color) {
    data = new int[height][width];

    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {
        this.setColor(x, y, color);
      }
    }
  }

  // Metods

  ColorImage posterize() {
    ColorImage newImg = new ColorImage(this.getWidth(), this.getHeight());
    Color b = new Color(51, 50, 110);

    for (int i = 0; i < this.getWidth(); i++)
      for (int j = 0; j < this.getHeight(); j++) {
        Color color = this.getColor(i, j).getLuminance() > 128 ? b : Color.WHITE;
        newImg.setColor(i, j, color);
      }

    return newImg;
  }

  void save() {
    BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
    String name = "poster.png";

    System.out.println(this.getHeight());
    System.out.println(this.getWidth());
    for (int i = 0; i < this.getHeight(); i++)
      for (int j = 0; j < this.getWidth(); j++) {
        Color color = this.getColor(j, i);

        int col = (color.getR() << 16) | (color.getG() << 8) | color.getB();
        img.setRGB(j, i, col);
      }

    ImageUtil.saveBinaryImage(img, name);
  }

  int getWidth() {
    return data[0].length;
  }

  int getHeight() {
    return data.length;
  }

  void setColor(int x, int y, Color c) {
    data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
  }

  Color getColor(int x, int y) {
    int[] rgb = ImageUtil.decodeRgb(data[y][x]);
    return new Color(rgb[0], rgb[1], rgb[2]);
  }

  // Text functions

  void drawText(int textX, int textY, String text, int textSize, Color textColor) {
    drawText(textX, textY, text, textSize, textColor, false);
  }

  void drawCenteredText(int textX, int textY, String text, int textSize, Color textColor) {
    drawText(textX, textY, text, textSize, textColor, true);
  }

  private void drawText(int textX, int textY, String text, int textSize, Color textColor, boolean isCentered) {
    int r = 255 - textColor.getR();
    int g = 255 - textColor.getG();
    int b = 255 - textColor.getB();

    Color maskColor = new Color(r, g, b);

    int encodedMaskRGB = ImageUtil.encodeRgb(r, g, b);

    int[][] aux = ImageUtil.createColorImageWithText(getWidth(), getHeight(), maskColor, textX, textY, text, textSize,
        textColor, isCentered);

    for (int i = 0; i < aux.length; i++) {
      for (int j = 0; j < aux[i].length; j++) {
        int value = aux[i][j];
        if (value != encodedMaskRGB) {
          data[i][j] = aux[i][j];
        }
      }
    }
  }

  /*************************************
   *** EXERCICIOS FEITOS EM AULA - 8 ***
   *************************************/

  // Exercicio 1
  ColorImage copy() {
    ColorImage newImage = new ColorImage(this.getWidth(), this.getHeight());

    for (int i = 0; i < newImage.getHeight(); i++) {
      for (int j = 0; j < newImage.getWidth(); j++) {
        newImage.setColor(j, i, this.getColor(j, i));
      }
    }

    return newImage;
  }

  // Exercicio 2
  ColorImage inverse() {
    ColorImage newImage = new ColorImage(this.getWidth(), this.getHeight());

    for (int i = 0; i < newImage.getHeight(); i++) {
      for (int j = 0; j < newImage.getWidth(); j++) {
        newImage.setColor(j, i, this.getColor(j, i).inverse());
      }
    }

    return newImage;
  }

  // Exercicio 3
  ColorImage greyScale() {
    ColorImage newImage = new ColorImage(this.getWidth(), this.getHeight());

    for (int i = 0; i < newImage.getHeight(); i++) {
      for (int j = 0; j < newImage.getWidth(); j++) {
        newImage.setColor(j, i, this.getColor(j, i).greyScale());
      }
    }

    return newImage;
  }

  // Exercicio 4
  ColorImage brighter(int shift) {
    ColorImage newImage = new ColorImage(this.getWidth(), this.getHeight());

    for (int i = 0; i < newImage.getHeight(); i++) {
      for (int j = 0; j < newImage.getWidth(); j++) {
        newImage.setColor(j, i, this.getColor(j, i).brighter(shift));
      }
    }

    return newImage;
  }

  // Exercicio 5
  ColorImage mirror() {
    ColorImage newImage = new ColorImage(this.getWidth(), this.getHeight());

    for (int i = 0; i < newImage.getHeight(); i++) {
      for (int j = 0; j < newImage.getWidth(); j++) {
        newImage.setColor(j, i, this.getColor(this.getWidth() - j - 1, i));
      }
    }

    return newImage;
  }

  // Exercicio 6
  static ColorImage darkCoffee(ColorImage sourceImg) {
    ColorImage newImg = new ColorImage(sourceImg.getWidth(), sourceImg.getHeight());

    for (int i = 0; i < newImg.getHeight(); i++) {
      for (int j = 0; j < (newImg.getWidth() / 2) + 1; j++) {
        Color color = sourceImg.getColor(j, i).inverse().greyScale();
        newImg.setColor(j, i, color);
        newImg.setColor(newImg.getWidth() - j - 1, i, color);
      }
    }

    return newImg;
  }

  // Exercicio 7
  void paste(ColorImage img, int x, int y) {
    for (int i = 0; x + i < Math.min(x + img.getHeight(), this.getHeight()); i++) {
      for (int j = 0; y + j < Math.min(y + img.getWidth(), this.getWidth()); j++) {
        Color color = img.getColor(j, i);

        this.setColor(y + j, x + i, color);
      }
    }
  }

  // Exercicio 8
  static ColorImage megazord(ColorImage src) {
    ColorImage megazord = new ColorImage(src.getWidth() * 2, src.getHeight() * 2);

    megazord.paste(src.greyScale().mirror(), 0, 0);
    megazord.paste(src, 0, src.getWidth());
    megazord.paste(src.inverse().mirror(), src.getHeight(), 0);
    megazord.paste(src.greyScale(), src.getHeight(), src.getWidth());

    return megazord;
  }
}