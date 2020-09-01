var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var optionSchema = new Schema({
    name: String
})

var Options = mongoose.model('Options', optionSchema);

module.exports = Options;
