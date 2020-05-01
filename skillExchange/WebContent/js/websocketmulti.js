var MyPoint = "/DemoWSmulti";
	var host = window.location.host;
//	console.log(host);
	var path = window.location.pathname;
//	console.log(path);
	var webCtx = path.substring(0, path.indexOf('/', 1));
//	console.log(webCtx);
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
//	console.log(endPointURL);
	var statusOutput = document.getElementById("statusOutput");
	var webSocket;

	
	
	function connect() {
		document.getElementById("catalog").style.display='block';
		output = document.getElementById("output");
		// create a websocket
		webSocket = new WebSocket(endPointURL);

		webSocket.onopen = function(event) {
			onOpen(event)
		};

		webSocket.onmessage = function(event) {
			onMessage(event)
		};

		webSocket.onclose = function(event) {
			onClose(event)
		};
		webSocket.onerror = function(event) {
			onError(event)
		};
	}
	function onOpen(evt) { //連線時觸發
       writeToScreen("<p style='background-color:#ddd' class='rounded-lg text-center text-secondary py-2'>向對方打個招呼吧</p>");
	 
	}
	function onMessage(evt) { //收到訊息時觸發
		writeToScreen( evt.data);
		// 		websocket.close();
	}
	function onClose(evt) { //關閉連線時時觸發
// 		writeToScreen("DISCONNECTED");
	}

	function onError(evt) {
		writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
	}

	function sendMessage() {

		var inputMessage = document.getElementById("textmssg");
		var message = inputMessage.value.trim();

		if (message === "") {
			alert("Input a message");
			inputMessage.focus();
		} else {
			// 			writeToScreen("SENT: " + message);
			webSocket.send(message); //!!!! 送留言到endpoint
			inputMessage.value = "";
			inputMessage.focus();
		}
	}

	function disconnect() {
		webSocket.close();
	}

    var cardbody= document.getElementById("cardbody");
	function writeToScreen(message) {
		console.log(message)
		cardbody.innerHTML+=message;
	}
	// 	window.addEventListener("load", init, false);