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
}
