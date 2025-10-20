package service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dao.ClockDao;
import dao.impl.ClockDaoImpl;
import model.Clock;
import service.ClockService;

public class ClockServiceImpl implements ClockService{

	public static void main(String[] args) {

	}
	
	private ClockDaoImpl cdi=new ClockDaoImpl();

	private ClockDao clockDao;
	public ClockServiceImpl(ClockDao clockDao) {
	    this.clockDao = clockDao;
	}

	
	@Override
	public Clock getRandomClock(String level) {
		return cdi.getRandomClockByLevel(level);
	}

	@Override
	public int checkAnswerLevel(Clock clock, LocalTime userInput) {
		 if (clock == null || clock.getAnswer() == null) {
		        return 0;
		    }

		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		    LocalTime answerTime = LocalTime.parse(clock.getAnswer(), formatter);

		    userInput = userInput.withSecond(0).withNano(0);
		    answerTime = answerTime.withSecond(0).withNano(0);

		    int stars = 0;

		    if (userInput.equals(answerTime)) {
		        stars = 3;
		    } else if (userInput.getHour() == answerTime.getHour() || userInput.getMinute() == answerTime.getMinute()) {
		        stars = 2;
		    } else {
		        String userMin = String.format("%02d", userInput.getMinute());
		        String ansMin = String.format("%02d", answerTime.getMinute());

		        if (userMin.charAt(0) == ansMin.charAt(0) || userMin.charAt(1) == ansMin.charAt(1)) {
		            stars = 1;
		        }
		    }

		    return stars;
	    }}

