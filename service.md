# Créer un service
sudo vi /etc/systemd/system/lbdb.service


[Unit]
Description=LBDB bot discord
Requires=network.target remote-fs.target
After=network.target remote-fs.target

[Service]
Type=simple
User=lbdb
WorkingDirectory=/opt/lbdb/bot/
ExecStart=java -cp "/opt/lbdb/bot/target/epgp-discord-bot-0.0.1-jar-with-dependencies.jar:/opt/lbdb/bot/vendor/JDA.jar" com.epgpbot.transport.discord.DiscordBotLauncher /opt/lbdb/bot/config.json
Restart=on-failure
RestartSec=10

[Install]
WantedBy=multi-user.target


sudo systemctl daemon-reload
sudo systemctl start lbdb.service
sudo systemctl status lbdb.service
