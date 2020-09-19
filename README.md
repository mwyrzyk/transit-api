
# Transit API

> You are a truck driver. You haul fresh buns, ham etc. every day ( ͡° ͜ʖ ͡°) You want to create an application,
 which helps you to keep track of transits, driven distance and money you earned.

This project is my solution of a sample entry task for backend developer job.
 
 Application should comply with provided documentation.
 No authentication is required.

## Documentation

### Transit :heavy_check_mark:

Endpoint to add a transit. Distance between source and destination address should be evaluated by application.

HTTP REQUEST POST http://example.com/transits

Request body example:
```javascript
{
  "source_address":         "ul. Zakręt 8, Poznań",
  "destination_address":    "Złota 44, Warszawa",
  "price":                  450,
  "date":                   "2018-03-15"
}
```
Additional points for asynchronous distance evaluation.

### Get daily report :soon:

Endpoint returns driven distance and earned money between two dates.

HTTP REQUEST GET http://example.com/reports/daily?start_date=YYYY-MM-DD&end_date=YYYY-MM-DD

```
Response body example:
```javascript
{
  "total_distance": "90km",
  "total_price":    "115PLN"
}
```

### Get monthly report :soon:

Endpoint returns total driven distance and average distance and price of transit for every day in current month. For instance: if request is send on 5th March response contains dates from 1st to 4th March.

HTTP REQUEST GET http://example.com/reports/monthly

Response body example:
```javascript
[
  {
    "date":                "March, 1st",
    "total_distance": "240km",
    "avg_distance":   "70km",
    "avg_price":        "213.7PLN"
  },
  {
    "date":                "March, 2nd",
    "total_distance": "76km",
    "avg_distance":   "76km",
    "avg_price":        "90.3PLN"
  },
  <...>
]
```
