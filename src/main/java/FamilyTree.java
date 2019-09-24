import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private static Person queen=null;

    /**
     * Function to find the person from input
     * @param cur
     * @param name
     * @return
     */
    private static Person findPerson(Person cur,String name){

        if(cur.getHusband()!=null){
            if(cur.getHusband().getName().equals(name))
                return cur.getHusband();
        }
        if(cur.getSpouse()!=null){
            if(cur.getSpouse().getName().equals(name))
                return cur.getSpouse();
        }

        if(cur.getName().equals(name)){
            return cur;
        }else{
            List<Person> children = cur.getChildren();
            for(Person child : children){
                Person mother = findPerson(child,name);
                if(mother!=null)
                    return mother;
            }
        }
        return null;
    }

    /**
     * Function to add children to the specified parent
     * @param name
     * @param gender
     * @param mother
     */
    private static void addChildren(String name,String gender,Person mother){
        Person child = new Person(name,gender,mother.getHusband(),mother);
        ArrayList<Person> children = mother.getChildren();
        children.add(child);
        mother.setChildren(children);
        mother.getHusband().setChildren(children);
    }

    public static void main(String args[]) throws Exception{
        File file = new File("C:\\Users\\sanjay\\IdeaProjects\\MeetTheFamily\\src\\main\\resources\\input\\corner_cases_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String parent_name;
        queen = CreateShanFamilyTree.createFamilTree();

        while ((st = br.readLine()) != null){
            String[] inputs = st.trim().split("\\s");
            Person  parent,person;
            switch (inputs[0]){
                case "ADD_CHILD":
                    parent_name = inputs[1];
                    parent = findPerson(queen,parent_name);
                    if(parent!=null) {
                        if(parent.getGender().equals("Female")){
                            String child_name = inputs[2];
                            String child_gender = inputs[3];
                            addChildren(child_name, child_gender, parent);
                            System.out.println("CHILD_ADDITION_SUCCEEDED");
                        }else{
                            System.out.println("CHILD_ADDITION_FAILED");
                        }
                    }else{
                        System.out.println("PERSON_NOT_FOUND");
                    }
                    break;
                case "GET_RELATIONSHIP":
                    String person_name = inputs[1];
                    person = findPerson(queen,person_name);
                    if(person!=null) {
                        String relationship = inputs[2];
                        RelationShips.findRelationShip(relationship,person);
                    }else{
                        System.out.println("PERSON_NOT_FOUND");
                    }
                    break;
            }
        }
    }
}
