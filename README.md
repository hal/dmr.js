
# dmr.js

JavaScript library to execute operations on the JBoss AS7 DMR API.
For an introduction to DMR please refer to the [JBoss Wiki](https://docs.jboss.org/author/display/AS7/Detyped+management+and+the+jboss-dmr+library)

## Prerequistes

- node.js
- npm
- maven
- JDK 7

## General Usage

### Import the dmr.js library

```
<html>
<script type="text/javascript" language="javascript" src="dmr.js/dmr.js.nocache.js"></script>
[...]
</html>
```

### DMR Invocation from JavaScript

```javascript

<script>
// access EC2 demo instance
http = new XMLHttpRequest();
http.open("POST", "http://as7-preview.dyndns.org:9990/management", true);

// async response handler
http.onreadystatechange =function()
{
    if (http.readyState==4 && http.status==200)
    {
        // decode response
        response = dmr.ModelNode.fromBase64(http.responseText);
        alert(response.get("result").asString());
    }
}

// content type headers for DMR API
http.setRequestHeader("Content-type","application/dmr-encoded");
http.setRequestHeader("Accept","application/dmr-encoded");

// create an operation
op = new dmr.ModelNode();
op.get("operation").set("read-attribute");
op.get("address").setEmptyList();
op.get("name").set("release-version");

// send as base64 encoded
http.send(op.toBase64String());

</script>
```

## Running the demo

```
cd scripts
npm install
```

### Build the JS module

```
mvn clean install
```

### Serve the files

```
node scripts/server.js
```

### Point your browser to

[http://localhost:9000/App.html](http://localhost:9000/App.html)


## Known Issues

### CORS Trouble

- It requires a patched AS7 instance if not running on the host.
- Some browsers require extra steps to get the authentication working

For a good summary of all the challenges see [Harald's Post](http://haraldpehl.blogspot.de/2013/03/independent-jboss-admin-console.html )



