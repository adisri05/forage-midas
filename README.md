Task 1 – Add Required Dependencies
Added Maven dependencies (JPA, Web, Kafka, H2, test deps) and ran TaskOneTests to get the begin/end snippet.


Task 2 – Kafka Integration
Set general.kafka-topic: trader-updates, added Kafka config for JSON Transaction serialization, implemented TransactionListener that listens on the configured topic and deserializes to Transaction. Ran TaskTwoTests and recorded the first four transaction amounts.


Task 3 – H2 Database Integration
Added TransactionRecord entity (many-to-one to sender/recipient UserRecord), validation (sender/recipient exist, sender balance ≥ amount), and logic to persist valid transactions and update balances. Ran TaskThreeTests and recorded waldorf’s balance (rounded down).


Task 4 – Incentive API Integration
Added Incentive DTO and incentive API client; after validation, POST transaction to incentive API, store incentive on the record, and update recipient with amount + incentive (sender only debited by amount). Ran TaskFourTests with Incentive API running and recorded wilbur’s balance (rounded down).


Task 5 – Balance REST API
Added GET /balance?userId=... returning Balance JSON on port 33400; non-existent user returns balance 0. Did not change Balance or its toString(). Ran TaskFiveTests and submitted the output including begin/end tags.
