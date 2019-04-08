var stompClient = null

export function connect() {
    const socket = new SockJS('/gs-guide-websocket')
    stompClient = Stomp.over(socket)
    stompClient.connect({}, frame => {
        console.log('Connected: ' + frame)
            //showGreeting(JSON.parse(greeting.body).content)
        })
    })
}

export function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    setConnected(false)
    console.log("Disconnected")
}

export function sendMessage(message) {
    stompClient.send("/app/hello", {}, JSON.stringify(message)
}