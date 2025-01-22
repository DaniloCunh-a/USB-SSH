SUMMARY = "Teste de comunicação SPI"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}:"


SRC_URI = "file://setup.py \
           file://spitest/__init__.py \
           file://spitest/main.py"

S = "${WORKDIR}" 

inherit setuptools3 

do_install:append () { 
    install -d ${D}${bindir}
} 

