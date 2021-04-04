<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="name">欢迎，${loginUsername}</div>
<div id="message"></div>
<button onclick="accessServer()">访问服务器</button>
</body>
<script type="text/javascript">
    var websocket = null;
    var host = document.location.host;
    alert(host);
    var username = "${loginUsername}"; // 获得当前登录人员的userName
    setMessageInnerHTML(host + "\r\n" + username);
    // setMessageInnerHTML(username)
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        setMessageInnerHTML("浏览器支持Websocket")
        websocket = new WebSocket('ws://' + host + '/webSocket/' + username);
    } else {
        setMessageInnerHTML('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误")
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功")
        setMessageInnerHTML("WebSocket连接成功");
        // websocket.send("{\"message\":\"hello\"}");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML("接收到消息的回调方法")
        setMessageInnerHTML("这是后台推送的消息：" + event.data);
        // websocket.close();
        // setMessageInnerHTML("webSocket已关闭！")
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }
    function accessServer(){
        if (websocket.readyState===1) {
            websocket.send("{\"message\":\"hello\"}");
        }else {
            setMessageInnerHTML("websocket未连接，websocket.readyState="+websocket.readyState);
        }
    }
</script>
</html>
