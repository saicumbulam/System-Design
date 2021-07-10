# Claim Check

## What

* Split a large message into a claim check and a payload. 
* Send the claim check to the messaging platform and store the payload to an external service. 
* This pattern allows large messages to be processed, while protecting the message bus and the client from being overwhelmed or slowed down. 
* This pattern also helps to reduce costs, as storage is usually cheaper than resource units used by the messaging platform.

## How

Store the entire message payload into an external service, such as a database. Get the reference to the stored payload, and send just that reference to the message bus. The reference acts like a claim check used to retrieve. ![picture 31](../../../.gitbook/assets/d842855ea46476ebdd3a8696caf286065ad3b66bce62a58d89eaaf2b79256f4b.png)

