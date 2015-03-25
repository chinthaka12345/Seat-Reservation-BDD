Feature: SeatingManager basics

	Background: Set tables
		Given tables in restaurent
		|  name 	| size	 	|
		|	1		|	2		|
		|	2		|	4		|
		|	3		|	5		|
		|	4		|	3		|

	Scenario: Check empty tables
		When no customers
		Then all tables shoud be vacant
		
	Scenario: Allocate correct table, case 1
		When arrive group of 3
		Then should allocate table "4"