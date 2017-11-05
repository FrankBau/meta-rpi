SUMMARY = "An image with gstreamer and other audio and video tools. Tested with framebuffer backend"
HOMEPAGE = "https://github.com/FrankBau/raspi-repo-manifest"
LICENSE = "MIT"

# for basic stuff like gcc and make
require audio-image.bb
require console-image.bb
require qt5-image.bb

IMAGE_FEATURES+="dev-pkgs"

# can-utils has conciser command line options
IMAGE_INSTALL_remove += " \
  canutils \
"

# Qt5 example
IMAGE_INSTALL_append += " \
    cinematicexperience \
"

# SDL2
IMAGE_INSTALL_append += " \
    libsdl2-dev \
"

# toolbox
IMAGE_INSTALL_append += " \
  nano \
  cpufrequtils \
  strace \
  perf \
  tree \
  htop \
  tcpdump \
  i2c-tools \
  can-utils \
  usbutils \
  spitools \
  iperf3 \
  stress \
  cmake \
  automake \
  autoconf \
  git \
  subversion \
  wget \
  e2fsprogs \
  tzdata \
  watchdog \
  start-stop-daemon \
  logrotate \
"

IMAGE_INSTALL_append += " packagegroup-rpi-test"
IMAGE_INSTALL_append += " v4l-utils"

# https://www.opencv.org
IMAGE_INSTALL_append += " \
  opencv \
  ffmpeg \
"

# https://gstreamer.freedesktop.org
IMAGE_INSTALL_append += " \
  glib-2.0 \
  gstreamer1.0 \
  gstreamer1.0-omx \
  gstreamer1.0-plugins-base \
  gstreamer1.0-plugins-good \
  gstreamer1.0-plugins-bad \
  gstreamer1.0-plugins-ugly \
  gstreamer1.0-libav \
  gstreamer1.0-rtsp-server \
"

# web server stuff
IMAGE_INSTALL_append += " \
  lighttpd \
  lighttpd-module-fastcgi \
  php \
  php-cli \
"

# for WiFi client & access point
IMAGE_INSTALL_append += " \
  crda \
  iw \
  wireless-tools \
  wpa-supplicant \
  hostapd \
  dnsmasq \
  iptables \
  rfkill \
"

# blueetooth stuff
IMAGE_INSTALL_append += " \
  bluez5 \
  bluez5-noinst-tools \
"

# lttng tracing tools, see http://lttng.org/docs/
IMAGE_INSTALL_append += " \
  lttng-tools \
  lttng-modules \
  lttng-ust \
  babeltrace \
"

# needs tzdata
set_local_timezone() {
  ln -sf /usr/share/zoneinfo/Europe/Paris ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
  set_local_timezone ; \
"

export IMAGE_BASENAME = "audio-video-qt5-opencv-image"

