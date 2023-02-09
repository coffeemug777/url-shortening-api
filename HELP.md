# Getting Started

/api/create<br />
body:
type UrlDataRequest {<br />
    "url":"someurlstring"<br />
}

response expected: 

type UrlDataResponse = {<br />
    "id": Long,<br />
    "url": "someurlstring",<br />
    "shortUrl": "7charhash"<br />
}

/api/get/id<br />
expected response: UrlDataResponse

/api/get/all<br />
expected response: UrlDataResponse[]

This repo is the API called by the 

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

