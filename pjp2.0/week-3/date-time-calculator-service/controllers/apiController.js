const Option = require('../models/option');
const bodyParser = require('body-parser');
const options = require('../constants/options');
const services = require('../services');
const History = require('../models/history');

module.exports = (app)=>{

    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({extended:true}));


    app.get('/api/options', (req,res)=>{
        Option.find({}, (err,result)=>{
            if(err){
                throw err;
            }
            res.send(result);
        })
    })

    app.post('/api/options', (req,res)=>{
        var option = new Option({
            name: req.body.name.trim()
        })
        option.save((err)=>{
            if(err){
                throw err;
            }
            res.send("Option added successfully");
        })
    })

    app.delete('/api/options', (req,res)=>{
        Option.findByIdAndRemove(req.body.id, (err)=>{
            if(err){
                throw err;
            }
            res.send("Option has been deleted");
        })
    })

    app.post('/api/option/:id', (req,res)=>{
        Option.findById(req.params.id, (err,result)=>{
            if(err){
                throw err;
            }
            switch(result.name){
                case options.SUBTRACT_TWO_DATES:
                    var date1 = req.body.date1;
                    var date2 = req.body.date2;
                    History.create({
                        operation : options.SUBTRACT_TWO_DATES,
                        dates: [date1, date2],
                        result: services.subtractTwoDates(date1, date2)
                    }, (err,response)=>{
                        if(err){
                            throw err
                        }
                        res.send(response);
                    })
                break;

                case options.ADD_N_DAYS_TO_GIVEN_DATE:
                    var date = new Date(req.body.date);
                    var manipulator = parseInt(req.body.manipulator);
                    History.create({
                        operation: result.name,
                        dates: [req.body.date],
                        result: services.addNDays(date,manipulator),
                        manipulator
                    }, (err,response)=>{
                        if(err){
                            throw err;
                        }
                        res.send(response);
                    })
                break;

                case options.ADD_N_MONTHS_TO_GIVEN_DATE:
                    var date = new Date(req.body.date);
                    var manipulator = parseInt(req.body.manipulator);
                    History.create({
                        operation: result.name,
                        dates: [req.body.date],
                        result: services.addNMonths(date,manipulator),
                        manipulator
                    }, (err,response)=>{
                        if(err){
                            throw err;
                        }
                        res.send(response);
                    })
                break;

                case options.GET_DAY_OF_WEEK:
                    var date = new Date(req.body.date);
                    History.create({
                        operation: result.name,
                        dates: [req.body.date],
                        result: services.getDayOfWeek(date),
                    }, (err,response)=>{
                        if(err){
                            throw err;
                        }
                        res.send(response);
                    })
                break;
            }
        })

        
    })
}