#!/bin/sh
set -e

host="$1"
shift
cmd="$@"

url="http://$host:8080/api/hello"

until curl -s $url > /dev/null; do
  >&2 echo "Backend is unavailable - sleeping"
  echo $url
  sleep 1
done

>&2 echo "Backend is up - executing command"
exec $cmd
