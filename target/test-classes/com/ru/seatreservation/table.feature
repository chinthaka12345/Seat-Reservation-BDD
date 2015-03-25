Feature: Table basics

  Scenario: Create a table  
    When I create table of 4 seats named "table A"
    Then that table should have 4 vacant seats
