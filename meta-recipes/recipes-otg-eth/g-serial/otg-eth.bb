SUMARY = "Recipe for ETH - OTG"
LICENSE = "MIT"

SRC_URI += "file://gadget_eth.sh \
            file://update.sh \
            file://.ssh/"



LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


S = "${WORKDIR}"


inherit update-rc.d

INITSCRIPT_NAME = "gadget_eth"
INITSCRIPT_PARAMS = "start 99 2 3 4 5 ."

do_install() {
    
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/gadget_eth.sh ${D}${sysconfdir}/init.d/gadget_eth
    
    install -d ${D}/home/root/
    install -m 0755 ${S}/update.sh ${D}/home/root/update.sh

    install -d ${D}/home/root/.ssh
    cp -r ${S}/.ssh/* ${D}/home/root/.ssh
    chmod 700 ${D}/home/root/.ssh
    chmod 600 ${D}/home/root/.ssh/*
    
}

INSANE_SKIP:${PN} = "${ERROR_QA} ${WARN_QA}"
FILES:${PN} += "/home/root"

