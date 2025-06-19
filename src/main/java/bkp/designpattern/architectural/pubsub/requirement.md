## Functional requirement <hr />
**Create a topic:** The producer should be able to create a topic.

**Write messages:** Producers should be able to write messages to the topic.

**Subscription:** Consumers should be able to subscribe to the topic to receive messages.

**Read messages:** The consumer should be able to read messages from the topic.

**Specify retention time:** The consumers should be able to specify the retention time after which the message should be deleted from the system.

**Delete messages:** A message should be deleted from the topic or system after a certain retention period as defined by the user of the system.

## Non functional requirements <hr/>
**Scalable:** The system should scale with an increasing number of topics and increasing writing (by producers) and reading (by consumers) load.

**Available:** The system should be highly available, so that producers can add their data and consumers can read data from it anytime.

**Durability:** The system should be durable. Messages accepted from producers must not be lost and should be delivered to the intended subscribers.

**Fault tolerance:** Our system should be able to operate in the event of failures.

**Concurrent:** The system should handle concurrency issues where reading and writing are performed simultaneously.
