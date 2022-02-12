/* This code is take from prac-9 semester 1 2020 PDI */

public class Student
{
    //private class fields
    private String name;
    private int studentID;

    /************************************************************
     * Default Constructor:
     * IMPORT: none
     * EXPORT: address of new Student object
     * ASSERTION: 185/55 R15 with an airpressure of 29, mag alloy
     *    rims and no manufacturer is a valid default state
     ************************************************************/
    public Student()
    {
        name = new String("Harry Potter");
        studentID = 10000001;
    }

    /************************************************************
     * Alternate Constructor:
    ************************************************************/

    public Student(String inName, int inStudentID)
    {
        setName(inName);
        setStudentID(inStudentID);
    }

    /************************************************************
     *Copy Constructor:
    ************************************************************/

    public Student(Student inStudent)
    {
        name = inStudent.getName();
        studentID = inStudent.getStudentID();
    }

    //MUTATORS

   public void setName(String inName)
    {
        name = inName;
    }

   public void setStudentID(int inStudentID)
    {
        if(validateID(inStudentID))
        {
            studentID = inStudentID;
        }
        else
        {
            throw new IllegalArgumentException("Invalid student ID");
        }
    }

    //ACCESSORS

    public String getName()
    {
        return name;
    }

    public int getStudentID()
    {
        return studentID;
    }

    /********************************************************************
     * SUBMODULE: equals */


   public boolean equals(Object inObj)
    {
        boolean same = false;
        if(inObj instanceof Student)
        {
            Student inStudent = (Student)inObj;
            same = name.equals(inStudent.getName()) && 
                   studentID == (inStudent.getStudentID());
        }
        return same;
    }

    public Student clone()
    {
        return new Student(this);
    }

    public String toString()
    {
        return (name + "," + studentID);  //toString gets written on file?
    } 

    public String toFileString()
    {
        return(name + "," + studentID);
    }

    //PRIVATE SUBMODULES: //Validating data//

    private boolean validateID(int inStudentID)
    {
        return ((inStudentID > 10000000) && (inStudentID < 99999999));
    }

   /* private boolean validateMark(double inMark)
    {
        
        return ((inMark >= 0.0) && (inMark <= 100.0));
    } */
}

