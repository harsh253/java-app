package asd;

import java.util.ArrayList;

public class Question {
	
	private String question;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String correctOpt;
	
	public Question(String question, String opt1, String opt2, String opt3, String opt4, String correctOpt) {
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.correctOpt = correctOpt;
	}

	public String getCorrectOpt() {
		return correctOpt;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public ArrayList<String> getOptions(){
		ArrayList<String> options = new ArrayList<>();
		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);
		return options;
	}

}
