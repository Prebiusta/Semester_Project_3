var request = new XMLHttpRequest();
var serverUrl = "http://192.168.87.103:8080/";

function Post(jsonData, PostWhere) {
    request.open('POST', serverUrl + PostWhere, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            alert("POST successful");
            return true;
        } else {
            alert("POST not successful");
            return false;
        }
    }
    request.send(jsonData);
}

function Get(FromWhere) {
    request.open('GET', serverUrl + FromWhere, true);
    request.onload = function () {
        return request.responseText;
    }
}