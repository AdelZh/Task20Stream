public class Student {

    private String name;
    private String groupName;
    private int age;

    private int height;

    public Student(String name, String groupName, int age, int height) {
        this.name = name;
        this.groupName = groupName;
        this.age = age;
        this.height=height;
    }

    public Student(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
