PACKAGECONFIG ?= "gles2"
EXTRA_OECONF_append = " --host=arm-raspberry-linux-gnueabihf"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://0001-egl-gles-video-driver-for-raspi.patch"

