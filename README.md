# Tonic For Health - Test Task (Part 1)

## Summary

The application gets input JSON with the list of mathematical operations.
Then it goes one by one calculating the result.
Finally, sends it to the REST API endpoint.

Inner structure was created according to N-Tier architecture and SOLID principles.
Design patters used for implementation of an algorithm.

Stack:
- Java (JDK 11)
- Spring Boot
- Log4J
___

### Input data example:

```JSON
  {

    "operation_number":1,

    "input_array":[

        {"command":"append", "number":23},

        {"command":"multiply", "number":2},

        {"command":"power", "number":2}

    ]

  }
```
___

### Algorithm:

![image](https://i.ibb.co/hHqBysR/Screenshot-2022-05-30-at-21-57-06.png)
___

### Output data example:

```JSON
  {

    "result": 3

  }
```
___

### REST endpoint details:

- URL: https://dummy.com/api/[OPERATION_NUMBER]/result

- Method: POST

- Headers:

  - Accept-Language: en-US

  - Operation-Number: [OPERATION_NUMBER]
