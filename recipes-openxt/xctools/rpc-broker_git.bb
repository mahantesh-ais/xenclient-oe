DESCRIPTION = "RPC Broker"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = "json-c libwebsockets libv4v dbus libxml2"

PV = "0+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "https://github.com/tijko/xctools.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH} \
           file://rpc-broker.initscript                                                                           \
           file://rpc-broker.rules                                                                                \
          "

S = "${WORKDIR}/git/rpc-broker"

INITSCRIPT_NAME = "rpc-broker"
INITSCRIPT_PARAMS = "defaults 70"


inherit autotools pkgconfig update-rc.d

do_install_append() {
    install -m 0755 -d ${D}/etc
    install -m 0755 -d ${D}/etc/init.d
    install -m 0755 ${WORKDIR}/rpc-broker.initscript ${D}${sysconfdir}/init.d/rpc-broker
    install -m 0644 ${WORKDIR}/rpc-broker.rules ${D}/etc/rpc-broker.rules
}
