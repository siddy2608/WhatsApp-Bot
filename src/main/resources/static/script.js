async function sendMessage() {
  const input = document.getElementById("messageInput");
  const chatBox = document.getElementById("chatBox");
  const message = input.value.trim();

  if (!message) return;

  input.value = "";

  const userMsg = document.createElement("div");
  userMsg.className = "msg user";
  userMsg.textContent = message;
  chatBox.appendChild(userMsg);
  chatBox.scrollTop = chatBox.scrollHeight;

  const typing = document.createElement("div");
  typing.className = "msg bot typing";
  typing.innerHTML = "<span></span><span></span><span></span>";
  chatBox.appendChild(typing);
  chatBox.scrollTop = chatBox.scrollHeight;

  try {
    const res = await fetch("/webhook", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ from: "user", message })
    });

    const data = await res.json();
    typing.remove();

    const botMsg = document.createElement("div");
    botMsg.className = "msg bot";
    botMsg.textContent = data.reply;
    chatBox.appendChild(botMsg);
  } catch {
    typing.remove();
    const err = document.createElement("div");
    err.className = "msg bot";
    err.textContent = "Couldn't reach the server.";
    chatBox.appendChild(err);
  }

  chatBox.scrollTop = chatBox.scrollHeight;
}

document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("sendButton").addEventListener("click", sendMessage);
  document.getElementById("messageInput").addEventListener("keydown", e => {
    if (e.key === "Enter") sendMessage();
  });
});
