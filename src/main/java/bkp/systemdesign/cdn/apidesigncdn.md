### Retrieve content (proxy server to origin server - pull) <hr />
`
retrieveContent(proxyServerId, contentType, contentVersion, contentMetaData)
`

- contentType = audio, video etc.
- contentMetaData = extension, resolution etc.

Response:
```json
{
  "Object_links": [
    {
      "name": "videos",
      "link": "https://app_server.com/api/assets/videos/"
    },
    {
      "name": "illustrations",
      "link": "https://app_server.com/api/assets/illustrations/"
    }
  ]
}
```

### Deliver content (origin server to proxy server - push) <hr />
`
deliverContent(originServerId, serverList, contentType, contentVersion, contentMetaData)
`

- serverList - list of servers to push content to


### Request content (client to proxy server) <hr />
`
requestContent(userId, contentType, contentMetaData)
`

Response:
```json
{
  "Object_links": [
    {
      "name": "components",
      "link": "https://cdn.app_server.com/api/components/"
    },
    {
      "name": "css",
      "link": "https://cdn.app_server.com/api/css/"
    }
  ]
}
```

### Search content (proxy server to p2p server) <hr />
`
searchContent(proxyServerId, contentType, contentMetaData)
`

### Update content (proxy server to p2p server) <hr />
`
updateContent(proxyServerId, contentType, contentMetaData)
`

The proxy servers use the /updateContent API to update the specified content in the peer proxy servers in the PoP. It does so when specified isolated scripts run on the CDN to provide image resizing, video resolution conversion, security, and many more services. This type of scripting is known as serverless scripting.

### Delete content  <hr />

