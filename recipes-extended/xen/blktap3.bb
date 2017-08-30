DESCRIPTION = "blktap3"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://LICENSE;md5=a9e8593dad23434929bc6218a17b5634"
DEPENDS = "xen" 

PV = "0+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/mahantesh-ais/blktap3.git;protocol=https;branch=master \
	file://blktap3-vhd-encryption-support.patch \
	file://blktap3-vhd-keyhash-support.patch \
	file://blktap3-miscellaneous-oxt-fixes.patch \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep xenclient

do_configure_prepend() {
	touch ${S}/EXTRAVERSION
}

do_install_append() {
	rm -rf ${D}/usr/lib/systemd
}
