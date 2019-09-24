import java.util.ArrayList;

class Person {

    private  String name;
    private  String gender;
    private  Person father;
    private  Person mother;
    private  Person husband;
    private  Person spouse;
    private  ArrayList<Person> children = new ArrayList<>();

    Person(String name,String gender,Person father,Person mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    String getName() {
        return name;
    }

    String getGender() {
        return gender;
    }

    Person getFather() {
        return father;
    }

    Person getMother() {
        return mother;
    }

    Person getHusband() {
        return husband;
    }

    void setHusband(Person husband) {
        this.husband = husband;
    }

    Person getSpouse() {
        return spouse;
    }

    void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    ArrayList<Person> getChildren() {
        return children;
    }

    void setChildren(ArrayList<Person> children) {
        this.children = children;
    }
}
