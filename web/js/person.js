$("#queryunit").on("click", function () {
    let val = $("#unitAccNum").val().trim();
    if (val != "") {
        let href = "queryUnit?unitAccNum=" + val;
        $(this).attr("href", href);
    } else {
        $(this).attr("#");
    }
});