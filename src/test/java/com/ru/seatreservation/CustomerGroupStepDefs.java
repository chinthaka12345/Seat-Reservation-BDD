package com.ru.seatreservation;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerGroupStepDefs {

	private CustomerGroup cusGrp;
	
	@When("^I create customer group of (\\d+) memebers$")
	public void i_create_customer_group_of_memebers(int arg1) throws Throwable {
		cusGrp = new CustomerGroup(arg1);
	}

	@Then("^that group should have (\\d+) members$")
	public void that_group_should_have_members(int arg1) throws Throwable {
		assertEquals(arg1, cusGrp.getSize());
	}
	
}
