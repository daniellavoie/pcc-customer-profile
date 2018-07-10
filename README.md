# Pivotal Cloud Cache Sample App - Customer Profile

This is a demo application that showcase the use of Pivotal Cloud Cache and Spring Data Gemfire.

## Prerequisites

* A Pivotal Cloud Foundry space.
* A MySQL service instance named `db`.
* A PCC service instance named `cache`.

## Preparing the Gemfire regions with gfsh

```
$ create region --type PARTITION --name customer-profile
$ create region --type PARTITION --name load-customer-profile-audit
```

## Build

``` 
$ mvnw clean package
```

## Deploy

```
$ cf push
```

## Testing the cache

The application will generate a thousands of records in its backing database with ids range from `1` to `1 000`.

A rest endpoints allows to query the backing database. Each database access is logged. This endpoint has cache enabled. Subsequent calls for a customer profile that was previously loaded will be served from the cache.

```
$ curl -X GET https://customer-profile.apps.TLD-DOMAIN/customer-profile/1
````
