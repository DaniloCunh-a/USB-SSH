SUMMARY = "Diebold Image for Products"
DESCRIPTION = "This image contain all basic packages for installation of products Diebold"

inherit core-image


IMAGE_INSTALL = "packagegroup-core-boot \
                 ncurses \
                 usbutils \
                 libtool \
                 net-tools \
                 strace \
                 run-postinsts \
                 ldd \
                 libubootenv-bin \
                 otg-eth \
                 memtester \
                 dtc \
                 weston \
                 libsdl2 \
                 spidev-test \
                 spitools \
                 mmc-utils \
                 swupdate \
                 xinit \
                 weston-init \
                 picocom \
                 sshfs-fuse \
                 libdrm \
                 xterm \
                 ${CORE_IMAGE_EXTRA_INSTALL}"

#IMAGE_ROOTFS_MAXSIZE ?= "2004800"
IMAGE_OVERHEAD_FACTOR?="1.0"
#1004800
#100MB in KB base 2
IMAGE_ROOTFS_SIZE ?= "260480"

#IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
EXTRA_USERS_PARAMS = " usermod -p '$(openssl passwd -6 12345)' root;"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image features_check

