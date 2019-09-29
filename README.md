# Shan Family Tree 

> This is a respository for the solution of a Backend/Full 
Stack Geektrust coding problem


## Getting Started

> This sample is for backend and fullstack development. It challenges object oriented concepts.

![alt text](https://drive.google.com/file/d/1mvznAnc9hPsdv1YeIaBPDraNJFN7_7P9/view?usp=sharing "Family Tree")


## Operations

* Adding a Child to any family in the tree through mother [ADD_CHILD].
* With given 'name' & 'relationship', find the people corresponding to the relationship
in the order in which they were added to the family tree [GET_RELATIONSHIP].


| **Relationships**      | **Definition**                         |
| ---------------------  |--------------------------------------|
| Paternal Uncle & Aunt  | Father's and Mother's brothers         | 
| Maternal Uncle & Aunt  | Father's and Mother's sisters          | 
| Sister-In-Law          | Spouse's sisters, Wives of siblings    |
| Brother-In-Law         | Spouse's brothers, Husbands of siblings|
| Son                    | |
| Daughter               | |
| Siblings               | |

## Sample Input & Output

###### Input
>ADD_CHILD Satya Ketu Male                          
GET_RELATIONSHIP Kriya Paternal-Uncle                              
GET_RELATIONSHIP Satvy Brother-In-Law             

###### Output
>CHILD_ADDITION_SUCCEEDED       
Asva Ketu                       
Vyas Ketu



## Problem Statement

> This is a problem from [Geektrust](https://www.geektrust.in/coding-problem/backend/family)
