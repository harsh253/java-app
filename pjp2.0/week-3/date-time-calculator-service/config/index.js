const configValues = require('./config');

module.exports = {
    DBUrl: () => {
        return `mongodb+srv://${configValues.username}:${configValues.password}@cluster0.pomze.mongodb.net/${configValues.dbName}?retryWrites=true&w=majority`
    }
}