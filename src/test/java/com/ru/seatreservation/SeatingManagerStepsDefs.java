package com.ru.seatreservation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeatingManagerStepsDefs {

	private int maxGroupSize = 6;
	private List<Table> tables = new ArrayList<Table>();
	SeatingManager sMgr;
	
	@Given("^tables in restaurent$")
	public void tables_in_restaurent(List<TableEntry> arg1) throws Throwable {
		
		for(TableEntry table:arg1) {
			tables.add(new Table(table.size, table.name));
		}
		sMgr = new SeatingManager(tables, maxGroupSize);
	}

	
	@When("^no customers$")
	public void no_customers() throws Throwable {
	}

	@Then("^all tables shoud be vacant$")
	public void all_tables_shoub_be_vacant() throws Throwable {
		for(int i=0; i<sMgr.vacantSeats.size(); i++) {
			if(sMgr.vacantSeats.get(i)!=null) {
				for(Table vacant : sMgr.vacantSeats.get(i)) {
					if(vacant!=null) {
						assertEquals(vacant.getVacantSeats(), vacant.getSize());
					}
				}
			}
		}
		printStatus();
	}
	
	@When("^arrive group of (\\d+)$")
	public void arrive_group_of(int arg1) throws Throwable {
		CustomerGroup cusGrp = new CustomerGroup(arg1);
		sMgr.arrives(cusGrp);
	}

	
	@Then("^should allocate table \"(.*?)\"$")
	public void should_allocate_table(String arg1) throws Throwable {
	    CustomerGroup cusGrp = sMgr.getCustomerGroupByIndex(0);	// First group
	    assertEquals(cusGrp.getTable().getName(), arg1);
	    printStatus();
	}
	
	
    public class TableEntry {
        String name;
        Integer size;
    }

    public void printStatus() {
		System.out.println("### current status ###");
		System.out.println("Table name \t| No. of empty seats \t| Table capacity");
		for(int i=0; i<sMgr.vacantSeats.size(); i++) {
			if(sMgr.vacantSeats.get(i)!=null) {
				for(Table vacant : sMgr.vacantSeats.get(i)) {
					if(vacant!=null) {
						System.out.println(vacant.getName() + "\t\t| " + vacant.getVacantSeats() + "\t\t\t| " + vacant.getSize());
					}
				}
			}
		}		
		System.out.println("\n");
    	
    }
}
