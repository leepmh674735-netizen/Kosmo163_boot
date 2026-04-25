Collections .sort(inventy, new Comparator<Apple>() {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
});
inventory.sort(comparing(Apple::getWeight));

public int compareUsingCustomerId(String inv1, String inv1, String inv2) {

}
List<String> for each
Iterator

File[] hiddenFiles = new File(".").listFiles(new FileFilter(){
    public boolean accept(File file) {
        return file.isHidden();
    }
});
File[] hiidderFiles = new File(".").listFiles(File::isHidden);

public static List<Apple> filterGreenApples(List<Apple> inventy) {
    List<Apple> result = new AppayList<>();
    for (Apple apple : inventory) {
        if("green".equals(apple.getColoor())) {
            result.add(apple);
        }
    }
    return result;
} 
public static List<Apple> filterHavyApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
        if (apple.getWeigh() > 150) {
            result,add(apple);
        }
    }
    return result;
}