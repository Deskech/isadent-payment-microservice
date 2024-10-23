# Payments Microservice

This microservice is responsible for recording new payments via a POST request, specifying the patient's name and the payment they made. This microservice implements CQRS and event sourcing, allowing the read side to provide the history of all payments made by a patient over time. It publishes events to the **Bill** microservice so that it can update its values.

## Table of Contents
- [Installation](#installation)
- [JavaDocs](#Documentation)
- [Examples](#Examples)
- - [Creating a new payment](#creating-a-new-payment-)
- - [Payment history request](#payment-history-request-)
- [License](#license)
- 
## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Deskech/isadent-payment-microservicehttps://github.com/Deskech/isadent-payment-microservice
## Prerequisites
- **Java 17**
- **Maven**
- **RabbitMQ**
- **MySQL**

## Documentation



## Examples

### Creating a New Payment: ###

```http
POST /payments/newPayments

Content-Type: application/json
```
```json
{
  "patientName": "John Doe",
  "paymentValue": 100.50
}
```

### Payment history Request ###

```http
POST /payments/history

Content-Type: application/json
```
```json
{
"patientName": "John Doe"
}

```

__Response :__
 ```json
[
    {
    "paymentValue": 100.50,
    "patientName": "John Doe",
    "paymentDate": "2024-10-06"
    },
    {
    "paymentValue": 75.00,
    "patientName": "John Doe",
    "paymentDate": "2024-09-30"
    }
]
```
## License







