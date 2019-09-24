class RelationShips {

    private static boolean printChildren(Person person,String gender){
        boolean isChildPresent = false;
        for(Person child : person.getChildren()){
            if(child.getGender().equals(gender)){
                isChildPresent=true;
                System.out.print(child.getName()+" ");
            }
        }
        return isChildPresent;
    }

    private static boolean printSiblings(Person person){
        Person parent = person.getMother();
        String person_name = person.getName();
        boolean isSiblingPresent = false;
        if(parent!=null){
            for(Person child : parent.getChildren()){
                if(!child.getName().equals(person_name)){
                    isSiblingPresent = true;
                    System.out.print(child.getName()+" ");
                }
            }
        }
        return isSiblingPresent;
    }

    private static boolean printRelative(Person parent,String gender){
        boolean isRelativePresent = false;
        if(parent!=null){
            Person grand_parent = parent.getMother();
            String person_name = parent.getName();
            if(grand_parent!=null){
                for(Person relative : grand_parent.getChildren()){
                    if(relative.getGender().equals(gender)){
                        if(!relative.getName().equals(person_name)) {
                            isRelativePresent = true;
                            System.out.print(relative.getName() + " ");
                        }
                    }
                }
            }
        }
        return isRelativePresent;
    }

    private static boolean printInLaw(Person person,String Gender){
        Person parent = person.getMother();
        String person_name = person.getName();
        boolean isInLawPresent = false;
        if(parent!=null){
            for(Person InLaw : parent.getChildren()){
                if(!InLaw.getName().equals(person_name)&&InLaw.getGender().equals(Gender)){
                    isInLawPresent = true;
                    System.out.print(InLaw.getName()+" ");
                }
            }
        }
        return isInLawPresent;
    }

    public static void findRelationShip(String relationship,Person person){
        boolean isRelationPresent=false;
        switch (relationship) {
            case "Son":
                isRelationPresent = printChildren(person,"Male");
                break;
            case "Daughter":
                isRelationPresent = printChildren(person,"Female");
                break;
            case "Siblings":
                isRelationPresent = printSiblings(person);
                break;
            case "Paternal-Uncle":
                //Argument as Father for Paternal
                isRelationPresent = printRelative(person.getFather(),"Male");
                break;
            case "Paternal-Aunt":
                //Argument as Father for Paternal
                isRelationPresent = printRelative(person.getFather(),"Female");
                break;
            case "Maternal-Uncle":
                //Argument as Mother for Maternal
                isRelationPresent = printRelative(person.getMother(),"Male");
                break;
            case "Maternal-Aunt":
                //Argument as Mother for Maternal
                isRelationPresent = printRelative(person.getMother(),"Female");
                break;
            case "Sister-In-Law":
                if(person.getGender().equals("Female"))
                    isRelationPresent = printInLaw(person.getHusband(),"Female");
                else
                    isRelationPresent = printInLaw(person.getSpouse(),"Female");
                break;
            case "Brother-In-Law":
                if(person.getGender().equals("Female"))
                    isRelationPresent = printInLaw(person.getHusband(),"Male");
                else
                    isRelationPresent = printInLaw(person.getSpouse(),"Male");
                break;
        }


        if(!isRelationPresent)
            System.out.print("NONE");
        System.out.println();
    }
}
