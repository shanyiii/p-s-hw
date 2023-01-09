function getContent(zone){
    $(".card-group").empty();
    $.ajax({
        url: '/sightseeing?zone=' + zone,
        type: "get",
        dataType: "JSON",
        success: res => {
            console.log(res)
            for(i = 0; i < res.length; i++){
                console.log(res[i]["sightName"])
                $(".card-group").append(
                    '<div class="col-sm-4">' +
                    '<div class="card-body">' +
                    '<h4 class="card-title">' + res[i]["sightName"] + '</h4>' +
                    '<p class="card-text">區域：' + res[i]["zone"] + '</p>' + '<br>' +
                    '<p class="card-text">類別：' + res[i]["category"] + '</p>' +
                    '<button data-bs-toggle="collapse" data-bs-target="#detail' + i +'">詳細資訊</button>' + '<br>' +
                    '<a href=https://www.google.com.tw/maps/search/?api=1&query=' + res[i]["sightName"] + ' target="_blank" class="card-link">' +
                    res[i]["address"] + '</a>' +
                    '<div id="detail' + i + '" class="collapse">' + '<img src=' + res[i]["photoURL"] + ' width=100%>' +
                     res[i]["description"] + '</div>' +
                    '</div>' + '</div>'
                )
            }
        },
        error: err => {
            console.log("error!")
        },
    })
}