public class Aula8 {
  static void test() {
    // Exercicio 1
    String nullString = null;
    String emptyString = "";
    String s1 = "Olá mundo";

    // Exercicio 2
    String s4 = String.valueOf(42);
    String s5 = String.valueOf('Z');
    String s6 = String.valueOf(3.14);
    String s7 = String.valueOf(true);

    // Exercicio 3
    int length = s1.length();
    char c = s1.charAt(2);

    // Exercicio 4
    char[] word = s1.toCharArray();
    String s3 = new String(word);

    // Exercicio 5
    ColorImage img = new ColorImage(200, 150);
    img.drawText(30, 50, "And the answer is ..", 20, new Color(255, 255, 255));
    img.drawCenteredText(100, 100, s4, 20, new Color(255, 255, 255));

    /*************************************
     *** EXERCICIOS FEITOS EM AULA - 8 ***
     *************************************/

    // Exercicio 1
    Color red = Color.RED;

    // Exercicio 2
    Color inverseRed = red.inverse();

    // Exercicio 3
    Color pink = red.brighter(128);

    // Exercicio 4
    Color greyScale = red.greyScale();
    Color lighterGreyScale = pink.greyScale();

    // Exercicio 5
    boolean a = greyScale.isEqualTo(red);
    boolean b = greyScale.isEqualTo(red.greyScale());
    boolean d = red.isEqualTo(inverseRed.inverse());

    // Exercicio 6
    Color[] v = { Color.RED, new Color(220, 220, 220), Color.BLUE };
    boolean isInVetor = red.containedIn(v); // true
    boolean notInVetor = Color.GREEN.containedIn(v); // false

    // Exercicio 1 - ColorImage
    ColorImage coffee = new ColorImage("IpirangaSaoJoaoEdsonLopesJrSecom.jpeg");
    ColorImage oneMore = coffee.copy();

    // Exercicio 2 - ColorImage
    ColorImage darkCoffee = coffee.inverse();

    // Exercicio 3 - ColorImage
    ColorImage greyCoffee = coffee.greyScale();

    // Exercicio 4 - ColorImage
    ColorImage brighterCoffee = coffee.brighter(128);

    // Exercicio 5 - ColorImage
    ColorImage mirroredCoffee = coffee.mirror();

    // Exercicio 6 - ColorImage
    ColorImage halfCoffee = ColorImage.darkCoffee(mirroredCoffee);

    // Exercicio 7 - ColorImage
//    ColorImage newCoffee = new ColorImage("coffee.jpg");
//    newCoffee.paste(mirroredCoffee, 100, 50);

    // Exercicio 8
    ColorImage megazord = ColorImage.megazord(coffee);
    ColorImage megazord2 = ColorImage.megazord(coffee);

    ColorImage poster = coffee.posterize();
    poster.save();
  }
}