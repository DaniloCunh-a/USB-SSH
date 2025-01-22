
SUMMARY = "A library to integrate the MFRC522 RFID readers with the Raspberry Pi"
HOMEPAGE = "https://github.com/pimylifeup/MFRC522-python"
AUTHOR = "Pi My Life Up <support@pimylifeup.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;md5=23d8a293c8d07a3d0cbd027c949bbfe1"

SRC_URI = "https://files.pythonhosted.org/packages/3c/34/f2e893baa79d82d4faad8abb7c5c0fcd138d367f6f38071f7afe883f65a2/mfrc522-0.0.7.tar.gz"
SRC_URI[md5sum] = "325c57fcb1cb452991d58ac4b88f44d6"
SRC_URI[sha256sum] = "74c7020a4fc4870f5d7022542c36143fba771055a2fae2e5929e6a1159d2bf00"

S = "${WORKDIR}/mfrc522-0.0.7"

RDEPENDS_${PN} = "python3-rpi-gpio python3-spidev"

inherit setuptools3
