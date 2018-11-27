# Spring Framework

## Important annotations

- @SpringBootApplication: adds @Configuration, @EnableAutoConfiguration and @ComponentScan
- A daemon is a program that runs on a background process
- @Data is a lombok annotation that creates all gets, settings, hash and toString methods, based on the fields (thank God for this)
- @Entity is part of the JPA, makes the object read for storage in a JPA-based data store. (JPA - java persistence API)
- Srping data repositories do all the boring work (CRUD, paging, sorting, talking to the DB, etc)
- Spring Boot runs all command line runner beans once the application is loaded
- @ResponseBody means the the advise will be rendered straight into response body
- Exception handler means it only works when an employee not found exception is thrown
- @ResponseStatus sets the status response to 404

Difference between Rest and RPC:

I am getting frustrated by the number of people calling any HTTP-based interface a REST API. Today’s example is the SocialSite REST API. That is RPC. It screams RPC. There is so much coupling on display that it should be given an X rating.

What needs to be done to make the REST architectural style clear on the notion that hypertext is a constraint? In other words, if the engine of application state (and hence the API) is not being driven by hypertext, then it cannot be RESTful and cannot be a REST API. Period. Is there some broken manual somewhere that needs to be fixed? - Roy Fielding

Hateos - hypermedia as the engine of application state is a constraint of the rest application architecture. Compare:

```json
{
    "name" : "Alice"
}
```

```json
{
    "name": "Alice",
    "links": [ {
        "rel": "self",
        "href": "http://localhost:8080/customer/1"
    } ]
}
```

The second response contains self-linking url where the person is located.

- rel: means relationship. Self means it's a self-referencing link.
- href: complete url that uniquely defines the resource

More complex example:

```json
{
    "content": [ {
        "price": 499.00,
        "description": "Apple tablet device",
        "name": "iPad",
        "links": [ {
            "rel": "self",
            "href": "http://localhost:8080/product/1"
        } ],
        "attributes": {
            "connector": "socket"
        }
    }, {
        "price": 49.00,
        "description": "Dock for iPhone/iPad",
        "name": "Dock",
        "links": [ {
            "rel": "self",
            "href": "http://localhost:8080/product/3"
        } ],
        "attributes": {
            "connector": "plug"
        }
    } ],
    "links": [ {
        "rel": "product.search",
        "href": "http://localhost:8080/product/search"
    } ]
}
```

- Resource<T> is a generic container that includes a collection of links on top of the data
- HAL - Hypertext Application Language: simple format that gives a consistent and easy way to hyperlink between resources in your api. Convention: The HAL conventions revolve around representing two simple concepts: Resources and Links.

Resources have:

Links (to URIs)
Embedded Resources (i.e. other resources contained within them)
State (your bog standard JSON or XML data)

The HAL conventions revolve around representing two simple concepts: Resources and Links.

Resources have:

Links (to URIs)
Embedded Resources (i.e. other resources contained within them)
State (your bog standard JSON or XML data)

- @Component creates a component when the app starts
- Rest is not a technology stack or a single standard. It's a collection of architectural constraints
- There is an old strategy that precedes REST by years: Never delete a column in a database.
- ResponseEntity is used to create a http 201 created status message