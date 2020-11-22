xhost +"local:docker@"
sudo docker run -e DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix  romangvk/search-project