FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant.init"

inherit update-rc.d

INITSCRIPT_NAME = "wpa_supplicant"
INITSCRIPT_PARAMS = "defaults"

do_install:append() {
    install -d ${D}/etc/init.d/
    install -m 0755 ${WORKDIR}/wpa_supplicant.init ${D}/etc/init.d/wpa_supplicant
}

FILES:${PN} += "/etc/init.d/wpa_supplicant"
