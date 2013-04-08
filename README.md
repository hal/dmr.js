# Prerequistes

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
http.open("POST", "http://as7-preview.dyndns.org:9990/management", false);

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

// decode response
response = dmr.ModelNode.fromBase64(http.responseText);

alert(response.get("result").asString());

</script>
```

## Running the demo

```
cd scripts
npm install
```

### Build the GWT module

```
mvn clean install
```

### Serve the files

```
node scripts/server.js
```

### Point your browser to

[http://localhost:9000/App.html](http://localhost:9000/App.html)



