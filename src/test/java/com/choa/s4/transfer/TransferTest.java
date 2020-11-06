package com.choa.s4.transfer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.card.Card;

public class TransferTest extends MyTestCase{
	
	@Autowired
	private Bus bus;
	@Autowired
	private Subway subway;
	@Autowired
	private Taxi taxi;
	//@Autowired
	private Card card;
	
	@Test
	public void test() {
	
		//card.cardCheck();
		bus.takeBus();
		//card.cardCheck();
		//card.cardCheck();
		//subway.takeSubWay();
		//card.cardCheck();
		taxi.takeTaxi();
		
		//subway.takeSubWay();
	}

}
