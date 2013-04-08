var connect = require('connect');
var dir = __dirname+"/../war";

connect.createServer(
    connect.static(dir)
    ).listen(9000);


console.log("Serving "+dir);
