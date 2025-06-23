# Problem statement <hr />
### High latency
- transmission delays (bandwidth)
- propagation delays (distance)
- queuing delays (n/w congestion)
- nodal processing delays

Real time app need latency of < 200 ms

Voice over internet protocol needs < 150 ms

Video streaming apps can't tolerate latency > a few seconds

### Data intensive streaming apps
- Because of network hops, throughput deceases
- Also, different portion of n/w can have different congestion characteristics.

### Scarcity of data center resources
- horizontal scaling in single data center poses risk of single point of failure

## CDN providers <hr/>
- Akamai
- StackPath
- Cloudflare
- Rackspace
- Amazon CloudFront
- Google Cloud CDN

## What is CDN?
- Geographically distributed proxy servers
- Placed on edge locations.
- Types of content: static and dynamic

## Dynamic content delivery protocols in CDN
- Real time messaging protocol (RTMP)
- HTTP Live streaming (HLS)
- Real time streaming protocol (RTSP)

## Functional requirements
The following functional requirements will be a part of our design:

- Retrieve: Depending upon the type of CDN models, a CDN should be able to retrieve content from the origin servers. We’ll cover CDN models in the coming lesson.
- Request: Content delivery from the proxy server is made upon the user’s request. CDN proxy servers should be able to respond to each user’s request in this regard.
- Deliver: In the case of the push model, the origin servers should be able to send the content to the CDN proxy servers.
- Search: The CDN should be able to execute a search against a user query for cached or otherwise stored content within the CDN infrastructure.
- Update: In most cases, content comes from the origin server, but if we run a script in a CDN, the CDN should be able to update the content within peer CDN proxy servers in a PoP.
- Delete: Depending upon the type of content (static or dynamic), it should be possible to delete cached entries from the CDN servers after a certain period.

## Non-Functional requirements
- Performance: Minimizing latency is one of the core missions of a CDN. The proposed design should have the minimum possible latency.
- Availability: CDNs are expected to be available at all times because of their effectiveness. Availability includes protection against attacks like DDoS.
- Scalability: An increasing number of users will request content from CDNs. Our proposed CDN design should be able to scale horizontally as the requirements increase.
- Reliability and security: Our CDN design should ensure no single point of failure. Apart from failures, the designed CDN must reliably handle massive traffic loads. Furthermore, CDNs should provide protection to hosted content from various attacks.

### Building blocks
- DNS
- Load balancer

### CDN components
- Clients
- Routing system
- Scrubber services
- Proxy servers
- Distribution system
- Origin servers
- Management system

### Workflow
The workflow for the abstract design is given below:

- The origin servers provide the URI namespace delegation of all objects cached in the CDN to the request routing system.
- The origin server publishes the content to the distribution system responsible for data distribution across the active edge proxy servers.
- The distribution system distributes the content among the proxy servers and provides feedback to the request routing system. This feedback is helpful in optimizing the selection of the nearest proxy server for a requesting client. This feedback contains information about which content is cached on which proxy server to route traffic to relevant proxy servers.
- The client requests the routing system for a suitable proxy server from the request routing system.
- The request routing system returns the IP address of an appropriate proxy server.
- The client request routes through the scrubber servers for security reasons.
- The scrubber server forwards good traffic to the edge proxy server.
- The edge proxy server serves the client request and periodically forwards accounting information to the management system. The management system updates the origin servers and sends feedback to the routing system about the statistics and detail of the content. However, the request is routed to the origin servers if the content isn’t available in the proxy servers. It’s also possible to have a hierarchy of proxy servers if the content isn’t found in the edge proxy servers. For such cases, the request gets forwarded to the parent proxy servers.
