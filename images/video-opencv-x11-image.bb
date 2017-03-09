SUMMARY = "An image with gstreamer and other audio and video tools. Tested with framebuffer backend"
HOMEPAGE = "https://github.com/FrankBau/raspi-repo-manifest"
LICENSE = "MIT"

# for basic stuff like gcc and make
require console-image.bb

# strictly speaking, X11 is not required for OpenCV 
# but its very convenient for visual debugging
# make sure that local.conf contains a line
# DISTRO_FEATURES_append = " x11"
REQUIRED_DISTRO_FEATURES = "x11"
IMAGE_FEATURES += " x11-base"

IMAGE_INSTALL_append += " opencv opencv-dev cmake"
IMAGE_INSTALL_append += " gstreamer1.0-omx gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-rtsp-server"

# gstreamer1.0-plugins-bad gave errors:
# * opkg_solver_install: Cannot install package gstreamer1.0-omx.
# * check_conflicts_for: The following packages conflict with userland:
# * check_conflicts_for: 	libgl-mesa * 

export IMAGE_BASENAME = "video-opencv-x11-image"

