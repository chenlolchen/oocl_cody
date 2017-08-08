/**
 * Created by CHENCO7 on 8/7/2017.
 */
function HttpMethod(uri_prefix) {

    this.uri_prefix = uri_prefix;

    this.get = function (uri, params, successCallback, failCallback) {
        if (jQuery.isFunction(params)) {
            failCallback = failCallback || successCallback;
            successCallback = params;
            params = undefined;
        }

        return this.ajaxRequest('GET', uri, params, successCallback, failCallback);
    };

    this.post = function (uri, params, successCallback, failCallback) {
        return this.ajaxRequest('POST', uri, params, successCallback, failCallback);
    };

    this.put = function (uri, params, successCallback, failCallback) {
        return this.ajaxRequest('PUT', uri, params, successCallback, failCallback);
    };

    this.patch = function (uri, params, successCallback, failCallback) {
        return this.ajaxRequest('PATCH', uri, params, successCallback, failCallback);
    };

    this.delete = function (uri, successCallback, failCallback) {
        return this.ajaxRequest('DELETE', uri, undefined, successCallback, failCallback);
    };

    this.getURI = function (uri) {
        return this.uri_prefix + '/' + uri;
    };

    this.ajaxRequest = function (method, uri, params, successCallback, failCallback) {
        var content_type = 'application/json';

        return $.ajax({
            url: this.getURI(uri),
            type: method,
            dataType: 'json',
            contentType: content_type,
            data: params
        }).done(function (response) {
            successCallback(response);
        }).fail(function () {
            console.log("http error")
        });
    }
}

window.httpMethod = new HttpMethod("/springJsonTest");