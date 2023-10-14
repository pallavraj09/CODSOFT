
import java.util.Scanner;

class task2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of Subjects :");
        int a=sc.nextInt();
        int sum=0;
        for(int i=0;i<a;i++)
        {
            System.out.print("Enter the marks in subject "+(i+1)+" :");
            int b=sc.nextInt();
            if(b>100 || b<0)
            {
                i=i-1;
                System.out.println("Invalid Marks ! Retry ");
                b=0;
            }
            sum=sum+b;
        }
         float averagePercentage  = (float) calculateAveragePercentage(sum,a);
        String grade = assignGrade(averagePercentage);
        int c=a*100;
        
        System.out.println("The Total marks is : "+(sum)+" out of "+c);
         System.out.println("The Average Percentage is : "+(averagePercentage)+"%");
         System.out.println("The Overall Grade is : " +(grade));
         sc.close();
    }
    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return ((double) totalMarks / (numSubjects * 100)) * 100;
    }

        public static String assignGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "O";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }}
        
}
