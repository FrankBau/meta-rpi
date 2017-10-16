# see https://patchwork.openembedded.org/patch/139701/

do_install_append() {
    mv ${D}${bindir}/nosetests ${D}${bindir}/nosetests3
}

