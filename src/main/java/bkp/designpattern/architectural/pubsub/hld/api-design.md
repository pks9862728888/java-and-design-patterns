## API Design <hr />
- Create topic
```
create(topicId, topicName)
```
- Write message
```
write(topicId, message)
```
- Subscription
```
subscribe(topicId, consumerId, consumerGroupId)
```
- Unsubscribe
```
unsubscribe(topicId, consumerId)
```
- Read messages
```
read(topicId, consumerId, consumerGroupId)
```
- Specify retention time
```
setRetention(topicId, timeInMs, consumerId)
```
- Delete topic
```
delete(topicId)
```
