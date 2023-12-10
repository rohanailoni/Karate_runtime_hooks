Feature: Testing My API

  Background:
    * url 'http://localhost:8090'

  Scenario: Verify API is Up
    Given path '/health'
    When method get
    Then status 200

  Scenario: Test Scenario 1
    Given path '/api/resource'
    When method get
    Then status 200
    And match response == { id: '#number', name: '#number' }

  Scenario: Test Scenario 2
    Given path '/api/resource'
    And request { name: 'New Resource' }
    When method post
    Then status 201
