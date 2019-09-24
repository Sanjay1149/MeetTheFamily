class RelationShips {

    /**
     * Function to print Son/Daughter
     * @param person
     * @param gender
     * @return
     */
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

    /**
     * Function to print the Siblings
     * @param person
     * @return
     */
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

    /**
     * Function to print the Paternal/Maternal-Uncle/Aunt
     * @param parent
     * @param gender
     * @return
     */
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

    /**
     * Function to print the Spouse's sisters or brothers
     * @param person
     * @param Gender
     * @return
     */
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

    /**
     * Function to print the Wives/Husbands of siblings
     * @param person
     * @param Gender
     * @return
     */
    private static boolean printPartnerOfSiblings(Person person,String Gender){
        Person parent = person.getMother();
        String person_name = person.getName();
        boolean isPartnerOfSiblingsPresent = false;
        if(parent!=null){
            for(Person partner : parent.getChildren()){
                if(!partner.getName().equals(person_name)&&partner.getGender().equals(Gender)){
                    if(partner.getGender().equals("Male")){
                        if(partner.getSpouse()!=null){
                            isPartnerOfSiblingsPresent = true;
                            System.out.print(partner.getSpouse().getName()+" ");
                        }
                    }else{
                        if(partner.getHusband()!=null){
                            isPartnerOfSiblingsPresent = true;
                            System.out.print(partner.getHusband().getName()+" ");
                        }
                    }
                }
            }
        }
        return isPartnerOfSiblingsPresent;

    }


    /**
     *
     * Function to find the relationship & print them if exist, prints NONE if doesn't exist
     * @param relationship
     * @param person
     */
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
                isRelationPresent =  printPartnerOfSiblings(person,"Male") || isRelationPresent;
                break;
            case "Brother-In-Law":
                if(person.getGender().equals("Female"))
                    isRelationPresent = printInLaw(person.getHusband(),"Male");
                else
                    isRelationPresent = printInLaw(person.getSpouse(),"Male");
                isRelationPresent =  printPartnerOfSiblings(person,"Female") || isRelationPresent;
                break;
        }


        if(!isRelationPresent)
            System.out.print("NONE");
        System.out.println();
    }
}
