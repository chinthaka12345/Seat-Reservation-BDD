package com.ru.seatreservation;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TableStepDefs {

	private Table table;
	
	@When("^I create table of (\\d+) seats named \"(.*?)\"$")
	public void i_create_table_of_seats_named(int arg1, String arg2) throws Throwable {
		table = new Table(arg1, arg2);
	}

	@Then("^that table should have (\\d+) vacant seats$")
	public void that_table_should_have_vacant_seats(int arg1) throws Throwable {
		assertEquals(arg1, table.getVacantSeats());
	}
}
