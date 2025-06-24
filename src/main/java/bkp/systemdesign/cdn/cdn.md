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

## What is CDN? <hr />
- Geographically distributed proxy servers
- Placed on edge locations.
- Types of content: static and dynamic

## Dynamic content delivery protocols in CDN <hr />
- Real time messaging protocol (RTMP)
- HTTP Live streaming (HLS)
- Real time streaming protocol (RTSP)

## Types of CDN (push / pull model) <hr />
The push CDN is mostly used for serving static content. Since static content is served to a wide range of users for longer than dynamic content, the push CDN scheme maintains more replicas than the pull CDN, thus improving availability. On the other hand, the pull CDN is favored for frequently changing content and a high traffic load. Low storage consumption is one of the main benefits of the pull CDN.

## Dynamic content caching optimization <hr />
To reduce the communication between the origin server and proxy servers and storage requirements at proxy servers, it’s useful to employ compression techniques as well. For example, Cloudflare uses Railgun to compress dynamic content.

Another popular approach for dynamic data compression is Edge Side Includes (ESI) markup language. Usually, a small portion of the web pages changes in a certain time. It means fetching a full web page on each small change contains a lot of redundant data. To resolve this performance penalty, ESI specifies where content was changed so that the rest of the web page content can be cached. It assembles dynamic content at the CDN edge server or client browser. ESI isn’t standardized yet by the World Wide Web Consortium (W3C), but many CDN providers use it.

Note: Dynamic Adaptive Streaming over HTTP (DASH) uses a manifest file with URIs of the video with different resolutions so that the client can fetch whatever is appropriate as per prevailing network and end node conditions. Netflix uses a proprietary DASH version with a Byte-range in the URL for further content request and delivery optimization.

## Multi-tier CDN architecture <hr />
The content provider sends the content to a large number of clients through a CDN. The task of distributing data to all the CDN proxy servers simultaneously is challenging and burdens the origin server significantly. CDNs follow a tree-like structure to ease the data distribution process for the origin server. The edge proxy servers have some peer servers that belong to the same hierarchy. This set of servers receives data from the parent nodes in the tree, which eventually receive data from the origin servers. The data is copied from the origin server to the proxy servers by following different paths in the tree.

The tree structure for data distribution allows us to scale our system for increasing users by adding more server nodes to the tree. It also reduces the burden on the origin server for data distribution. A CDN typically has one or two tiers of proxy servers (caches).

## What happens if a child or parent proxy server fails or if the origin server fails?
Each PoP contains a collection of CDN proxy servers. When any child proxy server stops working due to any failures, DNS can route clients to a different child-level proxy server. Each child proxy server knows many upper-layer parent servers, and if one fails, it can go to the other one. The origin server is a set of servers with a hot backup(s), and content is in replicated store. If any of the origin servers fail, other servers take the load.

## Important factors that affect the proximity of the proxy server <hr />
There are two important factors that are relevant to finding the nearest proxy server to the user:

Network distance between the user and the proxy server is crucial. This is a function of the following two things:
The first is the length of the network path.
The second is the capacity (bandwidth) limits along the network path.
The shortest network path with the highest capacity (bandwidth) is the nearest proxy server to the user in question. This path helps the user download content more quickly.

Requests load refers to the load a proxy server handles at any point in time. If a set of proxy servers are overloaded, the request routing system should forward the request to a location with a lesser load. This action balances out the proxy server load and, consequently, reduces the response latency.

## DNS redirection <hr />
In a typical DNS resolution, we use a DNS system to get an IP against a human-readable name. However, the DNS can also return another URI (instead of an IP) to the client. Such a mechanism is called DNS redirect.

Content providers can use DNS redirect to send a client to a specific CDN. As an example, if the client tries to resolve a name that has the word “video” in it, the authoritative DNS server provides another URL (for example, cdn.xyz.com). The client does another DNS resolution, and the CDN’s authoritative DNS provides an IP address of an appropriate CDN proxy server to fetch the required content.

Depending on the location of the user, the response of the DNS can be different.

There are two steps in the DNS redirection approach:

- In the first step, it maps the clients to the appropriate network location.
- In the second step, it distributes the load over the proxy servers in that location to balance the load among the proxy servers (see DNS and Load Balancers building blocks for more details on this).

DNS redirection takes both of these important factors—network distance and requests load—into consideration, and that reduces the latency towards a proxy server.

> The nearest proxy server doesn’t necessarily mean the one that’s geographically the closest. It could be, but it’s not only the geography that matters. Other factors like network distance, bandwidth, and traffic load already on that route also matter.

## Anycast <hr />
Anycast is a routing methodology in which all the edge servers located in multiple locations share the same single IP address. It employs the Border Gateway Protocol (BGP) to route clients based on the Internet’s natural network flow.
A CDN provider can use the anycast mechanism so that clients are directed to the nearest proxy servers for content.

## Client multiplexing <hr />
Client multiplexing involves sending a client a list of candidate servers. The client then chooses one server from the list to send the request to. This approach is inefficient because the client lacks the overall information to choose the most suitable server for their request. This may result in sending requests to an already-loaded server and experiencing higher access latency.

## Http redirection <hr/>
HTTP redirection is the simplest of all approaches. With this scheme, the client requests content from the origin server. The origin server responds with an HTTP protocol to redirect the user via a URL of the content.

# Data consistency in CDN <hr />
## DC: Periodic polling
Using the pull model, proxy servers request the origin server periodically for updated data and change the content in the cache accordingly. When content changes infrequently, the polling approach consumes unnecessary bandwidth. Periodic polling uses time-to-refresh (TTR) to adjust the time period for requesting updated data from the origin servers.

## DC: TTL
Because of the TTR, the proxy servers may uselessly request the origin servers for updated data. A better approach that could be employed to reduce the frequency of refresh messages is the time-to-live (TTL) approach. In this approach, each object has a TTL attribute assigned to it by the origin server. The TTL defines the expiration time of the content. The proxy servers serve the same data version to the users until that content expires. Upon expiration, the proxy server checks for an update with the origin server. If the data is changed, it gets the updated data from the origin server and then responds to the user’s requests with the updated data. Otherwise, it keeps the same data with an updated expiration time from the origin servers.

## DC: Leases
The origin server grants a lease to the data sent to a proxy server using this technique. The lease denotes the time interval for which the origin server agrees to notify the proxy server if there’s any change in the data. The proxy server must send a message requesting a lease renewal after the expiration of the lease. The lease method helps to reduce the number of messages exchanged between the proxy and origin server. Additionally, the lease duration can be optimized dynamically according to the observed load on the proxy servers. This technique is referred to as an adaptive lease.

# Placement of CDN proxy servers <hr />
We can use measurements to facilitate the decision of proxy server placement. One such tool is ProxyTeller to decide where to place the proxy server and how many proxy servers are required to achieve high performance. ProxyTeller uses hit ratio, network bandwidth, and client-response time (latency) as performance parameters to decide the placement of proxy servers. Other greedy, random, and hotspot algorithms are also used for proxy server placements.

> Note: Akamai and Netflix popularized the idea of keeping their CDN proxy servers inside the client’s ISPs. For many clients of Akamai, content is just one network hop away. On the other hand, Google also has its private CDN infrastructure but relies more on its servers near IXPs. One reason for this could be the sheer amount of data and the change patterns.

> Note: Some companies make their own CDN instead of using the services of CDN providers. For example, Netflix has its own purpose-built CDN called Open Connect.

## Specialized CDN <hr />
We’ve discussed that many companies use CDN as a service, but there are cases where companies build their own CDN. A number of reasons factor into this decision. One is the cost of a commercial CDN service. A specialized CDN consists of points of presence (PoPs) that only serve content for their own company. These PoPs can be caching servers, reverse proxies, or application delivery controllers. Although a specialized CDN has high costs at its first setup, the costs eventually decrease with time. In essence, it’s a buy versus build decision.

# Why Netflix built its own CDN? <hr />
As Netflix became more popular, it decided to build and manage its own CDN for the following reasons:

The CDN service providers were scuffling to expand their infrastructure due to the rapid growth in customer demand for video streaming on Netflix.

With the increasing volume of streaming videos, the expense of using CDN services increased.

Video streaming is the main business and a primary revenue source for Netflix. So, protecting the data of all the videos on the platform is critical. Netflix’s OCA manages potential data leakage risks in a better way.

To provide optimal streaming media delivery to customers, Netflix needed to maximize its control over the user’s video player, the network between the user, and the Netflix servers.

Netflix’s OCA can use custom HTTP modules and TCP connection algorithms to detect network problems quickly and troubleshoot any issues in their CDN network.

Netflix wanted to keep popular content for a long time. This wasn’t entirely possible while operating with a public CDN due to the high costs that would be incurred to keep and maintain it.

> Note: Netflix is able to achieve a hit ratio close to 95% using OCA.

## What benefits could an ISP get by placing the CDN proxy servers inside their network? <hr />
- A CDN node cuts down the amount of external bandwidth that ISPs need and pay for. The SLA defined by ISPs with the proxy server providers may benefit the ISPs economically.
- A CDN node improves responsiveness for the ISP’s customers, which makes the ISP’s customers happier. This gives them a competitive advantage over ISPs that don’t have a CDN node.
- Bringing content closer to the users reduces data on the Internet core.

## Functional requirements <hr />
The following functional requirements will be a part of our design:

- Retrieve: Depending upon the type of CDN models, a CDN should be able to retrieve content from the origin servers. We’ll cover CDN models in the coming lesson.
- Request: Content delivery from the proxy server is made upon the user’s request. CDN proxy servers should be able to respond to each user’s request in this regard.
- Deliver: In the case of the push model, the origin servers should be able to send the content to the CDN proxy servers.
- Search: The CDN should be able to execute a search against a user query for cached or otherwise stored content within the CDN infrastructure.
- Update: In most cases, content comes from the origin server, but if we run a script in a CDN, the CDN should be able to update the content within peer CDN proxy servers in a PoP.
- Delete: Depending upon the type of content (static or dynamic), it should be possible to delete cached entries from the CDN servers after a certain period.

## Non-Functional requirements <hr />
- Performance: Minimizing latency is one of the core missions of a CDN. The proposed design should have the minimum possible latency.
- Availability: CDNs are expected to be available at all times because of their effectiveness. Availability includes protection against attacks like DDoS.
- Scalability: An increasing number of users will request content from CDNs. Our proposed CDN design should be able to scale horizontally as the requirements increase.
- Reliability and security: Our CDN design should ensure no single point of failure. Apart from failures, the designed CDN must reliably handle massive traffic loads. Furthermore, CDNs should provide protection to hosted content from various attacks.

### Building blocks <hr />
- DNS
- Load balancer

### CDN components <hr />
- Clients
- Routing system
- Scrubber services
- Proxy servers
- Distribution system
- Origin servers
- Management system

### Workflow <hr />
The workflow for the abstract design is given below:

- The origin servers provide the URI namespace delegation of all objects cached in the CDN to the request routing system.
- The origin server publishes the content to the distribution system responsible for data distribution across the active edge proxy servers.
- The distribution system distributes the content among the proxy servers and provides feedback to the request routing system. This feedback is helpful in optimizing the selection of the nearest proxy server for a requesting client. This feedback contains information about which content is cached on which proxy server to route traffic to relevant proxy servers.
- The client requests the routing system for a suitable proxy server from the request routing system.
- The request routing system returns the IP address of an appropriate proxy server.
- The client request routes through the scrubber servers for security reasons.
- The scrubber server forwards good traffic to the edge proxy server.
- The edge proxy server serves the client request and periodically forwards accounting information to the management system. The management system updates the origin servers and sends feedback to the routing system about the statistics and detail of the content. However, the request is routed to the origin servers if the content isn’t available in the proxy servers. It’s also possible to have a hierarchy of proxy servers if the content isn’t found in the edge proxy servers. For such cases, the request gets forwarded to the parent proxy servers.
