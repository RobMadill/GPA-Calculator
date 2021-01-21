package java1.school.assignment4;
import java.util.*;
public class Java1SchoolAssignment4 {

    public static void main(String[] args) {
        System.out.println("GPA Calculation\n");
        Scanner in = new Scanner(System.in);
        double max=100, min=0, weightedCreditValue=0, totalCreditValue=0, credits, grades, gradePoints=0, gradePointAverage, avg=0, totalGrades=0;
        int courses=1;
        char answer;
        String pull="";
        System.out.println("Enter the grade and credit value for each course.");
        //in this do/while loop, we are gathering the students grades and credit values for one iteration. At the end of the iteration we ask the user if they have another course they'd like to add. With each iteration, we continue to add the users grades to the totalGrades, calculate the weighted credit value and the total credit value.
        do{
            System.out.println("Data for Course #"+courses);
            pull="Grades: ";
            grades=getValidNumber(pull, in, 100.0, 0.0);
            pull="Credit Value: ";
            credits=getValidNumber(pull, in, 10.0, 0.0);
            gradePoints=getPoints(grades);
            System.out.println("Enter Another Course? (Y/N)");
            answer=in.next().toUpperCase().charAt(0);
            totalGrades+=grades;
            weightedCreditValue+=gradePoints*credits;
            totalCreditValue+=credits;
            courses++;
        }while (answer!='N');
        avg=totalGrades/(courses-1);
        gradePointAverage=weightedCreditValue/totalCreditValue;
        System.out.printf("Average Grade: %.2f\nGPA: %.2f", avg, gradePointAverage);
    }
    //This method is used for error handling. it takes to make sure the values inputed from the user are in the parameters of the min and max variable
   public static double getValidNumber(String pull, Scanner in, double max, double min){
        double num=0;
        boolean breakOut;
        do{
            breakOut=true;
            try{
                System.out.print(pull);
                num=in.nextDouble();
                if(num<min || num>max)
                    System.out.println("Error: Value must be between " + min +" and "+  max +".");
            }catch(Exception e){
            System.out.println("Error: All values entered must be numeric");
            breakOut=false;
            in.nextLine();
            }
        }while(!breakOut || (num<min || num>max));
    return num;
    }
    //This method is used to reference the students grades points. It takes in a users grade and will return their grade point.
    public static double getPoints(double gPA){
        if(gPA>=80)
            gPA=4.0;
        else if(gPA>=75 && gPA<80)
            gPA=3.5;
        else if(gPA>=70 && gPA<75)
            gPA=3.0;
        else if(gPA>=65 && gPA<70)
            gPA=2.5;
        else if(gPA>=60 && gPA<65)
            gPA=2.0;
        else if(gPA>=50 && gPA<60)
            gPA=1.0;
        else if(gPA<50)
            gPA=0.0;
        return gPA;
    }
    
}
