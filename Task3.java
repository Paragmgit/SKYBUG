import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Student grade calculator");
		
		System.out.println("Full name of student :");
		String name = sc.nextLine();
		
        System.out.println("Enter the no of subjects :");
        int No_subject = sc.nextInt();
        
        if(No_subject <= 0) {
        	System.out.println("Please enter a valid no of subjects :");
        }
        
        int totalMarks = 0;
        final int maxMarksObtained = 100;
        for(int i=1;i<=No_subject;i++) {
        	System.out.print("Enter mark obtained in subject"+ i +"(out of 100):");
        	int mark = sc.nextInt();
        	totalMarks+= mark;
        }
        
        double avgPercentage = (double)totalMarks/(maxMarksObtained * No_subject)*100;
        char Grade;
        if(avgPercentage >= 90) {
        	Grade = 'A';
        }
        else if(avgPercentage >= 80) {
        	Grade = 'B';
        }
        else if (avgPercentage >= 70) {
			Grade = 'C';
		}
        else if (avgPercentage >= 60) {
			Grade = 'D';
		}
        else if (avgPercentage >= 35) {
			Grade = 'E';
		}
        else {
			Grade = 'F';
		}
        
        System.out.println("Final Result Of "+name+" is:");
        System.out.println("Total Marks Scored :"+totalMarks+" "+"(out of)"+" "+(maxMarksObtained * No_subject));
        System.out.println("Average percentage gained is :"+avgPercentage+"%");
        System.out.println("Grade :"+Grade);
        sc.close();
	}

}
