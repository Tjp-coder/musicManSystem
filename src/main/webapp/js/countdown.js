function countdown() {
    var seconds = 3;
    var countdownElement = document.getElementById("countdown");

    //每隔一秒设置一次文字
    var countdownInterval = setInterval(function() {
        seconds--;
        countdownElement.textContent = seconds + "秒后进入系统 ... ";

        //跳转页面
        if (seconds === 0) {
            clearInterval(countdownInterval);
            window.location.href = "showAllMusics";
        }
    }, 1000);
}