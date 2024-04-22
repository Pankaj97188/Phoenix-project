# Author: Ali
# Keywords Summary: Create Job API Feature
@e2e @api @sanity
Feature: Job Creation API Functionality
  The Job Creation API feature enables (FD) to efficiently create new job entries within the system.

  Background: (FD) Login and Token Generation
    Given the base URL of the application is "http://139.59.91.96:9000/v1"
    And FD used the credentials "iamfd" and "password"
    When a post request is made to the endpoint "login"
    Then a JWT token is created

  Scenario: In-Warranty Job Creation

  Scenario Outline: Creating an In-warranty Job with Multiple Data Sets
    Given the base URL of the application is "http://139.59.91.96:9000/v1"
    And the Header for the request is
      | Key          | Value            |
      | Content-Type | application/json |
    When I make a POST request to the endpoint "job/create" with the following request body:
      """
      {
        "mst_service_location_id": 1,
        "mst_platform_id": 2,
        "mst_warrenty_status_id": 1,
        "mst_oem_id": 1,
        "customer": {
          "first_name": "<first_name>",
          "last_name": "<last_name>",
          "mobile_number": "<mobile_number>",
          "mobile_number_alt": "<mobile_number_alt>",
          "email_id": "<email_id>",
          "email_id_alt": "<email_id_alt>"
        },
        "customer_address": {
          "flat_number": "<flat_number>",
          "apartment_name": "<apartment_name>",
          "street_name": "<street_name>",
          "landmark": "<landmark>",
          "area": "<area>",
          "pincode": "<pincode>",
          "country": "<country>",
          "state": "<state>"
        },
        "customer_product": {
          "dop": "<dop>",
          "serial_number": "<serial_number>",
          "imei1": "<imei1>",
          "imei2": "<imei2>",
          "popurl": "<popurl>",
          "product_id": <product_id>,
          "mst_model_id": <mst_model_id>
        },
        "problems": [
          {
            "id": 1,
            "remark": "Phone not working"
          }
        ]
      }
      """
    Then a job number needs to be created
    And the job number should be an integer
    And a customer ID should be created
    And the customer ID should be an integer
    And the status code should be 200

    Examples: 
      | first_name | last_name | mobile_number | mobile_number_alt | email_id         | email_id_alt | flat_number | apartment_name | street_name | landmark | area     | pincode | country | state       | dop        | serial_number   | imei1           | imei2           | popurl                  | product_id | mst_model_id |
      | Renuka     | S         |    7045663552 |        9876543210 | renuka@gmail.com |              |         101 | Riverview      | Main St     | Park     | Downtown |  123456 | Mumbai  | Maharashtra | 2024-01-15 | 831243453523121 | 831243453523121 | 831243453523121 | http://google-pixel.com |          1 |            1 |
      | Ali        | E         |    9876543210 |        1234567890 | ali@yahoo.com    |              |         202 | Lakeview       | Elm St      | Mall     | Suburb   |  654321 | Delhi   | Delhi       | 2023-11-28 | 464386343243432 | 464386343243432 | 464386343243432 | http://nexus.com        |          1 |            1 |
