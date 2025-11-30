javac TcpServer.java TcpClient.java
▶️ How to run
1️⃣ Start the server
bash
Copy code
java TcpServer
2️⃣ In a second terminal, start the client
bash
Copy code
java TcpClient
✔ Expected Output
Server terminal
arduino
Copy code
Server listening on port 8080...
Client connected.
Client: Hello from Client!
Hello message sent. Closing server.
Client terminal
pgsql
Copy code
Hello message sent.
Server: Hello from Server!

▶️ How to run
1️⃣ Compile both
javac TcpFileServer.java TcpFileClient.java

2️⃣ Run server
java TcpFileServer

3️⃣ Run client (in another terminal)
java TcpFileClient

📌 Notes

Make sure sample.txt (or any requested file) exists in the server directory.

After transfer, the client will store the file as:

received_sample.txt


If you want, I can also provide:
🔹 README.md
🔹 Multi-client version
🔹 Progress bar for file transfer
🔹 GUI file transfer (Java Swing)

---

## 🚀 Push to GitHub

```bash
# Navigate to project folder
cd /Users/swapnilchidrawar/Desktop/tcp

# Initialize git repository
git init

# Add all files
git add .

# Commit changes
git commit -m "Initial commit: TCP server/client implementation"

# Create a new repository on GitHub, then add remote
git remote add origin https://github.com/YOUR_USERNAME/tcp.git

# Push to GitHub
git push -u origin main
```

> 💡 Replace `YOUR_USERNAME` with your GitHub username and `tcp` with your repository name.