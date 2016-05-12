$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8081/media/1"
    }).then(function(data) {
       $('.media-id').append(data.id);
       $('.media-title').append(data.title);
    });
});