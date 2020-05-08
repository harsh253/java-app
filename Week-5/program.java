package asd;

import java.util.ArrayList;
import java.util.Scanner;


public class program {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		Question question1 = new Question("Who is the president of India ?","Donald Trump","Ramnath Kovind","Narendra Modi","None", "Ramnath Kovind");
		Question question2 = new Question("Who played Tony Stark in the movie , Avengers ?", "Steve Rogers", "Robert Downey Jr.", "Chris Hemsworth", "None", "Robert Downey Jr.");
		
		ArrayList<Question> questions = new ArrayList<>();
		questions.add(question1);
		questions.add(question2);
		
		for(Question q: questions) {
			System.out.println(q.getQuestion());
			int a = 65;
			ArrayList<String> options = q.getOptions();
			for(String option: options) {
				System.out.println((char)a + " " + option);
				a+=1;
			}
			
			String ans = reader.nextLine();
			if(!(ans.equals(q.getCorrectOpt()))) {
				System.out.println("Sorry, wrong answer");
			}
		}
		
	}
}