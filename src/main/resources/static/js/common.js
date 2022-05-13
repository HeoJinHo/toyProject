/** Ajax Get 호출 */
function getAjax(url, callback) {
    console.log('url : ' + url);
    $.get( url, function( data ) {
        console.log(JSON.stringify(data));
        callback(data);
    });
}

/** Ajax Post 호출 */
function postAjax(url, params, callback) {
    console.log('url : ' + url);
    console.log('params : ' + JSON.stringify(params));
    $.ajax({
        type : 'POST',
        url : url,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType : 'json',
        data : JSON.stringify(params),
        success : function( data ) {
            console.log(JSON.stringify(data));
            callback(data);
        },
        error: function (jqXHR, exception) {
            console.log(jqXHR);
            console.log(exception);
            alert(exception);
        }
    });
}

/** Ajax Post 호출 */
function postAjaxForm(url, params, callback) {
    console.log('url : ' + url);
    console.log('params : ' + JSON.stringify(params));
    $.ajax({
        type : 'POST',
        url : url,
        dataType : 'json',
        data : params,
        success : function( data ) {
            console.log(JSON.stringify(data));
            callback(data);
        },
        error: function (jqXHR, exception) {
            console.log(jqXHR);
            console.log(exception);
            alert(exception);
        }
    });
}





/**
 * 시간 지연
 * @param delay (1000 1초)
 * @returns
 */
function sleep (delay) {
    var start = new Date().getTime();
    while (new Date().getTime() < start + delay);
}


