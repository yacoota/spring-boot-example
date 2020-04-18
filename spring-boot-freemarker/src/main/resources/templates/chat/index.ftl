<!DOCTYPE HTML>
<html>
<head>
    <title>聊天框</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${rc.contextPath}/webjars/bootstrap/4.4.1/dist/css/bootstrap.css"/>
    <script src="${rc.contextPath}/webjars/jquery/3.5.0/dist/jquery.js"></script>
    <script src="${rc.contextPath}/webjars/bootstrap/4.4.1/dist/js/bootstrap.js"></script>
    <script src="${rc.contextPath}/webjars/sockjs-client/1.4.0/dist/sockjs.js"></script>
    <script src="${rc.contextPath}/webjars/stomp-websocket/2.3.3/stomp.js"></script>
    <style>
        * {
            margin: 2px;
            padding: 2px;
        }
    </style>
</head>
<body>
<div id="chat01" style="border:1px solid red;">
    <div name="title">第一个微信</div>
    <div>
        <div>
            <textarea rows="3" cols="50" name="win1"> </textarea>
            <textarea rows="3" cols="50" name="win2"> </textarea>
            <textarea rows="3" cols="50" name="win3"> </textarea>
        </div>
        <div>
            <span>接收人:</span> <input name="receiver" value=""/>
            <input name="smsg" type="button" value="私有消息"/>
            <input name="pmsg" type="button" value="公共消息"/>
            <input name="zmsg" type="button" value="精准发送"/>
            <input name="start" type="button" value="连接"/>
            <input name="stop" type="button" value="断开"/>
        </div>
    </div>
    <div name="output"></div>
</div>

<div id="chat02" style="border:1px solid red;">
    <div name="title">第二个微信</div>
    <div>
        <div>
            <textarea rows="3" cols="50" name="win1"> </textarea>
            <textarea rows="3" cols="50" name="win2"> </textarea>
            <textarea rows="3" cols="50" name="win3"> </textarea>
        </div>
        <div>
            <span>接收人:</span> <input name="receiver" value=""/>
            <input name="smsg" type="button" value="私有消息"/>
            <input name="pmsg" type="button" value="公共消息"/>
            <input name="zmsg" type="button" value="精准发送"/>
            <input name="start" type="button" value="连接"/>
            <input name="stop" type="button" value="断开"/>
        </div>
    </div>
    <div name="output"></div>
</div>

<div id="chat03" style="border:1px solid red;">
    <div name="title">第三个微信</div>
    <div>
        <div>
            <textarea rows="3" cols="50" name="win1"> </textarea>
            <textarea rows="3" cols="50" name="win2"> </textarea>
            <textarea rows="3" cols="50" name="win3"> </textarea>
        </div>
        <div>
            <span>接收人:</span> <input name="receiver" value=""/>
            <input name="smsg" type="button" value="私有消息"/>
            <input name="pmsg" type="button" value="公共消息"/>
            <input name="zmsg" type="button" value="精准发送"/>
            <input name="start" type="button" value="连接"/>
            <input name="stop" type="button" value="断开"/>
        </div>
    </div>
    <div name="output"></div>
</div>

</body>
<script type="text/javascript">
    $().ready(function () {
        $("[id^=chat]").each(function (index,item) {
            var _this = $(item);

            $(_this).find(":button").attr("disabled", true);
            $(_this).find("[name=start]").attr("disabled", false);

            $(this).find("[name=start]").bind("click", function () {
                var sock = new SockJS('http://127.0.0.1:15556/ws');
                var stomp = Stomp.over(sock);
                _this.data({"sock": sock, "stomp": stomp});
                //建立连接监听
                stomp.connect({token: _this.attr("id")}, function (frame) {
                    stomp.subscribe('/topic/public', function (response) {
                        $(_this).find("[name=output]").append('<b>公共消息：' + response.body + '</b><br/>');
                    });
                    stomp.subscribe("/user/queue/chat", function (response) {
                        $(_this).find("[name=output]").append('<b>私有消息：' + response.body + '</b><br/>');
                    });
                    $(_this).find("[name=title]").text(  "第"+ (index+1 )+"个微信" + ":" + frame.headers["user-name"]);
                });
                $(_this).find("[name=start]").attr("disabled", true);
                $(_this).find("[name*=msg],[name=stop]").attr("disabled", false);
            });
            $(this).find("[name=stop]").bind("click", function () {
                _this.data("sock").close();
                $(_this).find(":button").attr("disabled", true);
                $(_this).find("[name=start]").attr("disabled", false);
            });

            // 公共消息
            $(this).find("[name=pmsg]").bind("click", function () {
                var stomp = _this.data("stomp");
                stomp.send("/application/gmessage", {}, JSON.stringify({
                    'message': $(_this).find("[name=win1]").val()
                }));
            });

            // 私有消息
            $(this).find("[name=smsg]").bind("click", function () {
                var stomp = _this.data("stomp");
                stomp.send("/application/smessage", {}, JSON.stringify({
                    'message': $(_this).find("[name=win1]").val(),
                    'receiver': $(_this).find("[name=receiver]").val()
                }));
            });

            // 精准发送
            $(this).find("[name=zmsg]").bind("click", function () {
                var stomp = _this.data("stomp");
                stomp.send("/application/message.precise", {}, JSON.stringify({
                    'message': $(_this).find("[name=win1]").val(),
                    'receiver': $(_this).find("[name=receiver]").val()
                }));
            });

        });
    });
</script>
</html>