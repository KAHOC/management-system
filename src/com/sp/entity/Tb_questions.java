package com.sp.entity;

public class Tb_questions {
		int id;
		String subject;
		String type;
		String joinTime;
		int lessionId;
		int taoTiId;
		String OptionA;
		String OptionB;
		String OptionC;
		String OptionD;
		String answer;
		String note;
		Tb_lesson tbl;
		Tb_taoti tbt;
	    boolean answerA;
	    boolean answerB;
	    boolean answerC;
	    boolean answerD;
		String[] answers;
	    public String[] getAnswers() {
			return answers;
		}
		public void setAnswers(String[] answers) {
			this.answers = answers;
		}
		public boolean isAnswerA() {
			return answerA;
		}
		public void setAnswerA(boolean answerA) {
			this.answerA = answerA;
		}
		public boolean isAnswerB() {
			return answerB;
		}
		public void setAnswerB(boolean answerB) {
			this.answerB = answerB;
		}
		public boolean isAnswerC() {
			return answerC;
		}
		public void setAnswerC(boolean answerC) {
			this.answerC = answerC;
		}
		public boolean isAnswerD() {
			return answerD;
		}
		public void setAnswerD(boolean answerD) {
			this.answerD = answerD;
		}
		
		
		public Tb_lesson getTbl() {
			return tbl;
		}
		public void setTbl(Tb_lesson tbl) {
			this.tbl = tbl;
		}
		public Tb_taoti getTbt() {
			return tbt;
		}
		public void setTbt(Tb_taoti tbt) {
			this.tbt = tbt;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getJoinTime() {
			return joinTime;
		}
		public void setJoinTime(String joinTime) {
			this.joinTime = joinTime;
		}
		public int getLessionId() {
			return lessionId;
		}
		public void setLessionId(int lessionId) {
			this.lessionId = lessionId;
		}
		public int getTaoTiId() {
			return taoTiId;
		}
		public void setTaoTiId(int taoTiId) {
			this.taoTiId = taoTiId;
		}
		public String getOptionA() {
			return OptionA;
		}
		public void setOptionA(String optionA) {
			OptionA = optionA;
		}
		public String getOptionB() {
			return OptionB;
		}
		public void setOptionB(String optionB) {
			OptionB = optionB;
		}
		public String getOptionC() {
			return OptionC;
		}
		public void setOptionC(String optionC) {
			OptionC = optionC;
		}
		public String getOptionD() {
			return OptionD;
		}
		public void setOptionD(String optionD) {
			OptionD = optionD;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		
		
	
}
