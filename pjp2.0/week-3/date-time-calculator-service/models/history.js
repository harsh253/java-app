const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const historySchema = new Schema({
    operation:{
        type: String,
        required: true
    },
    dates: {
        type: Array
    },
    manipulator: {
        type: Number
    },
    result:{
        type: String
    }
})

var History = mongoose.model('History', historySchema);

module.exports = History;