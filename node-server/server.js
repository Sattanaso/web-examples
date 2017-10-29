const express = require('express'),
    bodyParser = require('body-parser'),
    app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app
    .get('/data', function (req, res, next) {
        let dataObj = {
            "data": [
                {
                    "name": "Petarcho",
                    "age": "33"
                },
                {
                    "name": "Gancho",
                    "age": "23"
                },
                {
                    "name": "Petranka",
                    "age": "37"
                },
                {
                    "name": "Petkano",
                    "age": "13"
                },
                {
                    "name": "Dimi",
                    "age": "44"
                },
                {
                    "name": "Goshko",
                    "age": "22"
                }
            ]
        }

        res.status(200).json(dataObj);
    })
    .post('/data', function (req, res, next) {
        let postData = req.body;
        let postHeaders = req.headers;

        let line = "------------------------------";

        console.log(line);
        console.log(postData);
        console.log(line);
        console.log(req.headers);
        console.log(line);

        res.status(200).json("POST OK");
    })

const port = process.env.PORT || 3003;
app.listen(port);
console.log(`Server running on port:${port}`);

// http://localhost:3003/data