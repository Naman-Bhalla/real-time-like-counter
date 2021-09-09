var stompClient = null;

function setConnected(connected) {
    if (connected) {
        $("#likes_list").show();
    }
    else {
        $("#likes_list").hide();
    }
    $("#likes").html("");
}

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/likes', function (like_response) {
            console.log("Like Received");
            showLikes(like_response);
        });
    });
}

function sendLike() {
    stompClient.send("/app/like", {}, JSON.stringify({
        'systemTime': new Date().toTimeString(),
    }));
}

function showLikes(message) {
    console.log(message);
    message = JSON.parse(message.body);

    $("#likes-count").html("Current Likes Count: " + message.currentLikeCount);
    $("#likes-time-latest").html("Latest Like Timestamp: " + message.latestLike.systemTime);
}

$(function () {
    $( "#like" ).click(function() { sendLike(); });
});

window.onload = function () {
    connect();
}