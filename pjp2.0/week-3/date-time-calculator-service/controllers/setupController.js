var Option = require('../models/option');
const options = require('../constants/options');

module.exports = (app) => {
    app.get(`/api/seedOptions`, (req, res) => {
        var starterOptions = [
            {
                name: options.SUBTRACT_TWO_DATES
            },
            {
                name: options.ADD_N_DAYS_TO_GIVEN_DATE
            },
            {
                name: options.ADD_N_MONTHS_TO_GIVEN_DATE
            },
            {
                name: options.GET_DAY_OF_WEEK
            },
        ];
        Option.create(starterOptions, (err,results)=>{
            res.send(results);
        });
    });
}

