const dateUtil = require('../utils/date');

module.exports = {
    subtractTwoDates: (date1, date2)=>{
        date1 = new Date(date1);
        date2 = new Date(date2);
        var diffMs = Math.abs(date1-date2);
        var days = parseInt(diffMs/(1000*60*60*24));
        var years = parseInt(diffMs/(1000*365*24*60*60));
        var months = parseInt(diffMs/(1000*30*24*60*60));
        var result = `${years} year(s) difference, ${months} months difference, ${days} days difference`
        return result;
    },

    addNDays: (date,n)=>{
        const newDate = date;
        newDate.setDate(date.getDate()+ n);
        return newDate.toDateString();
    },

    addNMonths: (date,n)=>{
        const newDate = date;
        newDate.setMonth(date.getMonth()+n);
        return newDate.toDateString();
    },

    getDayOfWeek: (date)=>{
        var dayNumber = date.getDay();
        return dateUtil.days[dayNumber].toString();
    },

    
}