import java.util.ArrayList;

class CreateShanFamilyTree {

    private static Person queen=null;
    private static Person king=null;

    public static Person createFamilTree(){
        king = new Person("Shan","Male",null,null);
        queen = new Person("Anga","Female",null,null);
        queen.setHusband(king);
        king.setSpouse(queen);

        // Children of King & Queen
        Person child1 = new Person("Chit","Male",king,queen);
        Person child2 = new Person("Ish","Male",king,queen);
        Person child3 = new Person("Vich","Male",king,queen);
        Person child4 = new Person("Aras","Male",king,queen);
        Person child5 = new Person("Satya","Female",king,queen);
        ArrayList<Person> children = new ArrayList<Person>(){
            {
                add(child1);
                add(child2);
                add(child3);
                add(child4);
                add(child5);
            }
        };
        queen.setChildren(children);
        king.setChildren(children);

        // Family Tree for Child1 'Chit'
        Person wifeOfChild1 = new Person("Amba","Female",null,null);
        child1.setSpouse(wifeOfChild1);
        wifeOfChild1.setHusband(child1);
        Person grandChild1 = new Person("Dritha","Female",child1,wifeOfChild1);
        Person husbandOfGrandChild1 = new Person("Jaya","Male",null,null);
        husbandOfGrandChild1.setSpouse(grandChild1);
        grandChild1.setHusband(husbandOfGrandChild1);
        children = new ArrayList<Person>(){
            {
                add(new Person("Yodhan","Male",husbandOfGrandChild1,grandChild1));
            }
        };
        husbandOfGrandChild1.setChildren(children);
        grandChild1.setChildren(children);

        children = new ArrayList<Person>(){
            {
                add(grandChild1);
                add(new Person("Tritha","Female",child1,wifeOfChild1));
                add(new Person("Vritha","Male",child1,wifeOfChild1));
            }
        };
        child1.setChildren(children);
        wifeOfChild1.setChildren(children);

        // Family Tree for Child3 'Vich'
        Person wifeOfChild3 = new Person("Lika","Female",null,null);
        child3.setSpouse(wifeOfChild3);
        wifeOfChild3.setHusband(child3);
        children = new ArrayList<Person>(){
            {
                add(new Person("Vila","Female",child3,wifeOfChild3));
                add(new Person("Chika","Female",child3,wifeOfChild3));
            }
        };
        child3.setChildren(children);
        wifeOfChild3.setChildren(children);

        // Family Tree for Child4 'Aras'
        Person wifeOfChild4 = new Person("Chitra","Female",null,null);
        child4.setSpouse(wifeOfChild4);
        wifeOfChild4.setHusband(child4);
        Person grandChild2 = new Person("Jnki","Female",child4,wifeOfChild4);
        Person husbandOfGrandChild2 = new Person("Arit","Male",null,null);
        husbandOfGrandChild2.setSpouse(grandChild2);
        grandChild2.setHusband(husbandOfGrandChild2);
        children = new ArrayList<Person>(){
            {
                add(new Person("Laki","Male",husbandOfGrandChild2,grandChild2));
                add(new Person("Lavnya","Female",husbandOfGrandChild2,grandChild2));
            }
        };
        husbandOfGrandChild2.setChildren(children);
        grandChild2.setChildren(children);

        children = new ArrayList<Person>(){
            {
                add(grandChild2);
                add(new Person("Ahit","Male",child4,wifeOfChild4));
            }
        };
        child4.setChildren(children);
        wifeOfChild4.setChildren(children);


        //  Family Tree for Child4 'Aras'
        Person husbandOfChild5 = new Person("Vyan","Male",null,null);
        child5.setHusband(husbandOfChild5);
        husbandOfChild5.setSpouse(child5);

        Person grandChild3 = new Person("Asva","Male",husbandOfChild5,child5);
        Person wifeOfGrandChild3 = new Person("Satvy","Female",null,null);
        grandChild3.setSpouse(wifeOfGrandChild3);
        wifeOfGrandChild3.setHusband(grandChild3);
        children = new ArrayList<Person>(){
            {
                add(new Person("Vasa","Male",grandChild3,wifeOfGrandChild3));
            }
        };
        grandChild3.setChildren(children);
        wifeOfGrandChild3.setChildren(children);

        Person grandChild4 = new Person("Vyas","Male",husbandOfChild5,child5);
        Person wifeOfGrandChild4 = new Person("Krpi","Female",null,null);
        grandChild4.setSpouse(wifeOfGrandChild4);
        wifeOfGrandChild4.setHusband(grandChild3);
        children = new ArrayList<Person>(){
            {
                add(new Person("Kriya","Male",grandChild4,wifeOfGrandChild4));
                add(new Person("Krithi","Female",grandChild4,wifeOfGrandChild4));
            }
        };
        grandChild4.setChildren(children);
        wifeOfGrandChild4.setChildren(children);


        children = new ArrayList<Person>(){
            {
                add(grandChild3);
                add(grandChild4);
                add(new Person("Atya","Female",husbandOfChild5,child5));
            }
        };
        child5.setChildren(children);
        husbandOfChild5.setChildren(children);

        return queen;

    }
}
