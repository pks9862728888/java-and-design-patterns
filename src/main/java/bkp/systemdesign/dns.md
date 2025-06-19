### Terminologies <hr />

**A record**:
- Maps domain name to its corresponding IPv4 address

**AAA record:**
- Maps domain name to its corresponding IPv6 address

**Nameserver**
- Nameserver translates domain name to IP address by querying other nameservers in hierarchical manner.

**Cname**
- Cname provides mapping of alias domain name to primary domain name.

**Mx record**
- Directs email to specific mail server for a domain.

# Parts of url <hr />
http://mail.google.com

Here .com is top level domain
google is second level domain
mail is a part of sub-domain hierarchy under google.com
http:// is protocol which tells browser how to communicate with this server

# How is the DNS hierarchy formed using various types of DNS name servers? <hr />
DNS resolver -> root level name server -> top level domain server -> authoritative domain name server

## Iterative vs recursive query resolution <hr />
Recursive query: DNS resolver asks the root ns for response, which queries next one to get the response.

Iterative query: Local DNS resolver asks the name server for next server till ip is resolved

### Caching <hr />
- Browser
- OS
- Local DNS resolver
- ISP
- DNS Infrastructure

It’s worth adding that DNS sacrifices strong consistency to achieve high performance and scalability because it processes many read operations compared to write operations. Updates propagate lazily, which helps responses stay fast without overloading the system.

# How is caching performed at different levels of the Internet to reduce the querying burden over the DNS infrastructure?
2 min
