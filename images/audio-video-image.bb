SUMMARY = "A console image with gstreamer and other audio and video tools. Tested with framebuffer backend"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

require audio-image.bb

IMAGE_INSTALL_append += " cpufrequtils htop strace perf"
IMAGE_INSTALL_append += " packagegroup-rpi-test"
IMAGE_INSTALL_append += " v4l-utils yavta"
IMAGE_INSTALL_append += " gstreamer1.0-omx gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server"
IMAGE_INSTALL_append += " bluez5"
IMAGE_INSTALL_append += " hostapd dnsmasq iptables rfkill"
IMAGE_INSTALL_append += " lighttpd php"

export IMAGE_BASENAME = "console-image-gstreamer"

