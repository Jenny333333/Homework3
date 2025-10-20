package service;

import java.time.LocalTime;

import model.Clock;

public interface ClockService {
	//read
	Clock getRandomClock(String level);
    //boolean checkAnswer(Clock clock, LocalTime userInput);
	int checkAnswerLevel(Clock clock, LocalTime userInput);
}
