var Y = {
    isNumeric: function isNumric(obj) {
        return !isNaN(parseFloat(obj)) && isFinite(obj);
    },
    getInt: function (num) {
        if (Y.isNumeric(num)) {
            return num < 0 ? Math.ceil(num) : Math.floor(num);
        } else {
            throw {
                name: 'TypeError',
                message: '非法参数'
            }
        }
    },
    trim: function (s) {
        return typeof s === 'string' ? s.replace(/\s+/g, '') : s;
    },
    dateFmt: function (date,format) {
        var o = {
            "M+": date.getMonth() + 1, //month
            "d+": date.getDate(),    //day
            "H+": date.getHours(),   //hour
            "m+": date.getMinutes(), //minute
            "s+": date.getSeconds(), //second
            "q+": Math.floor((date.getMonth() + 3) / 3),  //quarter
            "S": date.getMilliseconds() //millisecond
        };
        if (/(y+)/.test(format)) {
            var year = date.getFullYear()+'';
            format = format.replace(RegExp.$1,year);
        }
        for (var k in o) {
            if (new RegExp('(' + k + ')').test(format)) {
                format = format.replace(RegExp.$1,
                    RegExp.$1.length == 1 ? o[k] :
                        ('00' + o[k]).substr(('' + o[k]).length));
            }
        }
        return format;
    },
    memoizer: function(memo,fundamental){
        var shell = function(n){
            var result = memo[n];
            if(typeof result !== 'number'){
                result = fundamental(shell,n);
                memo[n] = result;
            }
            return result;
        };
        return shell;
    },
    scroll4ul: function (timer, $ul, speed) {
        var height = $ul.height();
        timer = setInterval(function () {
            var $li = $('li:first');
            $li.animate({
                'margin-top': -height + 'px'
            }, 500, function () {
                $li.css('margin-top', 0).appendTo($ul);
            });
        }, speed || 50);
    },
    getRandomInt : function(min,max){
        return Math.floor(Math.random() * (max - min + 1)) + min;
    },
    log : function log(){
        if (arguments.length === 1) {
            console.log(arguments[0]);
        }else{
            console.log(arguments);
        }
    }
};
module.exports = Y;