set -x

DISCORD_BOT_TOKEN="$1"
DISCORD_SERVER_ID="$2"
DB_HOST="$3"
DB_PORT="$4"
DB_USER="$5"
DB_PASSWORD="$6"
DB_NAME="$7"
FILE="$8"

echo "DISCORD_BOT_TOKEN=$DISCORD_BOT_TOKEN DISCORD_SERVER_ID=$DISCORD_SERVER_ID DB_HOST=$DB_HOST DB_PORT=$DB_PORT DB_USER=$DB_USER DB_PASSWORD=$DB_PASSWORD DB_NAME=$DB_NAME FILE=$FILE"
echo "$DISCORD_BOT_TOKEN $DISCORD_SERVER_ID $DB_HOST $DB_PORT $DB_USER $DB_PASSWORD $DB_NAME $FILE" > ~/test.txt

jq '.discord_bot_token = "'"$DISCORD_BOT_TOKEN"'"' $FILE
jq '.discord_server_id = "'"$DISCORD_SERVER_ID"'"' $FILE
jq '.database_host = "'"$DB_HOST"'"' $FILE
jq '.database_port = "'"$DB_PORT"'"' $FILE
jq '[ .[] | .database_port = (.database_port | tonumber) ]' $FILE
jq '.database_user = "'"$DB_USER"'"' $FILE
jq '.database_password = "'"$DB_PASSWORD"'"' $FILE
jq '.database_name = "'"$DB_NAME"'"' $FILE
